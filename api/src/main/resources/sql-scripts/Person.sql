--mysql
CREATE SCHEMA `prototypeDB` ;

CREATE TABLE `prototypeDB`.`Person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `age` INT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `prototypeDB`.`Person` (name, lastName, age, email) VALUES ('JUAN', 'CALVOPINA', 29, 'juan.calvopina@gmail.com');

SELECT * FROM `prototypeDB`.`Person`;
DELETE FROM `prototypeDB`.`Person`;

SELECT * FROM PERSON;
SELECT * FROM TIPOPARAMETRO;
INSERT INTO TIPOPARAMETRO (VALOR) VALUES ('ANCHO DE BANDA');
SELECT * FROM RESULTADOPRUEBA;
INSERT INTO RESULTADOPRUEBA (FECHA, VALOR, TIPO_ID) VALUES (SYSDATE(), 'TEST',1);

-----------------------------------------------------------------------
--derby
CREATE TABLE Person(
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
    name VARCHAR(50),
    lastName VARCHAR(50),
    age INTEGER,
    email VARCHAR(50)
 );

INSERT INTO PERSON (NAME, LASTNAME, AGE, EMAIL) VALUES ('JUAN', 'CALVOPINA', 29, 'juan.calvopina@gmail.com');

SELECT * FROM PERSON;
DELETE FROM PERSON;


DROP TABLE PERSON;


