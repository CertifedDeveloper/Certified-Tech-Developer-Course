/*Consignas*/

/*1) Empleados*/
/*a) Crear un SP que liste los apellidos y nombres de los empleados ordenados
alfabéticamente.*/
DELIMITER $$
CREATE PROCEDURE datos_empleados ()
BEGIN
SELECT Apellido, Nombre FROM empleados emp
ORDER BY emp.Apellido, emp.Nombre;
END $$
/*b) Invocar el SP para verificar el resultado.*/
CALL datos_empleados();

/*2) Empleados por ciudad*/
/*a) Crear un SP que reciba el nombre de una ciudad y liste los empleados de esa
ciudad.*/
DELIMITER $$
CREATE PROCEDURE datos_empleados_ciudad (IN ciudad VARCHAR(15))
BEGIN
SELECT Apellido, Nombre FROM empleados emp
WHERE emp.Ciudad = ciudad;
END $$
/*b) Invocar al SP para listar los empleados de Seattle.*/
CALL datos_empleados_ciudad("Seattle");

/*3) Clientes por país*/
/*a) Crear un SP que reciba el nombre de un país y devuelva la cantidad de clientes
en ese país.*/
DELIMITER $$
CREATE PROCEDURE cantidad_clientes_pais (IN pais VARCHAR(15))
BEGIN
SELECT COUNT(*) Cantidad FROM clientes cl
WHERE cl.Pais = pais;
END $$
/*b) Invocar el SP para consultar la cantidad de clientes en Portugal.*/
CALL cantidad_clientes_pais("Portugal");

/*4) Productos sin stock*/
/*a) Crear un SP que reciba un número y liste los productos cuyo stock está por
debajo de ese número. El resultado debe mostrar el nombre del producto, el
stock actual y el nombre de la categoría a la que pertenece el producto.*/
DELIMITER $$
CREATE PROCEDURE productos_stock (IN numero SMALLINT)
BEGIN
SELECT p.ProductoNombre, p.UnidadesStock, c.CategoriaNombre FROM productos p
INNER JOIN categorias c ON c.CategoriaID = p.CategoriaID
WHERE p.UnidadesStock < numero;
END $$
/*b) Listar los productos con menos de 10 unidades en stock.*/
CALL productos_stock(10);
/*c) Listar los productos sin stock.*/
CALL productos_stock(1);

/*5) Ventas con descuento*/
/*a) Crear un SP que reciba un porcentaje y liste los nombres de los productos que
hayan sido vendidos con un descuento igual o superior al valor indicado,
indicando además el nombre del cliente al que se lo vendió.*/
DELIMITER $$
CREATE PROCEDURE productos_descuento (IN porcentaje SMALLINT)
BEGIN
DECLARE porcentajeNuevo DOUBLE;
SET porcentajeNuevo = porcentaje / 100;
SELECT p.ProductoNombre,  cl.Compania FROM productos p
INNER JOIN facturadetalle fd ON fd.ProductoID = p.ProductoID
INNER JOIN facturas f ON f.FacturaID = fd.FacturaID
INNER JOIN clientes cl ON cl.ClienteID = f.ClienteID
WHERE fd.Descuento >= porcentajeNuevo;
END $$
/*b) Listar la información de los productos que hayan sido vendidos con un
descuento mayor al 10%*/
CALL productos_descuento(10);