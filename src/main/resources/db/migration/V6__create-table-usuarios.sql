create table usuarios (
    id bigserial not null ,
    nome varchar(100) not null ,
    senha varchar(255) not null ,

    primary key(id)
);