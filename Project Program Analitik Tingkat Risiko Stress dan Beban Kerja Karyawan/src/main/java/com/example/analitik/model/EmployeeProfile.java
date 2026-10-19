package com.example.analitik.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_profiles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(length = 30)
    private String employeeNumber;

    @Column(length = 100)
    private String position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(length = 30)
    private String phone;
}
