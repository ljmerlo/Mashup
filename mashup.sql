-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 01, 2019 at 04:48 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mashup`
--

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE `train` (
  `ID` int(11) NOT NULL,
  `FromLocation` varchar(30) NOT NULL,
  `ToLocation` varchar(30) NOT NULL,
  `DepartureTime` varchar(50) NOT NULL,
  `ArrivalTime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`ID`, `FromLocation`, `ToLocation`, `DepartureTime`, `ArrivalTime`) VALUES
(200, 'Bern', 'Basel SBB', '2019-02-01T14:36:00+0100', '2019-02-01T15:29:00+0100'),
(201, 'Bern', 'Basel SBB', '2019-02-01T15:04:00+0100', '2019-02-01T15:59:00+0100'),
(202, 'Bern', 'Basel SBB', '2019-02-01T15:36:00+0100', '2019-02-01T16:29:00+0100'),
(203, 'Basel SBB', 'Uster', '2019-02-01T14:37:00+0100', '2019-02-01T16:08:00+0100'),
(204, 'Basel SBB', 'Uster', '2019-02-01T15:07:00+0100', '2019-02-01T16:23:00+0100'),
(205, 'Basel SBB', 'Uster', '2019-02-01T15:33:00+0100', '2019-02-01T16:53:00+0100'),
(206, 'Uster', 'Winterthur', '2019-02-01T14:40:00+0100', '2019-02-01T15:08:00+0100'),
(207, 'Uster', 'Winterthur', '2019-02-01T14:51:00+0100', '2019-02-01T15:21:00+0100'),
(208, 'Uster', 'Winterthur', '2019-02-01T15:10:00+0100', '2019-02-01T15:38:00+0100'),
(209, 'Basel SBB', 'Effretikon', '2019-02-01T14:43:00+0100', '2019-02-01T16:20:00+0100'),
(210, 'Basel SBB', 'Effretikon', '2019-02-01T15:07:00+0100', '2019-02-01T16:36:00+0100'),
(211, 'Basel SBB', 'Effretikon', '2019-02-01T15:33:00+0100', '2019-02-01T16:50:00+0100'),
(212, 'Uster', 'Winterthur', '2019-02-01T15:51:00+0100', '2019-02-01T16:21:00+0100'),
(213, 'Uster', 'Winterthur', '2019-02-01T16:10:00+0100', '2019-02-01T16:38:00+0100'),
(214, 'Uster', 'Winterthur', '2019-02-01T16:21:00+0100', '2019-02-01T16:51:00+0100'),
(215, 'Neftenbach, Wolfzangen', 'Lufingen, Hintermarchlen', '2019-02-01T15:59:00+0100', '2019-02-01T16:43:00+0100'),
(216, 'Neftenbach, Wolfzangen', 'Lufingen, Hintermarchlen', '2019-02-01T16:16:00+0100', '2019-02-01T17:08:00+0100'),
(217, 'Neftenbach, Wolfzangen', 'Lufingen, Hintermarchlen', '2019-02-01T16:29:00+0100', '2019-02-01T17:13:00+0100'),
(218, 'Lufingen, Hintermarchlen', 'Neftenbach, Wolfzangen', '2019-02-01T16:16:00+0100', '2019-02-01T17:01:00+0100'),
(219, 'Lufingen, Hintermarchlen', 'Neftenbach, Wolfzangen', '2019-02-01T16:46:00+0100', '2019-02-01T17:31:00+0100'),
(220, 'Lufingen, Hintermarchlen', 'Neftenbach, Wolfzangen', '2019-02-01T17:16:00+0100', '2019-02-01T18:01:00+0100'),
(221, 'Bern', 'Zürich HB', '2019-02-01T16:10:00+0100', '2019-02-01T17:10:00+0100'),
(222, 'Bern', 'Zürich HB', '2019-02-01T16:32:00+0100', '2019-02-01T17:28:00+0100'),
(223, 'Bern', 'Zürich HB', '2019-02-01T17:02:00+0100', '2019-02-01T17:58:00+0100'),
(224, 'Jona', 'Uster', '2019-02-01T16:16:00+0100', '2019-02-01T16:35:00+0100'),
(225, 'Jona', 'Uster', '2019-02-01T16:31:00+0100', '2019-02-01T16:50:00+0100'),
(226, 'Jona', 'Uster', '2019-02-01T16:46:00+0100', '2019-02-01T17:05:00+0100'),
(227, 'Winterthur', 'Bern', '2019-02-01T16:31:00+0100', '2019-02-01T17:58:00+0100'),
(228, 'Winterthur', 'Bern', '2019-02-01T17:03:00+0100', '2019-02-01T18:28:00+0100'),
(229, 'Winterthur', 'Bern', '2019-02-01T17:31:00+0100', '2019-02-01T18:58:00+0100');

-- --------------------------------------------------------

--
-- Table structure for table `weather`
--

CREATE TABLE `weather` (
  `ID` int(11) NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Weather` varchar(30) NOT NULL,
  `Description` varchar(30) NOT NULL,
  `Date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `weather`
--

INSERT INTO `weather` (`ID`, `Location`, `Weather`, `Description`, `Date`) VALUES
(116, 'Bern', 'Snow', 'sleet', '01/02/19 14:40'),
(117, 'Basel SBB', 'Rain', 'light rain', '01/02/19 14:40'),
(118, 'Basel SBB', 'Rain', 'light rain', '01/02/19 14:42'),
(119, 'Uster', 'Clouds', 'scattered clouds', '01/02/19 14:42'),
(120, 'Uster', 'Clouds', 'scattered clouds', '01/02/19 14:42'),
(121, 'Winterthur', 'Clouds', 'scattered clouds', '01/02/19 14:42'),
(122, 'Basel SBB', 'Rain', 'light rain', '01/02/19 14:44'),
(123, 'Effretikon', 'Clouds', 'scattered clouds', '01/02/19 14:44'),
(124, 'Uster', 'Clouds', 'broken clouds', '01/02/19 16:04'),
(125, 'Winterthur', 'Clouds', 'broken clouds', '01/02/19 16:04'),
(126, 'Neftenbach, Wolfzangen', 'Clouds', 'broken clouds', '01/02/19 16:16'),
(127, 'Lufingen, Hintermarchlen', 'Rain', 'light rain', '01/02/19 16:16'),
(128, 'Lufingen, Hintermarchlen', 'Rain', 'light rain', '01/02/19 16:17'),
(129, 'Neftenbach, Wolfzangen', 'Clouds', 'broken clouds', '01/02/19 16:17'),
(130, 'Bern', 'Snow', 'snow', '01/02/19 16:20'),
(131, 'Zürich HB', 'Rain', 'light rain', '01/02/19 16:20'),
(132, 'Jona', 'Clouds', 'broken clouds', '01/02/19 16:28'),
(133, 'Uster', 'Clouds', 'broken clouds', '01/02/19 16:28'),
(134, 'Winterthur', 'Rain', 'light rain', '01/02/19 16:46'),
(135, 'Bern', 'Snow', 'snow', '01/02/19 16:46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `weather`
--
ALTER TABLE `weather`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `train`
--
ALTER TABLE `train`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=230;

--
-- AUTO_INCREMENT for table `weather`
--
ALTER TABLE `weather`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
