create database agora;

use agora;


-- Cria uma tabela
create table usuarios (
id int not null auto_increment primary key,
nome VARCHAR(50) NOT NULL,
login VARCHAR(50) NOT NULL,
senha VARCHAR(50) NOT NULL,
cpf VARCHAR(14) NOT NULL,
tel VARCHAR(20) NOT NULL,
whatsapp VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
dtCadastro VARCHAR(10) NOT NULL,
situacao VARCHAR(6) NOT NULL
);

select * from usuarios;

-- Inseri dados na tabela
insert into usuarios(nome,login,senha,cpf,tel,whatsapp,email,dtCadastro,situacao)
values
("Alex Souza Da Silva","alex","123","153-250-717-85","0","021 9 6464-5673","alex@gxs.com.br","31-08-2018","ativo");

delete from usuarios where id > 1 and id < 50 ;

drop table usuarios;

