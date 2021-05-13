-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Mar-2018 às 02:13
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `universidade`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `aluno_id` int(11) NOT NULL,
  `mat` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cidade` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `alunos`:
--

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`aluno_id`, `mat`, `nome`, `endereco`, `cidade`) VALUES
(1, 2015010101, 'JOSE DE ALENCAR', 'RUA DAS ALMAS', 'NATAL'),
(2, 2015010102, 'JOÃO JOSÉ', 'AVENIDA RUY CARNEIRO', 'JOÃO PESSOA'),
(3, 2015010103, 'MARIA JOAQUINA', 'RUA CARROSSEL', 'RECIFE'),
(4, 2015010104, 'MARIA DAS DORES', 'RUA DAS LADEIRAS', 'FORTALEZA'),
(5, 2015010105, 'JOSUÉ CLAUDINO DOS SANTOS', 'CENTRO', 'NATAL'),
(6, 2015010106, 'jOSUÉLISSON CLAUDINO DOS SANTOS', 'CENTRO', 'NATAL');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `disciplina_id` int(11) NOT NULL,
  `cod_disc` varchar(5) NOT NULL,
  `nome_disc` varchar(40) NOT NULL,
  `carga_hor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `disciplinas`:
--

--
-- Extraindo dados da tabela `disciplinas`
--

INSERT INTO `disciplinas` (`disciplina_id`, `cod_disc`, `nome_disc`, `carga_hor`) VALUES
(1, 'BD', 'BANCO DE DADOS', 100),
(2, 'POO', 'PROGRAMAÇÃO COM ACESSO A BANCO DE DADOS', 100),
(3, 'WEB', 'AUTORIA WEB', 50),
(4, 'ENG', 'ENGENHARIA DE SOFTWARE', 80);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico`
--

CREATE TABLE `historico` (
  `historico_id` int(11) NOT NULL,
  `mat` int(11) NOT NULL,
  `cod_disc` varchar(5) NOT NULL,
  `cod_turma` int(11) NOT NULL,
  `ano` int(11) NOT NULL,
  `frequencia` double NOT NULL,
  `nota` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `historico`:
--   `ano`
--       `turmas` -> `ano`
--   `cod_disc`
--       `turmas` -> `cod_disc`
--   `cod_turma`
--       `turmas` -> `cod_turma`
--   `mat`
--       `alunos` -> `mat`
--

--
-- Extraindo dados da tabela `historico`
--

INSERT INTO `historico` (`historico_id`, `mat`, `cod_disc`, `cod_turma`, `ano`, `frequencia`, `nota`) VALUES
(1, 2015010101, 'BD', 1, 2015, 75, 6),
(2, 2015010101, 'POO', 1, 2015, 80, 7),
(3, 2015010101, 'WEB', 1, 2015, 90, 9),
(4, 2015010101, 'ENG', 1, 2015, 75, 4),
(5, 2015010102, 'BD', 2, 2015, 40, 9),
(6, 2015010102, 'POO', 1, 2015, 100, 10),
(7, 2015010102, 'WEB', 1, 2015, 85, 8.5),
(8, 2015010102, 'ENG', 1, 2015, 100, 5.5),
(9, 2015010103, 'BD', 1, 2015, 75, 4),
(10, 2015010103, 'POO', 1, 2015, 100, 10),
(11, 2015010103, 'WEB', 1, 2015, 60, 8),
(12, 2015010103, 'ENG', 1, 2015, 75, 7.9),
(13, 2015010104, 'BD', 2, 2015, 100, 7),
(14, 2015010104, 'POO', 1, 2015, 98, 9.8),
(15, 2015010104, 'WEB', 1, 2015, 95, 8.5),
(16, 2015010104, 'ENG', 1, 2015, 100, 4.8),
(17, 2015010105, 'BD', 1, 2015, 100, 10),
(18, 2015010105, 'POO', 1, 2015, 75, 6),
(19, 2015010105, 'WEB', 1, 2015, 85, 4),
(20, 2015010105, 'ENG', 1, 2015, 100, 8),
(21, 2015010106, 'BD', 2, 2015, 65, 9),
(22, 2015010106, 'POO', 1, 2015, 100, 8.4),
(23, 2015010106, 'WEB', 1, 2015, 25, 0),
(24, 2015010106, 'ENG', 1, 2015, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE `professores` (
  `professor_id` int(11) NOT NULL,
  `cod_prof` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cidade` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `professores`:
--

--
-- Extraindo dados da tabela `professores`
--

INSERT INTO `professores` (`professor_id`, `cod_prof`, `nome`, `endereco`, `cidade`) VALUES
(1, 212131, 'NICKERSON FERREIRA', 'RUA MANAÍRA', 'JOÃO PESSOA'),
(2, 122135, 'ADORILSON BEZERRA', 'AVENIDA SALGADO FILHO', 'NATAL'),
(3, 192011, 'DIEGO OLIVEIRA', 'AVENIDA ROBERTO FREIRE', 'NATAL');

-- --------------------------------------------------------

--
-- Estrutura da tabela `turmas`
--

CREATE TABLE `turmas` (
  `turma_id` int(11) NOT NULL,
  `cod_disc` varchar(5) NOT NULL,
  `cod_turma` int(11) NOT NULL,
  `cod_prof` int(11) NOT NULL,
  `ano` int(11) NOT NULL,
  `horario` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `turmas`:
--   `cod_disc`
--       `disciplinas` -> `cod_disc`
--   `cod_prof`
--       `professores` -> `cod_prof`
--

--
-- Extraindo dados da tabela `turmas`
--

INSERT INTO `turmas` (`turma_id`, `cod_disc`, `cod_turma`, `cod_prof`, `ano`, `horario`) VALUES
(1, 'BD', 1, 212131, 2015, '11H-12H'),
(2, 'BD', 2, 212131, 2015, '13H-14H'),
(3, 'POO', 1, 192011, 2015, '08H-09H'),
(4, 'WEB', 1, 192011, 2015, '07H-08H'),
(5, 'ENG', 1, 122135, 2015, '10H-11H');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`aluno_id`),
  ADD KEY `mat_fk` (`mat`);

--
-- Indexes for table `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`disciplina_id`),
  ADD KEY `cod_disc_fk` (`cod_disc`);

--
-- Indexes for table `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`historico_id`),
  ADD KEY `mat_fk` (`mat`),
  ADD KEY `cod_disc_fk` (`cod_disc`),
  ADD KEY `cod_turma_fk` (`cod_turma`),
  ADD KEY `ano_fk` (`ano`);

--
-- Indexes for table `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`professor_id`),
  ADD KEY `cod_prof_fk` (`cod_prof`);

--
-- Indexes for table `turmas`
--
ALTER TABLE `turmas`
  ADD PRIMARY KEY (`turma_id`),
  ADD KEY `cod_disc_fk` (`cod_disc`),
  ADD KEY `cod_turma_fk` (`cod_turma`),
  ADD KEY `cod_prof_fk` (`cod_prof`),
  ADD KEY `ano_fk` (`ano`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alunos`
--
ALTER TABLE `alunos`
  MODIFY `aluno_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `disciplinas`
--
ALTER TABLE `disciplinas`
  MODIFY `disciplina_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `historico`
--
ALTER TABLE `historico`
  MODIFY `historico_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `professores`
--
ALTER TABLE `professores`
  MODIFY `professor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `turmas`
--
ALTER TABLE `turmas`
  MODIFY `turma_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `ano_fk` FOREIGN KEY (`ano`) REFERENCES `turmas` (`ano`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cod_disc_fk` FOREIGN KEY (`cod_disc`) REFERENCES `turmas` (`cod_disc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cod_turma_fk` FOREIGN KEY (`cod_turma`) REFERENCES `turmas` (`cod_turma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `mat_fk` FOREIGN KEY (`mat`) REFERENCES `alunos` (`mat`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `turmas`
--
ALTER TABLE `turmas`
  ADD CONSTRAINT `cod_disk_fk` FOREIGN KEY (`cod_disc`) REFERENCES `disciplinas` (`cod_disc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cod_prof_fk` FOREIGN KEY (`cod_prof`) REFERENCES `professores` (`cod_prof`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
