package com.example.analitik.service;

import com.example.analitik.dto.AuthDtos;
import com.example.analitik.model.Role;
import com.example.analitik.model.User;
import com.example.analitik.repository.UserRepository;
import com.example.analitik.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.analitik.model.Gender;

@Service
public class AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthService(UserRepository users, PasswordEncoder encoder, JwtService jwt) {
        this.users = users;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    public AuthDtos.AuthResponse signup(AuthDtos.SignupRequest req) {

    if (users.existsByEmail(req.email().toLowerCase())) {
        throw new IllegalArgumentException("Email sudah terdaftar");
    }

    Role role;

    try {
        role = Role.valueOf(
                req.role().trim().toUpperCase()
        );
    } catch (Exception e) {
        throw new IllegalArgumentException(
                "Role harus KARYAWAN atau MANAJER"
        );
    }

    Gender gender;

    String normalizedGender = req.gender()
            .trim()
            .toUpperCase()
            .replace("-", "_")
            .replace(" ", "_");

    try {
        gender = Gender.valueOf(normalizedGender);
    } catch (Exception e) {
        throw new IllegalArgumentException(
                "Jenis kelamin harus Laki-Laki atau Perempuan"
        );
    }

    User user = users.save(
        User.builder()
            .fullName(req.fullName().trim())
            .email(req.email().toLowerCase())
            .password(encoder.encode(req.password()))
            .gender(gender)
            .role(role)
            .build()
    );

    return new AuthDtos.AuthResponse(
            jwt.generateToken(
                    user.getEmail(),
                    role.name()
            ),
            user.getEmail(),
            user.getFullName(),
            gender == Gender.LAKI_LAKI
                    ? "Laki-Laki"
                    : "Perempuan",
            role.name()
    );
}

    public AuthDtos.AuthResponse login(AuthDtos.LoginRequest req) {
        User user = users.findByEmail(req.email().toLowerCase())
                .orElseThrow(() -> new IllegalArgumentException("Email atau password salah"));

        if (!encoder.matches(req.password(), user.getPassword())) {
            throw new IllegalArgumentException("Email atau password salah");
        }

        return new AuthDtos.AuthResponse(
        jwt.generateToken(
                user.getEmail(),
                user.getRole().name()
        ),
        user.getEmail(),
        user.getFullName(),
        user.getGender() == Gender.LAKI_LAKI
                ? "Laki-Laki"
                : "Perempuan",
        user.getRole().name()
);
    }
}
