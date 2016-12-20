-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2016 at 01:22 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `campustune`
--

-- --------------------------------------------------------

--
-- Table structure for table `eusers`
--

CREATE TABLE `eusers` (
  `user_id` int(50) NOT NULL,
  `name_surname` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `telephone` bigint(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `account_no` int(4) NOT NULL,
  `card_no` int(4) NOT NULL,
  `serial_no` int(4) NOT NULL,
  `expire_date` int(4) NOT NULL,
  `security_code` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eusers`
--

INSERT INTO `eusers` (`user_id`, `name_surname`, `address`, `city`, `telephone`, `email`, `username`, `password`, `account_no`, `card_no`, `serial_no`, `expire_date`, `security_code`) VALUES
(1, 'Josephat Feruzi', 'nicosia', 'girne', 5338894588, 'mutagwaba72@gmail.co', 'admin', 'admin', 1111, 2222, 3333, 419, 123),
(2, 'polycop okoi', 'cangar motor', 'morphou', 123456, 'ypoy@arsenal.com', 'okoi', '1234', 1111, 1111, 1111, 1218, 124),
(3, 'colin pastor', 'city center', 'kyrenia', 12125, 'church@gmail.com', 'col', '1234', 1112, 1112, 1111, 1218, 128),
(4, 'columbus pastor', 'city center', 'morphou', 12125, 'church@gmail.com', 'colu', '12345', 1112, 1112, 1111, 1219, 128),
(6, 'mustafa goyor', 'mersin', 'famagusta', 752580066, 'mustafa72@gmail.com', 'mustafa', '123456', 1212, 1212, 1212, 517, 144),
(8, 'mutagwaba', 'mersina', 'morphou', 12346789, 'clemence@yahoo.com', 'clemence', '12345', 1111, 1111, 1222, 1111, 444);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `eusers`
--
ALTER TABLE `eusers`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `eusers`
--
ALTER TABLE `eusers`
  MODIFY `user_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
