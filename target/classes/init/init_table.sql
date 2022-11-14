create database mvdb;
use mvdb;

CREATE TABLE movie_tb (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	transName VARCHAR(200) NOT NULL,
	age INT NOT NULL,
	productPlace VARCHAR(200) NOT NULL,
	genre VARCHAR(100) NOT NULL,
	lang VARCHAR(100) NOT NULL,
	captions VARCHAR(100) NOT NULL,
	releaseDate DATE NOT NULL,
	imdbScore FLOAT NOT NULL,
	doubanScore FLOAT NOT NULL,
	lengthOfFilm INT NOT NULL,
	director VARCHAR(200) NOT NULL,
	writer VARCHAR(200) NOT NULL,
	actor VARCHAR(200) NOT NULL,
	introduction VARCHAR(1000) NOT NULL,
	link VARCHAR(500) NOT NULL,
	img VARCHAR(200) NOT NULL,
	downloadCount int DEFAULT 0,
	createDate DATE,
	PRIMARY KEY ( id )
);

CREATE TABLE user_tb (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	userName VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	PRIMARY KEY ( id )
);