package com.example.analitik.service;

import com.example.analitik.dto.ProfileDtos;
import com.example.analitik.model.*;
import com.example.analitik.repository.*;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final UserRepository users;
    private final DepartmentRepository departments;
    private final EmployeeProfileRepository profiles;

    public ProfileService(UserRepository users, DepartmentRepository departments,
                          EmployeeProfileRepository profiles) {
        this.users = users;
        this.departments = departments;
        this.profiles = profiles;
    }

    public ProfileDtos.ProfileResponse saveOrUpdate(String email, ProfileDtos.ProfileRequest req) {
        User user = users.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));
        Department department = req.departmentId() == null ? null :
                departments.findById(req.departmentId())
                        .orElseThrow(() -> new IllegalArgumentException("Departemen tidak ditemukan"));

        EmployeeProfile p = profiles.findByUserId(user.getId()).orElse(
                EmployeeProfile.builder().user(user).build()
        );

        p.setFullName(req.fullName());
        p.setEmployeeNumber(req.employeeNumber());
        p.setPosition(req.position());
        p.setDepartment(department);
        p.setPhone(req.phone());

        return map(profiles.save(p));
    }

    public ProfileDtos.ProfileResponse get(String email) {
        User user = users.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));
        return profiles.findByUserId(user.getId()).map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Biodata belum diisi"));
    }

    private ProfileDtos.ProfileResponse map(EmployeeProfile p) {
        return new ProfileDtos.ProfileResponse(
                p.getUser().getId(), p.getUser().getEmail(), p.getUser().getRole().name(),
                p.getFullName(), p.getEmployeeNumber(), p.getPosition(),
                p.getDepartment() == null ? null : p.getDepartment().getId(),
                p.getDepartment() == null ? null : p.getDepartment().getName(),
                p.getPhone()
        );
    }
}
