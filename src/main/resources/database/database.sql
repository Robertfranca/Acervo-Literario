-- Criar o banco de dados
CREATE DATABASE Biblioteca;

-- Usar o banco de dados criado
USE Biblioteca;

-- Criar a tabela de Livros
CREATE TABLE IF NOT EXISTS livro (
    id bigint unsigned NOT NULL AUTO_INCREMENT,
    titulo varchar(500) NOT NULL,
    autor varchar(500) NOT NULL,
    editora varchar(500) NOT NULL,
    status varchar(20) DEFAULT 'não lido',
    nota int DEFAULT NULL,
    anotacao text,
    isbn varchar(500) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY id (id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;