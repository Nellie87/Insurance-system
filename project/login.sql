-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2023 at 10:46 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

CREATE TABLE `agent` (
  `Username` text NOT NULL,
  `Password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agent`
--

INSERT INTO `agent` (`Username`, `Password`) VALUES
('Sandy', 'sandy@agent'),
('Miles', 'miles@agent'),
('Miles', 'miles@agent');

-- --------------------------------------------------------

--
-- Table structure for table `registered_users`
--

CREATE TABLE `registered_users` (
  `user_id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(50) NOT NULL,
  `mobile_number` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `insurance_due_date` date NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `car_model` varchar(50) NOT NULL,
  `number_plate` varchar(25) NOT NULL,
  `insurance_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


--
-- Dumping data for table `registered_users`
--

INSERT INTO `registered_users` (`name`, `mobile_number`, `gender`, `insurance_due_date`, `email_address`, `address`, `car_model`, `number_plate`, `insurance_type`) VALUES
('Jill', '073456789', 'Male', '1999-01-01', 'jill@gmail.com', 'Kiambu', 'Nissan', 'KJI345P', 'Third-Party Only Insurance'),
('Regina', '0734567876', 'Female', '2002-01-01', 'regina@gmail.com', 'Kisumu', 'Range rover', 'KBG789P', 'Comprehensive Insurance'),
('Brandon', '078964321', 'Male', '2002-01-01', 'brandon@gmail.com', 'Joska', 'Saloon', 'KBH789P', 'Third Party Fire and Theft Insurance'),
('Kim', '072345678', 'Male', '2003-01-01', 'kim@gmail.com', 'Watamu', 'Peugeot', 'KNM987H', 'Third Party Fire and Theft Insurance'),
('champ', '074522782', 'Female', '2004-04-06', 'champ', 'Gigiri', 'Subaru', 'KLO9087', 'Comprehensive Insurance'),
('', '', 'Male', '1999-01-01', '', '', '', '', 'Third-Party Only Insurance'),
('Rachael', '07456787', 'Female', '2008-10-08', 'rachael@gmail.com', 'Wasili', 'Demio', 'KAB123P', 'Third Party Fire and Theft Insurance'),
('Samira', '073456789', 'Female', '2002-11-04', 'samira@gmail.com', 'Kikuyu', 'Jeep', 'KFR0003', 'Comprehensive Insurance');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
