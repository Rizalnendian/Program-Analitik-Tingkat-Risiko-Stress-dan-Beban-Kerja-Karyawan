package com.example.analitik.repository;

import com.example.analitik.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByEmployeeIdOrderBySubmittedAtDesc(Long employeeId);
    List<Survey> findAllByOrderBySubmittedAtDesc();
}
