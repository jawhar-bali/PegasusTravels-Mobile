-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 17 mai 2022 à 14:06
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pegasustravel`
--

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20220327102058', '2022-05-03 14:42:45', 174),
('DoctrineMigrations\\Version20220405204220', '2022-05-03 14:42:46', 7),
('DoctrineMigrations\\Version20220422231002', '2022-05-03 14:42:46', 43),
('DoctrineMigrations\\Version20220426042605', '2022-05-03 14:42:46', 8),
('DoctrineMigrations\\Version20220502220016', '2022-05-03 14:42:46', 5),
('DoctrineMigrations\\Version20220506190039', '2022-05-06 21:00:51', 157),
('DoctrineMigrations\\Version20220506190305', '2022-05-06 21:03:10', 51);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idEvent` int(11) NOT NULL,
  `nomEvent` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prixEvent` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`idEvent`, `nomEvent`, `prixEvent`, `date`) VALUES
(1, 'bbbbbbb', 123, '2022-05-17');

-- --------------------------------------------------------

--
-- Structure de la table `maisonh`
--

CREATE TABLE `maisonh` (
  `id_maison` int(11) NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `localisation` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `image_maison` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `maisonh`
--

INSERT INTO `maisonh` (`id_maison`, `nom`, `localisation`, `description`, `prix`, `image_maison`) VALUES
(5, 'Dar Ben Gacem Kahia', 'tunis', 'Doté d\'une connexion Wi-Fi gratuite, de la climatisation et d\'une télévision, le Dar Ben Gacem Kahia est situé à moins de 1 km de la mosquée Sidi Mahrez et à 12 minutes à pied du musée Dar Lasram.', 600, '74e34f368a0343b051ba181f0dbf16a1.jpeg'),
(6, 'El Patio Courtyard House', 'jerba', 'Les chambres climatisées comprennent un bureau, une bouilloire, un coffre-fort, une télévision à écran plat et une salle de bains privative avec douche. Le linge de lit et les serviettes sont fournis.', 1300, '810fd211f4c48e8a4f94fd06df01b016.jpeg'),
(7, 'Dar Zarrouk', 'sidi bou said , tunis', 'Situé dans la médina de Tunis, à 12 km de l\'aéroport international de Tunis-Carthage, le Dar Ben Gacem est un établissement de style traditionnel doté d\'une connexion', 125.6, 'c2a37c28955ad390f9e7cf226ba16623.jpeg'),
(11, 'chedi', 'debiche OK', 'hched', 55, 'ok'),
(12, 'maison1', 'tunis', 'test', 400, 'ok');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `idPub` int(11) NOT NULL,
  `datePub` date NOT NULL,
  `Path` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`idPub`, `datePub`, `Path`, `description`) VALUES
(1, '2017-01-01', '58ee470428d10472f3be8cc1ed9fe47b.jpeg', '<p>ff</p>'),
(2, '2021-01-01', '1bf6c5189d119b492954e7c56b0ae442.jpeg', '<p>esprit</p>');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `numero` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `commentaire` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dateReclamation` date NOT NULL,
  `typeReclamation` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`numero`, `id_user`, `nom`, `prenom`, `email`, `commentaire`, `dateReclamation`, `typeReclamation`) VALUES
(1, 14, 'rahma', 'ttttttttttt', 'dfg', 'qsdfgh', '2022-05-04', 'sdfghtjgyku'),
(2, 129, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', 'cd', '2017-01-01', 'Voyage'),
(3, 129, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', 'cd', '2017-01-01', 'Voyage'),
(4, 129, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', 'aa', '2017-01-01', 'Voyage'),
(6, 129, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', 's', '2017-01-01', 'Voyage'),
(7, 129, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', 's', '2017-01-01', 'Voyage'),
(8, 133, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', '<p>esprit</p>', '2022-04-18', 'Evenement'),
(9, 133, 'khitem', 'mathlouthi', 'khitem.mathlouthi@esprit.tn', '<p>esprit</p>', '2022-04-18', 'Evenement'),
(10, 129, 'rahma', 'tiss', 'rahma.tiss@esprit.tn', '<p>je veux reclamer sur hotel</p>', '2021-09-15', 'Hotel'),
(11, 129, 'iheb', 'zoghlami', 'iheb.zoghlami@esprit.tn', '<p>esprit</p>', '2017-01-01', 'Evenement'),
(12, 129, 'iheb', 'zoghlami', 'iheb.zoghlami@esprit.tn', '<p>esprit</p>', '2021-01-01', 'Evenement'),
(13, 129, 'rahma', 'tiss', 'rahma.tiss@esprit.tn', '<p>aa</p>', '2017-01-01', 'Voyage'),
(14, 169, 'a', 'a', 'a', 'a', '2022-04-27', 'Hotel'),
(17, NULL, 'ra', 'hh', 'aa', 'ee', '2022-05-17', 'hh'),
(18, NULL, 'ra', 'hh', 'aa', 'ee', '2022-05-17', 'hh'),
(19, NULL, 'y', 'y', 'y', 'y', '1970-01-01', 'Evenement'),
(20, NULL, 'y', 'y', 'y', 'y', '1970-01-01', 'Evenement'),
(21, 1, 'test', 'test', 'mohamed.derbali@esprit.tn', '<p>test</p>', '2022-08-01', 'Hotel');

-- --------------------------------------------------------

--
-- Structure de la table `reponsereclamation`
--

CREATE TABLE `reponsereclamation` (
  `numero` int(11) DEFAULT NULL,
  `IdRep` int(11) NOT NULL,
  `Reponse` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reponsereclamation`
--

INSERT INTO `reponsereclamation` (`numero`, `IdRep`, `Reponse`) VALUES
(3, 1, 'qssdf'),
(3, 2, 'qssdf'),
(4, 4, 'aa'),
(4, 5, 'aa'),
(9, 6, 'esprit'),
(12, 7, 'esprit'),
(10, 8, 'aa'),
(10, 9, 'aaaaaa');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idClient` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `nomClient` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenomClient` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservationevenement`
--

CREATE TABLE `reservationevenement` (
  `idRE` int(11) NOT NULL,
  `nomRE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dateRE` date NOT NULL,
  `idEvent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservationevenement`
--

INSERT INTO `reservationevenement` (`idRE`, `nomRE`, `dateRE`, `idEvent`) VALUES
(1, 'iheb', '2022-05-16', 0),
(2, 'iheb', '2022-05-16', 1),
(3, 'houba', '2017-01-01', 1),
(4, 'ppppppppp', '2017-01-01', 1),
(5, 'llllllllllll', '2017-01-01', 1),
(6, 'jojojojooj', '2017-01-01', 1),
(7, 'bbbbbbb', '2022-05-17', 1);

-- --------------------------------------------------------

--
-- Structure de la table `reservationm`
--

CREATE TABLE `reservationm` (
  `id_res` int(11) NOT NULL,
  `id_maison` int(11) DEFAULT NULL,
  `nb_chambre` int(11) NOT NULL,
  `nb_personne` int(11) NOT NULL,
  `date` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservationv`
--

CREATE TABLE `reservationv` (
  `IdR` int(11) NOT NULL,
  `NB_personnes` int(11) NOT NULL,
  `Date` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservationv`
--

INSERT INTO `reservationv` (`IdR`, `NB_personnes`, `Date`, `Id`) VALUES
(1234568, 5, 'jeudi 4 avril 2023', 4);

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

CREATE TABLE `sponsor` (
  `idS` int(11) NOT NULL,
  `prenomS` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descriptionS` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nomS` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `imageS` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id_user` int(30) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(180) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `poste` varchar(30) DEFAULT 'NULL',
  `salaire` varchar(30) DEFAULT 'NULL',
  `role` longtext NOT NULL COMMENT '(DC2Type:json)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id_user`, `nom`, `prenom`, `email`, `pwd`, `poste`, `salaire`, `role`) VALUES
(1, 'pegasus travel', 'debiche', 'chedi@gmail.com', '25d55ad283aa400af464c76d713c07ad', 'NULL', 'NULL', '[\"Admin\"]'),
(2, 'pegasusUser', 'ok', 'pegasus@gmail.com', '25d55ad283aa400af464c76d713c07ad', 'NULL', 'NULL', '[\"Client\"]'),
(3, 'mohamed', 'derbali', 'mohamed.derbali@esprit.tn', '25d55ad283aa400af464c76d713c07ad', 'NULL', 'NULL', '[\"Client\"]');

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

CREATE TABLE `voyage` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Destination` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Description` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Prix` int(11) NOT NULL,
  `Image` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `voyage`
--

INSERT INTO `voyage` (`Id`, `Nom`, `Destination`, `Description`, `Prix`, `Image`) VALUES
(2, 'Shopping À Istanbul À Prix Imbattable', 'Istanbul - Turquie', 'Hôtel 3*+Transfert aller retour + excursion shopping', 1200, '6303d353841a469740f7ef650ecf9815.jpeg'),
(3, 'Escapade Au Caire À Petit Prix', 'Le Caire - Egypte', 'Vol+Hôtel 3*', 900, '361a9d104d7afc5c0594a9d4478fd68b.jpeg'),
(4, 'Séjour À Barcelone', 'Barcelone - Espagne', 'Vol+Hôtel 5*', 1700, '337803dcb74106168c24cf9645c29e9c.jpeg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idEvent`),
  ADD UNIQUE KEY `idEvent` (`idEvent`);

--
-- Index pour la table `maisonh`
--
ALTER TABLE `maisonh`
  ADD PRIMARY KEY (`id_maison`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`idPub`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `id` (`id_user`);

--
-- Index pour la table `reponsereclamation`
--
ALTER TABLE `reponsereclamation`
  ADD PRIMARY KEY (`IdRep`),
  ADD KEY `numero` (`numero`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `reservationevenement`
--
ALTER TABLE `reservationevenement`
  ADD PRIMARY KEY (`idRE`),
  ADD KEY `idEvent` (`idEvent`);

--
-- Index pour la table `reservationm`
--
ALTER TABLE `reservationm`
  ADD PRIMARY KEY (`id_res`),
  ADD KEY `maisonH_reservationm` (`id_maison`);

--
-- Index pour la table `reservationv`
--
ALTER TABLE `reservationv`
  ADD PRIMARY KEY (`IdR`),
  ADD KEY `Id` (`Id`);

--
-- Index pour la table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`idS`),
  ADD UNIQUE KEY `idS` (`idS`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `UNIQ_1483A5E9E7927C74` (`email`);

--
-- Index pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `maisonh`
--
ALTER TABLE `maisonh`
  MODIFY `id_maison` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `idPub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `reponsereclamation`
--
ALTER TABLE `reponsereclamation`
  MODIFY `IdRep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reservationevenement`
--
ALTER TABLE `reservationevenement`
  MODIFY `idRE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `reservationm`
--
ALTER TABLE `reservationm`
  MODIFY `id_res` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `reservationv`
--
ALTER TABLE `reservationv`
  MODIFY `IdR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1234569;

--
-- AUTO_INCREMENT pour la table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `idS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `voyage`
--
ALTER TABLE `voyage`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1236;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
