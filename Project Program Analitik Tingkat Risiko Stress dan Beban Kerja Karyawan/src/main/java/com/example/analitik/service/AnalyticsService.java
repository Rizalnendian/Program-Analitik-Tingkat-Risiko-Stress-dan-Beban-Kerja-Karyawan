package com.example.analitik.service;

import com.example.analitik.dto.AnalyticsDtos;
import com.example.analitik.model.*;
import com.example.analitik.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {
    private final UserRepository users;
    private final EmployeeProfileRepository profiles;
    private final DepartmentRepository departments;
    private final SurveyRepository surveys;

    public AnalyticsService(UserRepository users, EmployeeProfileRepository profiles,
                            DepartmentRepository departments, SurveyRepository surveys) {
        this.users = users;
        this.profiles = profiles;
        this.departments = departments;
        this.surveys = surveys;
    }

    public AnalyticsDtos.Dashboard dashboard(Long departmentId) {
        List<User> employees = users.findAll().stream()
                .filter(u -> u.getRole() == Role.KARYAWAN)
                .filter(u -> {
                    if (departmentId == null) return true;
                    return profiles.findByUserId(u.getId())
                            .map(p -> p.getDepartment() != null && p.getDepartment().getId().equals(departmentId))
                            .orElse(false);
                }).toList();

        List<AnalyticsDtos.EmployeeAnalytics> employeeRows = employees.stream()
                .map(this::employeeAnalytics)
                .filter(Objects::nonNull)
                .toList();

        double avgStress = employeeRows.stream().mapToInt(x -> x.latestStressScore() == null ? 0 : x.latestStressScore()).average().orElse(0);
        double avgWorkload = employeeRows.stream().mapToInt(x -> x.latestWorkloadScore() == null ? 0 : x.latestWorkloadScore()).average().orElse(0);

        long low = employeeRows.stream().filter(x -> "RENDAH".equals(x.stressLevel())).count();
        long medium = employeeRows.stream().filter(x -> "SEDANG".equals(x.stressLevel())).count();
        long high = employeeRows.stream().filter(x -> "TINGGI".equals(x.stressLevel())).count();

        List<AnalyticsDtos.DepartmentAnalytics> depRows = departments.findAll().stream()
                .map(d -> {
                    List<User> depEmployees = users.findAll().stream()
                            .filter(u -> u.getRole() == Role.KARYAWAN)
                            .filter(u -> profiles.findByUserId(u.getId())
                                    .map(p -> p.getDepartment() != null && p.getDepartment().getId().equals(d.getId()))
                                    .orElse(false)).toList();

                    List<AnalyticsDtos.EmployeeAnalytics> rows = depEmployees.stream()
                            .map(this::employeeAnalytics).filter(Objects::nonNull).toList();

                    double ds = rows.stream().mapToInt(x -> x.latestStressScore() == null ? 0 : x.latestStressScore()).average().orElse(0);
                    double dw = rows.stream().mapToInt(x -> x.latestWorkloadScore() == null ? 0 : x.latestWorkloadScore()).average().orElse(0);

                    return new AnalyticsDtos.DepartmentAnalytics(d.getId(), d.getName(), depEmployees.size(), ds, dw);
                }).toList();

        return new AnalyticsDtos.Dashboard(
                new AnalyticsDtos.Summary(employees.size(), avgStress, avgWorkload, low, medium, high),
                depRows,
                employeeRows
        );
    }

    private AnalyticsDtos.EmployeeAnalytics employeeAnalytics(User u) {
        var p = profiles.findByUserId(u.getId()).orElse(null);
        var latest = surveys.findByEmployeeIdOrderBySubmittedAtDesc(u.getId()).stream().findFirst().orElse(null);
        if (latest == null) return null;

        return new AnalyticsDtos.EmployeeAnalytics(
                u.getId(),
                p == null ? u.getEmail() : p.getFullName(),
                p == null || p.getDepartment() == null ? "Belum diisi" : p.getDepartment().getName(),
                latest.getStressScore(),
                latest.getWorkloadScore(),
                latest.getStressLevel().name(),
                latest.getRecommendation()
        );
    }
}
