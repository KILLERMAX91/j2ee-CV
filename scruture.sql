DROP DATABASE CV;
CREATE DATABASE CV;

USE CV;

CREATE TABLE coordonner(
    id int auto_increment,
    mail varchar(255) not null,
    nom varchar(255) not null,
    naissance date not null,
    permis TinyInt(1) not null,
    networks varchar(20),
    primary key(id)
);

CREATE TABLE enseignement(
    id int auto_increment,
    nom varchar(255),
    niveau varchar(20),
    groupe varchar(20),
    primary key(id)
);

CREATE TABLE poste(
    id int auto_increment,
    poste varchar(255),
    durer int,
   -- annee DATE,
    description longtext,
    lieu varchar(255),
    primary key(id)
);

CREATE TABLE formation(
    id int auto_increment,
    nom_form varchar(255),
    duree int(11),
    annee DATE,
    description longtext,
    lieu varchar(255),
    diplome varchar(200),
    primary key(id)
);

CREATE TABLE passion(
    id int auto_increment,
    nom varchar(255),
    description longtext,
    primary key(id)
);




INSERT INTO coordonner(id, mail, nom, naissance, permis, networks) VALUES (1, "toto@toto.fr", "toto", "2011-01-01", 0, null);