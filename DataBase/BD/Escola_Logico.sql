-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Aluno (
Aluno_ID Número PRIMARY KEY,
Nome Texto(1)
)

CREATE TABLE Professor (
Professor_ID Número PRIMARY KEY,
Nome Texto(1)
)

CREATE TABLE Disciplina (
Disciplina_ID Texto(1) PRIMARY KEY,
Nome Texto(1),
Professor_ID Número,
FOREIGN KEY(Professor_ID) REFERENCES Professor (Professor_ID)
)

CREATE TABLE Estuda (
Aluno_ID Número,
Disciplina_ID Texto(1),
FOREIGN KEY(Aluno_ID) REFERENCES Aluno (Aluno_ID)
FOREIGN KEY(Disciplina_ID) REFERENCES Disciplina(Disciplina_ID)/*falha: chave estrangeira*/
)

