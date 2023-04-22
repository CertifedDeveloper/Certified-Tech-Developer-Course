/*SP: Clientes por País y Ciudad*/


/*Tabla: Clientes*/

/*1. Crear un stored procedure que solicite como parámetros de entrada el
nombre de un país y una ciudad, y que devuelva como resultado la
información de contacto de todos los clientes de ese país y ciudad.
En el caso que el parámetro de ciudad esté vacío, se debe devolver todos los
clientes del país indicado.*/
DELIMITER $$
CREATE PROCEDURE info_contacto (IN pais_cliente VARCHAR(14), IN ciudad_cliente VARCHAR(19))
BEGIN
IF ciudad_cliente IS NULL OR ciudad_cliente = "" THEN
SELECT * FROM clientes
WHERE pais = pais_cliente;
ELSE 
SELECT * FROM clientes
WHERE pais = pais_cliente AND ciudad = ciudad_cliente;
END IF;
END $$
CALL info_contacto("Brazil", "Rio de Janeiro" );
/*2. Invocar el procedimiento para obtener la información de los clientes de
Brasilia en Brazil.*/
CALL info_contacto("Brazil", "Brasilia" );
/*3. Invocar el procedimiento para obtener la información de todos los clientes
de Brazil.*/
CALL info_contacto("Brazil", "" );


/*SP: Géneros musicales*/

/*Tabla: Generos*/

/*1. Crear un stored procedure que reciba como parámetro un nombre de
género musical y lo inserte en la tabla de géneros.
Además, el stored procedure debe devolver el id de género que se insertó.
TIP! Para calcular el nuevo id incluir la siguiente línea dentro del bloque de
código del SP: SET nuevoid = (SELECT MAX(id) FROM generos) + 1;*/
DELIMITER $$
CREATE PROCEDURE incluir_genero (IN genero_musical VARCHAR(18))
BEGIN
DECLARE nuevoid TINYINT;
SET nuevoid = (SELECT MAX(id) FROM generos) + 1;
INSERT INTO generos (id, nombre)
VALUES (nuevoid, genero_musical);
SELECT nuevoid;
END $$
/*2. Invocar el stored procedure creado para insertar el género Funk. ¿Qué id
devolvió el SP ? Consultar la tabla de géneros para ver los cambios.*/
CALL incluir_genero("Funk");
/*3. Repetir el paso anterior insertando esta vez el género Tango.*/
CALL incluir_genero("Tango");