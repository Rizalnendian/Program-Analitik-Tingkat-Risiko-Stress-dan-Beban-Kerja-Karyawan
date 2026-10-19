package com.example.analitik.dto;

import java.util.List;

public class AnalyticsDtos {
    public record Summary(
            long totalEmployees,
            double averageStress,
            double averageWorkload,
            long low,
            long medium,
            long high
    ) {}

    public record DepartmentAnalytics(
            Long departmentId,
            String departmentName,
            long employeeCount,
            double averageStress,
            double averageWorkload
    ) {}

    public record EmployeeAnalytics(
            Long employeeId,
            String employeeName,
            String department,
            Integer latestStressScore,
            Integer latestWorkloadScore,
            String stressLevel,
            String recommendation
    ) {}

    public record Dashboard(
            Summary summary,
            List<DepartmentAnalytics> departments,
            List<EmployeeAnalytics> employees
    ) {}
}
