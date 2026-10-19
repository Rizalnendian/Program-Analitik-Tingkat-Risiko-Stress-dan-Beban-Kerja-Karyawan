CREATE DATABASE IF NOT EXISTS analitik_beban_kerja;
USE analitik_beban_kerja;

-- Spring Boot JPA akan membuat/update tabel berdasarkan entity.
-- File ini dapat dipakai untuk dokumentasi struktur database.
CREATE TABLE IF NOT EXISTS departments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    employee_number VARCHAR(30),
    position VARCHAR(100),
    department_id BIGINT,
    phone VARCHAR(30),
    CONSTRAINT fk_profile_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_profile_department FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE IF NOT EXISTS surveys (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    stress_score INT NOT NULL,
    workload_score INT NOT NULL,
    stress_level VARCHAR(20) NOT NULL,
    recommendation TEXT NOT NULL,
    notes TEXT,
    submitted_at DATETIME NOT NULL,
    CONSTRAINT fk_survey_employee FOREIGN KEY (employee_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS task_allocations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    manager_id BIGINT NOT NULL,
    task_name VARCHAR(200) NOT NULL,
    description TEXT,
    workload_point INT NOT NULL,
    deadline DATE NOT NULL,
    created_at DATETIME NOT NULL,
    CONSTRAINT fk_task_employee FOREIGN KEY (employee_id) REFERENCES users(id),
    CONSTRAINT fk_task_manager FOREIGN KEY (manager_id) REFERENCES users(id)
);
