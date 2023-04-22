/*Consignas*/


/*1) Cálculo de edad*/
/*a) Crear un SP que muestre apellidos, nombres y edad de cada empleado, debe calcular la edad de los 
empleados a partir de la fecha de nacimiento y que tengan entre n y n años de edad.*/
DELIMITER $$
CREATE PROCEDURE empleados_edad (IN menor SMALLINT, IN mayor SMALLINT)
BEGIN
SELECT Apellido, Nombre, TIMESTAMPDIFF(YEAR, emp.FechaNacimiento, NOW()) edad 
FROM empleados emp
HAVING edad BETWEEN menor AND mayor;
END $$
/*b) Ejecutar el SP indicando un rango de edad entre 50 y 60 años de edad.*/
DELIMITER ;
CALL empleados_edad(50, 60);


/*2) Actualización de productos*/
/*a) Crear un SP que reciba un porcentaje y un nombre de categoría y actualice los productos pertenecientes a 
esa categoría, incrementando las unidades pedidas según el porcentaje indicado. Por ejemplo: si un producto 
de la categoría Seafood tiene 30 unidades pedidas, al invocar el SP con categoría Seafood y porcentaje 10%, 
el SP actualizará el valor de unidades pedidas con el nuevo valor 33.*/
DELIMITER $$
CREATE PROCEDURE categoria_porcentaje (IN categoria VARCHAR(15), IN porcentaje SMALLINT)
BEGIN
DECLARE porcentajeNuevo DOUBLE;
DECLARE id_categoria INT;
SET porcentajeNuevo = 1 + porcentaje / 100;
SELECT c.CategoriaID INTO id_categoria FROM categorias c
WHERE c.CategoriaNombre = categoria;
UPDATE productos p
SET p.UnidadesPedidas = CEIL(p.UnidadesPedidas * porcentajeNuevo)
WHERE p.CategoriaID = id_categoria;
END $$
DELIMITER ;
/*b) Listar los productos de la categoría Beverages para ver cuántas unidades pedidas hay de cada uno de 
ellos.*/
SELECT * FROM productos p
INNER JOIN categorias c ON c.CategoriaID = p.CategoriaID
WHERE  c.CategoriaNombre = "Beverages";
/*c) Invocar al SP con los valores Beverages como categoría y 15 como porcentaje.*/
CALL categoria_porcentaje("Beverages", 15);
/*d) Volver a listar los productos como en (a), y validar los resultados.*/
SELECT * FROM productos p
INNER JOIN categorias c ON c.CategoriaID = p.CategoriaID
WHERE  c.CategoriaNombre = "Beverages";

/*3) Actualización de empleados*/
/*a) Crear un SP que cree una tabla con los nombres, apellidos y teléfono de contacto de todos los empleados 
que hayan sido contratados con fecha anterior a una fecha dada.*/
DELIMITER $$
CREATE PROCEDURE empleados_fecha (IN fecha DATETIME)
BEGIN
DROP TABLE IF EXISTS tabla_empleados_fecha;
CREATE TABLE tabla_empleados_fecha (
Apellido VARCHAR(20),
Nombre VARCHAR(10),
Telefono VARCHAR(24)
);
INSERT INTO tabla_empleados_fecha (Apellido, Nombre, Telefono)
SELECT emp.Apellido, emp.Nombre, emp.Telefono FROM empleados emp
WHERE emp.FechaContratacion < fecha;
END $$
DELIMITER ;
/*b) Ejecutar el SP para generar una tabla de empleados con fecha de contratación anterior a 01/01/1994.*/
CALL empleados_fecha("1994-01-01");
/*c) Consultar la tabla generada y validar los resultados.*/
SELECT * FROM tabla_empleados_fecha;