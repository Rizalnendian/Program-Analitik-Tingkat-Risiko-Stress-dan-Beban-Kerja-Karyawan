package com.example.analitik.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "surveys")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private User employee;

    @Column(nullable = false)
    private Integer stressScore;

    @Column(nullable = false)
    private Integer workloadScore;

    // NASA-TLX dimension ratings (0-100)
    @Column private Integer mentalDemand;
    @Column private Integer physicalDemand;
    @Column private Integer temporalDemand;
    @Column private Integer performance;
    @Column private Integer effort;
    @Column private Integer frustration;

    // NASA-TLX pairwise-comparison weights (0-5; total must equal 15)
    @Column private Integer mentalDemandWeight;
    @Column private Integer physicalDemandWeight;
    @Column private Integer temporalDemandWeight;
    @Column private Integer performanceWeight;
    @Column private Integer effortWeight;
    @Column private Integer frustrationWeight;

    @Column private Integer nasaTlxScore;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StressLevel stressLevel;

    @Column(nullable = false)
    private String recommendation;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private LocalDateTime submittedAt;
}
