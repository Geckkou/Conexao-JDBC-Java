### Conexão-JDBC-Java

## Instruções 

- Execute os comando abaixo no Mysql ou qualquer outro SGBD de sua preferência.

## Comandos

# Cria um banco de dados: 

- create database conexaoBD; (use o nome que você desejar)
- use conexaobd;

# Cria as Tabelas: 

- create table if not exists cliente(
	id integer not null auto_increment,
    nome varchar(50) not null,
    email varchar (40) not null,
    constraint pk_key primary key(id)
);

- create table if not exists endereco(
	idendereco integer not null auto_increment,
    logadouro varchar(300) not null,
    numero integer not null,
    cidade varchar(100) not null,
    estado varchar(2) not null,
    idcliente integer,
    constraint pk_endereco primary key(idendereco),
    constraint fk_idcliente foreign key(idcliente) references cliente(id)
);

- create table if not exists usuario(
	id integer not null auto_increment,
    login varchar(50) not null,
    senha varchar (40) not null,
    constraint pk_key primary key(id)
);

## Mais sobre.

- O projeto foi feito no net beans pela facilidade de criação de interface.

- A versão do Netbeans usada foi a 8.2 que ja vem com um driver jdbc. (caso você não possua ou tenha dificuldade de usar).

- Todos os inserts para teste podem ser feitos atráves da interface.

- Durante o Projeto aconteceu um bug onde a classe EndercoDAO(referente a tabela endereço) tornou-se privada, então botei ela dentro do pacote de interfaces para poder realizar as importações necessárias.



