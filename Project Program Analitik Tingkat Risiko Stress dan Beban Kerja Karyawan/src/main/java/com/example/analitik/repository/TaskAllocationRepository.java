package com.example.analitik.repository;

import com.example.analitik.model.TaskAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskAllocationRepository extends JpaRepository<TaskAllocation, Long> {
    List<TaskAllocation> findByEmployeeIdOrderByDeadlineAsc(Long employeeId);
}
