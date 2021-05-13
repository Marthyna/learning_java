-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 23-Mar-2018 às 11:07
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.3

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
  `MAT` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `cidade` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`MAT`, `nome`, `endereco`, `cidade`) VALUES
(1233, 'Teste dos endereco', '', NULL),
(1234, 'João do Pezão', 'Rua dos Valentão', 'Cidade dos Fortão'),
(201801010, 'Miguel', 'Rua dos que deu certo', NULL),
(2015010101, 'JOSE DE ALENCAR', 'RUA DAS ALMAS', 'NATAL'),
(2015010102, 'JOÃO JOSÉ', 'AVENIDA RUY CARNEIRO', 'JOÃO PESSOA'),
(2015010103, 'MARIA JOAQUINA', 'RUA CARROSSEL', 'RECIFE'),
(2015010104, 'MARIA DAS DORES', 'RUA DAS LADEIRAS', 'FORTALEZA'),
(2015010105, 'JOSUÉ CLAUDINO DOS SANTOS', 'CENTRO', 'NATAL'),
(2015010106, 'JOSUÉLISSON CLAUDINO DOS SANTOS', 'CENTRO', 'NATAL');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `COD_DISC` varchar(10) NOT NULL,
  `nome_disc` varchar(40) NOT NULL,
  `carga_hor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplinas`
--

INSERT INTO `disciplinas` (`COD_DISC`, `nome_disc`, `carga_hor`) VALUES
('BD', 'BANCO DE DADOS', 100),
('ENG', 'ENGENHARIA DE SOFTWARE', 80),
('POO', 'PROGRAMAÇÃO COM ACESSO A BANCO DE DADOS', 100),
('WEB', 'AUTORIA WEB', 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico`
--

CREATE TABLE `historico` (
  `MAT` int(11) NOT NULL,
  `COD_DISC` varchar(10) NOT NULL,
  `COD_TURMA` int(11) NOT NULL,
  `COD_PROF` int(11) NOT NULL,
  `ANO` year(4) NOT NULL,
  `frequencia` float NOT NULL,
  `nota` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `historico`
--

INSERT INTO `historico` (`MAT`, `COD_DISC`, `COD_TURMA`, `COD_PROF`, `ANO`, `frequencia`, `nota`) VALUES
(2015010101, 'BD', 1, 122135, 2015, 75, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE `professores` (
  `COD_PROF` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `cidade` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professores`
--

INSERT INTO `professores` (`COD_PROF`, `nome`, `endereco`, `cidade`) VALUES
(122135, 'ADORILSON BEZERRA', 'AVENIDA SALGADO FILHO', 'NATAL'),
(192011, 'DIEGO OLIVEIRA', 'AVENIDA ROBERTO FREIRE', 'NATAL'),
(212131, 'NICKERSON FERREIRA', 'RUA MANAÍRA', 'JOÃO PESSOA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `testes_aluno`
--

CREATE TABLE `testes_aluno` (
  `id_teste` int(11) NOT NULL,
  `MAT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `COD_DISC` varchar(10) NOT NULL,
  `COD_TURMA` int(11) NOT NULL,
  `COD_PROF` int(11) NOT NULL,
  `ANO` year(4) NOT NULL,
  `horario` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`COD_DISC`, `COD_TURMA`, `COD_PROF`, `ANO`, `horario`) VALUES
('BD', 1, 212131, 2015, '11H-12H'),
('BD', 2, 212131, 2015, '13H-14H'),
('POO', 3, 192011, 2015, '08H-09H'),
('WEB', 4, 192011, 2015, '07H-08H'),
('ENG', 5, 122135, 2015, '10H-11H');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`MAT`);

--
-- Indexes for table `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`COD_DISC`);

--
-- Indexes for table `historico`
--
ALTER TABLE `historico`
  ADD KEY `fk_Cod_turma` (`COD_TURMA`),
  ADD KEY `fk_cod_prof2` (`COD_PROF`),
  ADD KEY `fk_mat2` (`MAT`),
  ADD KEY `fk_cod_disc2` (`COD_DISC`);

--
-- Indexes for table `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`COD_PROF`);

--
-- Indexes for table `testes_aluno`
--
ALTER TABLE `testes_aluno`
  ADD PRIMARY KEY (`id_teste`),
  ADD KEY `TESTES_FKMAT` (`MAT`);

--
-- Indexes for table `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`COD_TURMA`),
  ADD KEY `fk_cod_disc` (`COD_DISC`),
  ADD KEY `fk_cod_prof` (`COD_PROF`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `testes_aluno`
--
ALTER TABLE `testes_aluno`
  MODIFY `id_teste` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `fk_Cod_turma` FOREIGN KEY (`COD_TURMA`) REFERENCES `turma` (`COD_TURMA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cod_disc2` FOREIGN KEY (`COD_DISC`) REFERENCES `disciplinas` (`COD_DISC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cod_prof2` FOREIGN KEY (`COD_PROF`) REFERENCES `professores` (`COD_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_mat2` FOREIGN KEY (`MAT`) REFERENCES `alunos` (`MAT`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `testes_aluno`
--
ALTER TABLE `testes_aluno`
  ADD CONSTRAINT `TESTES_FKMAT` FOREIGN KEY (`MAT`) REFERENCES `alunos` (`MAT`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk_cod_disc` FOREIGN KEY (`COD_DISC`) REFERENCES `disciplinas` (`COD_DISC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cod_prof` FOREIGN KEY (`COD_PROF`) REFERENCES `professores` (`COD_PROF`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
