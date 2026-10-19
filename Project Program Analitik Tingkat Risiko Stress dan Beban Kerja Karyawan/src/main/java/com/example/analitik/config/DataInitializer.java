package com.example.analitik.config;

import com.example.analitik.model.Department;
import com.example.analitik.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seedDepartments(DepartmentRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(Department.builder().name("HR").build());
                repo.save(Department.builder().name("IT").build());
                repo.save(Department.builder().name("Finance").build());
                repo.save(Department.builder().name("Marketing").build());
                repo.save(Department.builder().name("Operasional").build());
            }
        };
    }
}
