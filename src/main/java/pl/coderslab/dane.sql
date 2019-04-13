CREATE DATABASE testdb
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

INSERT INTO testdb.authors(firstName, lastName)
VALUES ('Imie1', 'Nazwisko1');
INSERT INTO testdb.authors(firstName, lastName)
VALUES ('Imie2', 'Nazwisko2');
INSERT INTO testdb.publishers (name)
VALUES ('Wydawca');
INSERT INTO testdb.books (description, rating, myTitle, publisher_id)
VALUES ('Opis', 12.00, 'title', 1);
INSERT INTO testdb.books_authors (book_id, author_id)
VALUES (1, 1);
INSERT INTO testdb.books_authors (book_id, author_id)
VALUES (1, 2);
INSERT INTO testdb.publishers(name) VALUES ("Wydawca1");
INSERT INTO testdb.publishers(name) VALUES ("Wydawca2");
INSERT INTO testdb.publishers(name) VALUES ("Wydawca3");
INSERT INTO testdb.hobbies(name) VALUES ("szachy");
INSERT INTO testdb.hobbies(name) VALUES ("piłka nożna");
INSERT INTO testdb.hobbies(name) VALUES ("hokej");
INSERT INTO testdb.programmingSkills(skill) VALUES ("Java");
INSERT INTO testdb.programmingSkills(skill) VALUES ("PHP");
INSERT INTO testdb.programmingSkills(skill) VALUES ("Ruby");