USE emarket;
/*Vistas - Parte I*/


/*Clientes*/

/*1. Crear una vista con los siguientes datos de los clientes: ID, contacto, y el
Fax. En caso de que no tenga Fax, colocar el teléfono, pero aclarándolo. Por
ejemplo: “TEL: (01) 123-4567”.*/
CREATE VIEW clientesView AS
SELECT ClienteID ID, Contacto, 
CASE 
WHEN Fax = "" THEN CONCAT("TELF: ",COALESCE(NULLIF(Fax, ""), Telefono))
ELSE Fax 
END
Fax 
FROM emarket;

/*2. Se necesita listar los números de teléfono de los clientes que no tengan
fax. Hacerlo de dos formas distintas:*/
/*a. Consultando la tabla de clientes.*/
SELECT Telefono FROM clientes
WHERE Fax = "";
/*b. Consultando la vista de clientes*/
SELECT Fax FROM clientesview
WHERE Fax LIKE "TELF: %";


/*Proveedores*/

/*1. Crear una vista con los siguientes datos de los proveedores: ID,
contacto, compañía y dirección. Para la dirección tomar la dirección,
ciudad, código postal y país.*/
CREATE VIEW proveedoresView AS
SELECT ProveedorID ID, Contacto, Compania, CONCAT(Direccion, ", ", Ciudad, ", ", CodigoPostal, ", ", Pais) Direccion FROM proveedores;
/*2. Listar los proveedores que vivan en la calle Americanas en Brasil. Hacerlo
de dos formas distintas:*/
/*a. Consultando la tabla de proveedores.*/
SELECT * FROM proveedores
WHERE Pais = "Brazil" AND Direccion LIKE "%Americanas%";
/*b. Consultando la vista de proveedores.*/
SELECT * FROM proveedoresView
WHERE Direccion LIKE "%Americanas%Brazil";


/*Vistas - Parte II*/

/*1. Crear una vista de productos que se usará para control de stock. Incluir el ID
y nombre del producto, el precio unitario redondeado sin decimales, las
unidades en stock y las unidades pedidas. Incluir además una nueva
columna PRIORIDAD con los siguientes valores:
■ BAJA: si las unidades pedidas son cero.
■ MEDIA: si las unidades pedidas son menores que las unidades
en stock.
■ URGENTE: si las unidades pedidas no duplican el número de
unidades.
■ SUPER URGENTE: si las unidades pedidas duplican el número
de unidades en caso contrario.*/
CREATE VIEW productosView AS
SELECT ProductoID ID, ProductoNombre, ROUND(PrecioUnitario, 0) PrecioUnitario, UnidadesStock, UnidadesPedidas,
CASE
WHEN UnidadesPedidas = 0 THEN "BAJA"
WHEN UnidadesPedidas < UnidadesStock THEN "MEDIA"
WHEN UnidadesPedidas < 2 * UnidadesStock THEN "URGENTE"
WHEN UnidadesPedidas > 2 * UnidadesStock THEN "SUPER URGENTE"
END
Prioridad
FROM productos;
/*2. Se necesita un reporte de productos para identificar problemas de stock.
Para cada prioridad indicar cuántos productos hay y su precio promedio.
No incluir las prioridades para las que haya menos de 5 productos.*/
SELECT Prioridad, COUNT(ID) Cantidad, AVG(PrecioUnitario) "Precio Promedio" FROM productosview
GROUP BY Prioridad
HAVING COUNT(ID) >= 5;