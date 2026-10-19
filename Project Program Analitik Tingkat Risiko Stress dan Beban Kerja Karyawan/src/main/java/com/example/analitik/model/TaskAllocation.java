package com.example.analitik.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_allocations")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TaskAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private User employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id")
    private User manager;

    @Column(nullable = false, length = 200)
    private String taskName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer workloadPoint;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
