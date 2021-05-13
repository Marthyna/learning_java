-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 09-Mar-2018 às 14:29
-- Versão do servidor: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `participacao`
--

CREATE TABLE `participacao` (
  `pessoa_id` int(11) NOT NULL,
  `projeto_id` int(11) NOT NULL,
  `funcao` varchar(40) NOT NULL,
  `horas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `participacao`
--

INSERT INTO `participacao` (`pessoa_id`, `projeto_id`, `funcao`, `horas`) VALUES
(1, 1, 'Orientador', 600),
(2, 1, 'Participante', 300),
(3, 1, 'Participante', 120),
(1, 2, 'Orientador', 900),
(2, 2, 'Participante', 300),
(4, 2, 'Participante', 120),
(5, 3, 'Orientador', 300),
(3, 3, 'Participante', 600);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `pessoa_id` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `identidade` int(11) NOT NULL,
  `especializacao` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`pessoa_id`, `nome`, `identidade`, `especializacao`) VALUES
(1, 'Eloísa', 10101, 'Licenciatura em Matemática'),
(2, 'Marthyna', 20202, 'Técnico em Informática'),
(3, 'Marina', 30303, 'Técnico em Secretariado'),
(4, 'Mariana', 40404, 'Técnico em Refrigeração'),
(5, 'Lucas', 50505, 'Técnico em Informática');

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `projeto_id` int(11) NOT NULL,
  `nome_projeto` varchar(40) NOT NULL,
  `numero` int(11) NOT NULL,
  `data_inicio` date NOT NULL,
  `data_final` date NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`projeto_id`, `nome_projeto`, `numero`, `data_inicio`, `data_final`, `valor`) VALUES
(1, 'O Controle Legal: Educação Financeira e ', 111111, '2015-03-03', '2016-05-31', 1200),
(2, 'Naturvitta: Crescendo com Saúde', 222222, '2017-03-03', '2017-11-30', 100),
(3, 'ECOBÓTICA', 333333, '2017-02-17', '2018-11-24', 2500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `participacao`
--
ALTER TABLE `participacao`
  ADD KEY `pessoa_id_fk` (`pessoa_id`),
  ADD KEY `projeto_id_fk` (`projeto_id`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`pessoa_id`);

--
-- Indexes for table `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`projeto_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `pessoa_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `projeto`
--
ALTER TABLE `projeto`
  MODIFY `projeto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `participacao`
--
ALTER TABLE `participacao`
  ADD CONSTRAINT `pessoa_id_fk` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`pessoa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `projeto_id_fk` FOREIGN KEY (`projeto_id`) REFERENCES `projeto` (`projeto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
