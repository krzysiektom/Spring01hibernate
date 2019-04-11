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
