DROP DATABASE IF EXISTS bookshop;

CREATE DATABASE bookshop;

USE bookshop;

CREATE TABLE book
(
   bookID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   bookName varchar(30) NOT NULL,
   authorName varchar(30) NOT NULL,
   price double(5, 2)
);

INSERT INTO book (bookName, authorName, price) VALUES ('Padurea Spanzuratilor', 'L. Rebreanu', 25.72);
INSERT INTO book (bookName, authorName, price) VALUES ('Prolegomene', 'E. Kant', 15.72);
INSERT INTO book (bookName, authorName, price) VALUES ('The Portrait of Dorian Gray', 'O. Wild', 14.30);
INSERT INTO book (bookName, authorName, price) VALUES ('The Dubliners', 'J. Joyce', 32.75);
INSERT INTO book (bookName, authorName, price) VALUES ('Filosofia cunoasterii', 'L. Blaga', 40.75);