-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 08, 2025 at 02:36 PM
-- Server version: 8.0.39
-- PHP Version: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `forkandshare-database`
--

-- --------------------------------------------------------

--
-- Table structure for table `chefs`
--

CREATE TABLE `chefs` (
  `chef_id` int NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chefs`
--

INSERT INTO `chefs` (`chef_id`, `email`, `password`, `username`) VALUES
(2, 'Billy123@gmail.com', 'Billyrocks123', 'Billy'),
(3, 'Ramsay123@gmail.com', 'Password123', 'Gordon Ramsay'),
(4, 'Washington@yahoo.com', 'USA', 'GeorgeCooks'),
(5, 'chef@email.com', '1234', 'Chef123');

-- --------------------------------------------------------

--
-- Table structure for table `recipes`
--

CREATE TABLE `recipes` (
  `recipe_id` int NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `diet` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prep_time` int NOT NULL,
  `chef_id` int DEFAULT NULL,
  `ingredients` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `instructions` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recipes`
--

INSERT INTO `recipes` (`recipe_id`, `description`, `diet`, `name`, `prep_time`, `chef_id`, `ingredients`, `instructions`) VALUES
(3, 'A delicious and healthy pizza', 'vegan', 'vegan pizza', 30, 2, '3 cups of flour, 1 cup of tomato sauce, 1 cup of carrots, 1/2 cup of spinach, 1/2 cup of cheese', 'Bake at 425 degrees for 25 mins'),
(5, 'Spicy and delicious wings', 'null', 'Buffalo Wings', 20, 3, '2 lbs. of chicken wings, buffalo sauce, flour, oil', 'Cook the chicken wings with buffalo sauce'),
(6, 'Healthy light snack', 'Vegan', 'Salad', 11, 2, '1/2 cup of carrots, 1 cup of lettuce, 2 tomatoes, 1 cucumber, 1/4 cup of purple onions, and croutons ', 'slice all the vegetables and mix together');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `review_id` int NOT NULL,
  `details` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rating` int NOT NULL,
  `chef_id` int DEFAULT NULL,
  `recipe_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `email`, `password`, `username`) VALUES
(5, 'user@email.com', '123', 'User1');

-- --------------------------------------------------------

--
-- Table structure for table `user_saved_recipes`
--

CREATE TABLE `user_saved_recipes` (
  `user_id` int NOT NULL,
  `recipe_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chefs`
--
ALTER TABLE `chefs`
  ADD PRIMARY KEY (`chef_id`);

--
-- Indexes for table `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`recipe_id`),
  ADD KEY `FKiug906q101skenymet4upmi9v` (`chef_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `FKdtf0w746s8j2jxj75qb2op4k1` (`chef_id`),
  ADD KEY `FKdubqj24wyqsxwg1vsut9uoce1` (`recipe_id`),
  ADD KEY `FKcgy7qjc1r99dp117y9en6lxye` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `user_saved_recipes`
--
ALTER TABLE `user_saved_recipes`
  ADD KEY `FKfm7marif8ukb5y1qpndvy3mvn` (`recipe_id`),
  ADD KEY `FK5rfntjwtmd4qy1s1bifd9p1bd` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chefs`
--
ALTER TABLE `chefs`
  MODIFY `chef_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `recipes`
--
ALTER TABLE `recipes`
  MODIFY `recipe_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `review_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `recipes`
--
ALTER TABLE `recipes`
  ADD CONSTRAINT `FKiug906q101skenymet4upmi9v` FOREIGN KEY (`chef_id`) REFERENCES `chefs` (`chef_id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FKcgy7qjc1r99dp117y9en6lxye` FOREIGN KEY (`user_id`) REFERENCES `users` (`userid`),
  ADD CONSTRAINT `FKdtf0w746s8j2jxj75qb2op4k1` FOREIGN KEY (`chef_id`) REFERENCES `chefs` (`chef_id`),
  ADD CONSTRAINT `FKdubqj24wyqsxwg1vsut9uoce1` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`);

--
-- Constraints for table `user_saved_recipes`
--
ALTER TABLE `user_saved_recipes`
  ADD CONSTRAINT `FK5rfntjwtmd4qy1s1bifd9p1bd` FOREIGN KEY (`user_id`) REFERENCES `users` (`userid`),
  ADD CONSTRAINT `FKfm7marif8ukb5y1qpndvy3mvn` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
