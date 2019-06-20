-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 20 juin 2019 à 04:15
-- Version du serveur :  10.1.35-MariaDB
-- Version de PHP :  7.2.9

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `simple_faculte_appeloffre`
--

-- --------------------------------------------------------

--
-- Structure de la table `appel_offre`
--

CREATE TABLE `appel_offre` (
  `id` bigint(20) NOT NULL,
  `montant_garantie_temp` decimal(19,2) DEFAULT NULL,
  `montantht` decimal(19,2) DEFAULT NULL,
  `montantttc` decimal(19,2) DEFAULT NULL,
  `objectif` varchar(255) DEFAULT NULL,
  `tva` decimal(19,2) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `offre_selected` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `appel_offre`
--

INSERT INTO `appel_offre` (`id`, `montant_garantie_temp`, `montantht`, `montantttc`, `objectif`, `tva`, `reference`, `offre_selected`, `date`) VALUES
(122, '1.76', '16.00', '176.00', 'ordinateur', '10.00', 'apl-2019-01', 124, '2019-05-01 00:00:00'),
(126, '2400.00', '20000.00', '420000.00', 'pc portable ', '20.00', 'apl-2019-02', 140, '2019-05-01 00:00:00'),
(128, '2.20', '20.00', '220.00', 'microscopie', '10.00', 'apl-2019-03', 134, '2019-05-03 00:00:00'),
(150, '43.20', '360.00', '7560.00', 'produit chimique pour département de chimie ', '20.00', 'apl-2019-09', 153, '2019-06-06 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `appel_offre_detail`
--

CREATE TABLE `appel_offre_detail` (
  `id` bigint(20) NOT NULL,
  `prix_unitaire` decimal(19,2) DEFAULT NULL,
  `quantite` decimal(19,2) DEFAULT NULL,
  `ref_produit` varchar(255) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `appel_offre` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `appel_offre_detail`
--

INSERT INTO `appel_offre_detail` (`id`, `prix_unitaire`, `quantite`, `ref_produit`, `total`, `appel_offre`) VALUES
(123, '8.00', '2.00', 'pr', '16.00', 122),
(127, '5000.00', '4.00', 'pc', '20000.00', 126),
(129, '10.00', '2.00', 'microscope', '20.00', 128),
(139, '6.00', '2.00', 'pr7', '12.00', 138),
(143, '6.00', '2.00', 'pr7', '12.00', 142),
(144, '3.00', '3.00', 'walo', '21.00', 142),
(146, '20.00', '6.00', 'pr-4', '120.00', 145),
(147, '10.00', '2.00', 'pr-1', '140.00', 145),
(151, '20.00', '10.00', 'pr-4', '200.00', 150),
(152, '10.00', '16.00', 'pr-1', '360.00', 150);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(156),
(156);

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `montant_ht` decimal(19,2) DEFAULT NULL,
  `montant_ttc` decimal(19,2) DEFAULT NULL,
  `objectif` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `refrence_fournisseur` varchar(255) DEFAULT NULL,
  `tva` decimal(19,2) DEFAULT NULL,
  `appel_offre` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `date`, `montant_ht`, `montant_ttc`, `objectif`, `reference`, `refrence_fournisseur`, `tva`, `appel_offre`) VALUES
(124, '2019-05-02', '12.00', '12.00', 'ord', 'offre-2019-01', 'ahmed', '0.00', 122),
(130, '2019-05-01', '600.00', '6600.00', 'miscroscopie', 'offre-2019-02', 'fr-36', '10.00', 128),
(134, '2019-05-03', '42.00', '672.00', 'microscopie ', 'offre-2019-03', 'fr-36', '15.00', 128),
(136, '2019-06-05', '60.00', '60.00', 'Ordinateur ', 'offre-2019-04', 'fr-36', '0.00', 126),
(140, '2019-06-04', '30.00', '330.00', 'scaner', 'offre-2019-05', 'fr-36', '10.00', 126),
(148, '2019-06-06', '20.00', '220.00', 'produit chimique ', 'offre-2019-06', 'fr-36', '10.00', 145),
(153, '2019-06-07', '80.00', '1680.00', 'produit chimique', 'offre-2019-09', 'fr-36', '20.00', 150);

-- --------------------------------------------------------

--
-- Structure de la table `offre_detail`
--

CREATE TABLE `offre_detail` (
  `id` bigint(20) NOT NULL,
  `prix_unitaire` decimal(19,2) DEFAULT NULL,
  `quantite` decimal(19,2) DEFAULT NULL,
  `ref_produit` varchar(255) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `offre` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `offre_detail`
--

INSERT INTO `offre_detail` (`id`, `prix_unitaire`, `quantite`, `ref_produit`, `total`, `offre`) VALUES
(125, '6.00', '2.00', 'pr', '12.00', 124),
(131, '300.00', '2.00', 'microscope2', '600.00', 130),
(135, '6.00', '7.00', 'microscope', '42.00', 134),
(137, '30.00', '2.00', 'pc', '60.00', 136),
(141, '6.00', '5.00', 'pc', '30.00', 140),
(149, '10.00', '2.00', 'microscope', '20.00', 148),
(154, '12.00', '4.00', 'pr-4', '48.00', 153),
(155, '8.00', '4.00', 'pr-1', '80.00', 153);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appel_offre`
--
ALTER TABLE `appel_offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdqt5tqtj7gku2a982hl11up2p` (`offre_selected`);

--
-- Index pour la table `appel_offre_detail`
--
ALTER TABLE `appel_offre_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnnemcpsskrhw1wp4dkfip8vs6` (`appel_offre`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKabrvllh2sqpuc3dn1eggmogy1` (`appel_offre`);

--
-- Index pour la table `offre_detail`
--
ALTER TABLE `offre_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4d0hxffnj06kx90jhtusetve5` (`offre`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
