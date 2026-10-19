package com.example.analitik.service;

import com.example.analitik.dto.TaskDtos;
import com.example.analitik.model.*;
import com.example.analitik.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final UserRepository users;
    private final TaskAllocationRepository tasks;

    public TaskService(UserRepository users, TaskAllocationRepository tasks) {
        this.users = users;
        this.tasks = tasks;
    }

    public TaskDtos.Response create(String managerEmail, TaskDtos.CreateRequest req) {
        User manager = users.findByEmail(managerEmail).orElseThrow();
        if (manager.getRole() != Role.MANAJER) {
            throw new IllegalArgumentException("Hanya manajer yang dapat membuat alokasi tugas");
        }

        User employee = users.findById(req.employeeId())
                .orElseThrow(() -> new IllegalArgumentException("Karyawan tidak ditemukan"));

        if (req.workloadPoint() > 100) {
            throw new IllegalArgumentException("Batas alokasi tugas adalah 100 poin");
        }

        int existing = tasks.findByEmployeeIdOrderByDeadlineAsc(employee.getId())
                .stream()
                .filter(t -> t.getDeadline().isAfter(java.time.LocalDate.now().minusDays(1)))
                .mapToInt(TaskAllocation::getWorkloadPoint)
                .sum();

        if (existing + req.workloadPoint() > 100) {
            throw new IllegalArgumentException("Alokasi tugas melebihi batas 100 poin untuk karyawan tersebut");
        }

        TaskAllocation t = tasks.save(TaskAllocation.builder()
                .employee(employee)
                .manager(manager)
                .taskName(req.taskName())
                .description(req.description())
                .workloadPoint(req.workloadPoint())
                .deadline(req.deadline())
                .createdAt(LocalDateTime.now())
                .build());

        return map(t);
    }

    public List<TaskDtos.Response> mine(String email) {
        User u = users.findByEmail(email).orElseThrow();
        return tasks.findByEmployeeIdOrderByDeadlineAsc(u.getId()).stream().map(this::map).toList();
    }

    public List<TaskDtos.Response> all() {
        return tasks.findAll().stream().map(this::map).toList();
    }

    private TaskDtos.Response map(TaskAllocation t) {
        return new TaskDtos.Response(t.getId(), t.getEmployee().getId(),
                t.getEmployee().getEmail(), t.getTaskName(), t.getDescription(),
                t.getWorkloadPoint(), t.getDeadline(), t.getCreatedAt().toString());
    }
}
