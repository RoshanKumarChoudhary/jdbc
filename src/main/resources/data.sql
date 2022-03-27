--CREATE table Person (
--    id integer not null,
--    name varchar(255) not null,
--    location varchar(255),
--    birth_date timestamp,
--    primary key(id)
--);

INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1001, 'ROSHAN', 'JH', sysdate());

INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1002, 'Test', 'BL', sysdate());

INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1003, 'Begin', 'DL', sysdate());
