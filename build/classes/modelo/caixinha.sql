-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30-Ago-2018 às 20:45
-- Versão do servidor: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `caixinha`
--
create database caixinha;
use caixinha;
-- --------------------------------------------------------

--
-- Estrutura da tabela `carros`
--


CREATE TABLE `carros` (
  `idcarros` int(11) NOT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `ano` varchar(255) DEFAULT NULL,
  `cor` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `portas` varchar(10) NOT NULL,
  `ar` varchar(10) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `carros`
--

INSERT INTO `carros` (`idcarros`, `placa`, `modelo`, `ano`, `cor`, `status`, `portas`, `ar`, `preco`) VALUES
(1, 'yug9989', 'cheavrolet corsa', '2014', 'verde', 'alocado', '2', 'nao', 210),
(2, 'hex4679', 'nissan sentra', '2011', 'vermelho', 'alocado', '4', 'sim', 250),
(3, 'ght4065', 'honda fit ', '2015', 'prata', 'disponivel', '4', 'sim', 330),
(4, 'lad8065', 'fiat uno', '2011', 'branca', 'disponivel', '2', 'nao', 150),
(5, 'cfg5045', 'chevrolet onix', '2013', 'vermelho', 'disponivel', '2', 'sim', 240),
(6, 'lok2015', 'ford ka', '2013', 'verde', 'disponivel', '2', 'sim', 240),
(7, 'pop8865', 'nissan tiida', '2010', 'preto', 'disponivel', '4', 'nao', 170),
(8, 'uuh7741', 'jac j3', '2011', 'azul', 'disponivel', '4', 'nao', 200),
(9, 'zlk2565', 'nissan tiida', '2010', 'vermelho', 'alocado', '4', 'sim', 240);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

CREATE TABLE `locacao` (
  `idlocacao` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `placa` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `entrada` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `atraso` varchar(255) NOT NULL,
  `saida` varchar(255) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `locacao`
--

INSERT INTO `locacao` (`idlocacao`, `nome`, `placa`, `cpf`, `entrada`, `status`, `atraso`, `saida`, `total`) VALUES
(4, 'ronan', 'zlk2565', '123.123.123-12', '26/08/2018', 'alocado', 'nao', '27/08/2018', 480),
(5, 'marcio', 'yug9989', '187.199.755-19', '27/09/2018', 'alocado', 'nao', '29/09/2018', 420),
(6, 'lucas', 'hex4679', '123.123.123-20', '19/09/2018', 'alocado', 'nao', '29/09/2018', 2500);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `usu` varchar(255) DEFAULT NULL,
  `sen` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usu`, `sen`, `nome`) VALUES
(1, 'admin', 'admin', 'kaka'),
(2, 'funcionario', '12345', 'marcia'),
(3, 'gerente', '12345', 'Aroudo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carros`
--
ALTER TABLE `carros`
  ADD PRIMARY KEY (`idcarros`);

--
-- Indexes for table `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`idlocacao`),
  ADD KEY `total` (`total`) USING BTREE;

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carros`
--
ALTER TABLE `carros`
  MODIFY `idcarros` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `locacao`
--
ALTER TABLE `locacao`
  MODIFY `idlocacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
