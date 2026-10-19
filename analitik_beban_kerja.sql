-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 19, 2026 at 03:32 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `analitik_beban_kerja`
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`id`, `name`) VALUES
(3, 'Finance'),
(1, 'HR'),
(2, 'IT'),
(4, 'Marketing'),
(5, 'Operasional');

-- --------------------------------------------------------

--
-- Table structure for table `employee_profiles`
--

CREATE TABLE `employee_profiles` (
  `id` bigint(20) NOT NULL,
  `employee_number` varchar(30) DEFAULT NULL,
  `full_name` varchar(100) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_profiles`
--

INSERT INTO `employee_profiles` (`id`, `employee_number`, `full_name`, `phone`, `position`, `department_id`, `user_id`) VALUES
(1, 'EMP001', 'Nana Aminah', '08123456789', 'Staff IT', 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `surveys`
--

CREATE TABLE `surveys` (
  `id` bigint(20) NOT NULL,
  `notes` text DEFAULT NULL,
  `recommendation` varchar(255) NOT NULL,
  `stress_level` enum('RENDAH','SEDANG','TINGGI') NOT NULL,
  `stress_score` int(11) NOT NULL,
  `submitted_at` datetime(6) NOT NULL,
  `workload_score` int(11) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `nasa_tlx_score` int(11) DEFAULT NULL,
  `mental_demand` int(11) DEFAULT NULL,
  `physical_demand` int(11) DEFAULT NULL,
  `temporal_demand` int(11) DEFAULT NULL,
  `performance` int(11) DEFAULT NULL,
  `effort` int(11) DEFAULT NULL,
  `frustration` int(11) DEFAULT NULL,
  `mental_demand_weight` int(11) DEFAULT NULL,
  `physical_demand_weight` int(11) DEFAULT NULL,
  `temporal_demand_weight` int(11) DEFAULT NULL,
  `performance_weight` int(11) DEFAULT NULL,
  `effort_weight` int(11) DEFAULT NULL,
  `frustration_weight` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `surveys`
--

INSERT INTO `surveys` (`id`, `notes`, `recommendation`, `stress_level`, `stress_score`, `submitted_at`, `workload_score`, `employee_id`, `nasa_tlx_score`, `mental_demand`, `physical_demand`, `temporal_demand`, `performance`, `effort`, `frustration`, `mental_demand_weight`, `physical_demand_weight`, `temporal_demand_weight`, `performance_weight`, `effort_weight`, `frustration_weight`) VALUES
(1, 'Beban pekerjaan cukup tinggi.', 'Perlu evaluasi beban kerja dan komunikasi dengan manajer/HR untuk tindak lanjut.', 'TINGGI', 65, '2026-09-30 14:55:20.000000', 75, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `task_allocations`
--

CREATE TABLE `task_allocations` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `deadline` date NOT NULL,
  `description` text DEFAULT NULL,
  `task_name` varchar(200) NOT NULL,
  `workload_point` int(11) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `manager_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `task_allocations`
--

INSERT INTO `task_allocations` (`id`, `created_at`, `deadline`, `description`, `task_name`, `workload_point`, `employee_id`, `manager_id`) VALUES
(1, '2026-10-01 09:06:56.000000', '2026-10-10', 'Membuat laporan operasional bulan September', 'Membuat laporan bulanan', 25, 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `role` enum('KARYAWAN','MANAJER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `full_name`, `email`, `password`, `gender`, `role`) VALUES
(4, 'Nana Aminah', 'nana@gmail.com', '$2a$10$EWgJ9.oqJsghwONXwVD0UuhpKz0SuOBd8xGN94Anj19n9L7B8eHLq', 'PEREMPUAN', 'KARYAWAN'),
(5, 'Budi Santoso', 'budi@gmail.com', '$2a$10$aoid8ZZfmlCGct6yAy60fums1z9Cqs19FrWCJ1heWafAMZ3peh8re', 'LAKI_LAKI', 'MANAJER'),
(6, 'Firdaus', 'firdaus.frds13@gmail.com', '$2a$10$BiV6KoFM3MIqMvhzDU51J.rddigJftnHoobddSLgbJQPqzyaWd4hC', 'LAKI_LAKI', 'MANAJER'),
(7, 'Yogi', 'yogicihuy123@gmail.com', '$2a$10$jBtdAK8.QFuamCoOULjtmOYB8BBwNdeH1ar6Vdho5r6wuHSuhCYny', 'LAKI_LAKI', 'KARYAWAN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKj6cwks7xecs5jov19ro8ge3qk` (`name`);

--
-- Indexes for table `employee_profiles`
--
ALTER TABLE `employee_profiles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK8yk3u81veuwf2re5iuf6qxkn9` (`user_id`),
  ADD KEY `FKgdxrcrxt1o6jfu1yffnps57mh` (`department_id`);

--
-- Indexes for table `surveys`
--
ALTER TABLE `surveys`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7qcqtq6q46pome442d97wwlsw` (`employee_id`);

--
-- Indexes for table `task_allocations`
--
ALTER TABLE `task_allocations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcpd45mlq5r85sbjvnaw9hyped` (`employee_id`),
  ADD KEY `FKokqixw0ox8rwqey5dl1txq3yd` (`manager_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employee_profiles`
--
ALTER TABLE `employee_profiles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `surveys`
--
ALTER TABLE `surveys`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `task_allocations`
--
ALTER TABLE `task_allocations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee_profiles`
--
ALTER TABLE `employee_profiles`
  ADD CONSTRAINT `FKeotvdthm6gd1pavuhb075uocm` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKgdxrcrxt1o6jfu1yffnps57mh` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`);

--
-- Constraints for table `surveys`
--
ALTER TABLE `surveys`
  ADD CONSTRAINT `FK7qcqtq6q46pome442d97wwlsw` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `task_allocations`
--
ALTER TABLE `task_allocations`
  ADD CONSTRAINT `FKcpd45mlq5r85sbjvnaw9hyped` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKokqixw0ox8rwqey5dl1txq3yd` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
