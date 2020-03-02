-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 01, 2020 at 03:35 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `treat`
--

-- --------------------------------------------------------

--
-- Table structure for table `areas`
--

CREATE TABLE `areas` (
  `id` int(11) NOT NULL,
  `area` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `parent_area` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `areas`
--

INSERT INTO `areas` (`id`, `area`, `parent_area`) VALUES
(1, 'Chhindwara', 0),
(21, 'Banglore', 0),
(22, 'Lakhnadone', 0);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `items` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `expire_date` datetime DEFAULT NULL,
  `paid` tinyint(4) DEFAULT 0,
  `shipped` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `id` int(11) NOT NULL,
  `ot_reason` varchar(175) COLLATE utf8_unicode_ci DEFAULT NULL,
  `us_reason` varchar(175) COLLATE utf8_unicode_ci DEFAULT NULL,
  `person_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `ex_date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,1) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `threshold` decimal(10,2) NOT NULL,
  `unit` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `inventory_consumption` decimal(10,2) NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `deleted` tinyint(4) NOT NULL DEFAULT 0,
  `person` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inventory_cons`
--

CREATE TABLE `inventory_cons` (
  `id` int(11) NOT NULL,
  `inventory_id` int(11) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `person_id` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `sub_total` decimal(10,2) NOT NULL,
  `tax` decimal(10,2) NOT NULL,
  `grand_total` decimal(10,2) NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `payment_type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `txn_date` datetime NOT NULL DEFAULT current_timestamp(),
  `coworker` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `persons`
--

CREATE TABLE `persons` (
  `id` int(11) NOT NULL,
  `person_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `adhaarno` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `mobile_no` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(175) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `street` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `street2` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `parent_area` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `zip_code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(175) COLLATE utf8_unicode_ci NOT NULL,
  `join_date` datetime NOT NULL DEFAULT current_timestamp(),
  `last_login` datetime NOT NULL,
  `permissions` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `person_img` text COLLATE utf8_unicode_ci NOT NULL,
  `suspension` tinyint(4) NOT NULL DEFAULT 1,
  `deleted_person` tinyint(4) NOT NULL DEFAULT 0,
  `coworker_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `persons`
--

INSERT INTO `persons` (`id`, `person_name`, `adhaarno`, `mobile_no`, `username`, `password`, `street`, `street2`, `parent_area`, `state`, `zip_code`, `country`, `join_date`, `last_login`, `permissions`, `person_img`, `suspension`, `deleted_person`, `coworker_id`) VALUES
(18, 'Deepanshu Badshah', '', '9479580279', 'badshahdeepanshu@gmail.com', '$2y$10$NDzqB4gvWu8PObM9sWcDDOjDLJ3q/8aZ/oGyhKn/tpn6c7/hADzKC', '', '', '', '', '', '', '2018-04-08 14:49:44', '2020-03-01 15:18:20', 'admin,editor', '', 1, 0, 0),
(19, 'Yashraaj Jain', '123456789123', '9425464947', 'yashrajjain@midwaytreat', '$2y$10$Q/fKdiPBZ.Y.jKhE3zINFOI3JGuynUcyYGF7QXf4opWM9pweWkoP6', '', '', '22', 'M.P', '', '', '2018-07-07 05:12:30', '0000-00-00 00:00:00', 'admin,editor', '/treat/images/sz/prod/aa8f03d4664aafa4942ea61edc90d9c2.png', 1, 0, 18);

-- --------------------------------------------------------

--
-- Table structure for table `Products`
--

CREATE TABLE `Products` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,1) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `image` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `featured` tinyint(4) DEFAULT 0,
  `quantity` int(10) DEFAULT NULL,
  `threshold` int(10) DEFAULT 0,
  `sold` int(11) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Products`
--

INSERT INTO `Products` (`id`, `title`, `price`, `category`, `image`, `description`, `featured`, `quantity`, `threshold`, `sold`, `person`, `deleted`) VALUES
(17, 'Veg Burger', '75.0', 34, '/treat/images/sz/prod/3896c9259135a34a56d375c312c31d85.jpg', 'Best quality aata....', 1, 1000, 0, 0, 0, 0),
(19, 'Veg Munchuri.', '140.0', 29, '/treat/images/sz/prod/a093d8a87bab8b069fd488bacf0cf817.jpg', 'Keep your hands soft....', 1, 20000, 0, 0, 0, 0),
(20, 'Chilli Potato', '90.0', 29, '/treat/images/sz/prod/12a428a68b08ee778a9a4504d838b2c2.jpg', '', 1, 100000, 0, 0, 0, 0),
(23, 'Cheese sandw.', '60.0', 34, '/treat/images/sz/prod/50649771f07658d8a8f7b1bdfcfff171.jpg', '', 1, 1000000, 1, 0, 0, 0),
(27, 'Fries', '100.0', 34, '/treat/images/sz/prod/6a7afde99f9cb3767085a243fb08dc3d.jpg', '', 1, 1000000, 1, 0, 0, 0),
(29, 'Butter naan', '10.0', 32, '/treat/images/sz/prod/48189b09a3be73e0d73e974f95d3f89e.jpg', '', 1, 10000, 0, 0, 0, 0),
(30, 'Tandoori roti', '12.0', 32, '/treat/images/sz/prod/69d4d1ea1b56ad11015fd0f584889d2d.jpg', '', 1, 1000000, 0, 0, 0, 0),
(31, 'Dosa', '80.0', 28, '/treat/images/sz/prod/b910fb4ddbefc678af205e793e041913.jpg', '', 0, 1000, 80, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `pro_cat`
--

CREATE TABLE `pro_cat` (
  `id` int(11) NOT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pro_cat`
--

INSERT INTO `pro_cat` (`id`, `category`) VALUES
(28, 'South indian'),
(29, 'Chinese'),
(30, 'Packed food'),
(31, 'Juices'),
(32, 'Indian Breads'),
(33, 'Snacks'),
(34, 'Fast food'),
(35, 'Salad');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `task` varchar(175) COLLATE utf8_unicode_ci NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `_date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `areas`
--
ALTER TABLE `areas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory_cons`
--
ALTER TABLE `inventory_cons`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persons`
--
ALTER TABLE `persons`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Products`
--
ALTER TABLE `Products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pro_cat`
--
ALTER TABLE `pro_cat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `areas`
--
ALTER TABLE `areas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inventory_cons`
--
ALTER TABLE `inventory_cons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `persons`
--
ALTER TABLE `persons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `Products`
--
ALTER TABLE `Products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `pro_cat`
--
ALTER TABLE `pro_cat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
