-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 23 Avril 2019 à 00:44
-- Version du serveur :  10.1.13-MariaDB
-- Version de PHP :  5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cafeteria`
--

-- --------------------------------------------------------

--
-- Structure de la table `commands`
--

CREATE TABLE `commands` (
  `id` int(11) NOT NULL,
  `command_msg` varchar(200) NOT NULL,
  `total_price` double NOT NULL,
  `n_table` int(11) NOT NULL,
  `state` varchar(25) DEFAULT 'no served',
  `date_cmd` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `download`
--

CREATE TABLE `download` (
  `file_name` varchar(100) NOT NULL,
  `path` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `download`
--

INSERT INTO `download` (`file_name`, `path`) VALUES
('cafeteria mobile app', 'cafeteria.apk');

-- --------------------------------------------------------

--
-- Structure de la table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `products`
--

INSERT INTO `products` (`id`, `designation`, `price`, `description`) VALUES
(3, 'mille feuille', 35, 'sucre creme sucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre cremesucre creme'),
(4, 'basbousa', 45, 'sure '),
(5, 'chamiya', 50, 'sucre cremesucre creme\r\nshamiya\r\n'),
(7, 'makroute', 65, 'delecious makroute'),
(8, 'pain chocolat', 25, ''),
(9, 'croissant', 30, '');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `commands`
--
ALTER TABLE `commands`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `commands`
--
ALTER TABLE `commands`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT pour la table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
