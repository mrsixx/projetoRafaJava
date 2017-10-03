-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03-Out-2017 às 03:02
-- Versão do servidor: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bdescola`
--
CREATE DATABASE IF NOT EXISTS `bdescola` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdescola`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbaluno`
--

CREATE TABLE IF NOT EXISTS `tbaluno` (
  `codigoaluno` int(11) NOT NULL,
  `nomealuno` varchar(50) NOT NULL,
  `enderecoaluno` varchar(50) NOT NULL,
  `cidadealuno` varchar(50) NOT NULL,
  `emailaluno` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblogin`
--

CREATE TABLE IF NOT EXISTS `tblogin` (
  `codigologin` int(11) NOT NULL,
  `usuariologin` varchar(20) NOT NULL,
  `senhalogin` varchar(10) NOT NULL,
  `nivellogin` char(1) NOT NULL,
  `ativologin` char(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbprofessor`
--

CREATE TABLE IF NOT EXISTS `tbprofessor` (
  `codigoprofessor` int(11) NOT NULL,
  `nomeprofessor` varchar(50) NOT NULL,
  `formacaoprofessor` varchar(50) NOT NULL,
  `emailprofessor` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `v`
--
CREATE TABLE IF NOT EXISTS `v` (
`codigologin` int(11)
,`usuariologin` varchar(20)
,`senhalogin` varchar(10)
,`nivellogin` char(1)
,`ativologin` char(3)
);

-- --------------------------------------------------------

--
-- Structure for view `v`
--
DROP TABLE IF EXISTS `v`;

CREATE ALGORITHM=UNDEFINED DEFINER=`a`@`%` SQL SECURITY DEFINER VIEW `v` AS select `tblogin`.`codigologin` AS `codigologin`,`tblogin`.`usuariologin` AS `usuariologin`,`tblogin`.`senhalogin` AS `senhalogin`,`tblogin`.`nivellogin` AS `nivellogin`,`tblogin`.`ativologin` AS `ativologin` from `tblogin` order by `tblogin`.`codigologin`;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbaluno`
--
ALTER TABLE `tbaluno`
  ADD PRIMARY KEY (`codigoaluno`);

--
-- Indexes for table `tblogin`
--
ALTER TABLE `tblogin`
  ADD PRIMARY KEY (`codigologin`);

--
-- Indexes for table `tbprofessor`
--
ALTER TABLE `tbprofessor`
  ADD PRIMARY KEY (`codigoprofessor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbaluno`
--
ALTER TABLE `tbaluno`
  MODIFY `codigoaluno` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tblogin`
--
ALTER TABLE `tblogin`
  MODIFY `codigologin` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbprofessor`
--
ALTER TABLE `tbprofessor`
  MODIFY `codigoprofessor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
