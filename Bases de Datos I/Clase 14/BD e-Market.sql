USE emarket;

/*Parte I - GROUP BY*/

/*Clientes*/
/*1) ¿Cuántos clientes existen?*/
SELECT COUNT(*) AS "Total Clientes" FROM clientes;
/*2) ¿Cuántos clientes hay por ciudad*/
SELECT Ciudad, COUNT(*) AS Total FROM clientes
GROUP BY Ciudad;

/*Facturas*/
/*1) ¿Cuál es el total de transporte?*/
SELECT SUM(Transporte) AS "Total Transporte" FROM facturas;
/*2) ¿Cuál es el total de transporte por EnvioVia (empresa de envío)?*/
SELECT EnvioVia, SUM(Transporte) AS "Total transporte" FROM facturas
GROUP BY EnvioVia;
/*3) Calcular la cantidad de facturas por cliente. Ordenar descendentemente por
cantidad de facturas.*/
SELECT ClienteID, COUNT(*) AS cantidadFacturas FROM facturas
GROUP BY ClienteID
ORDER BY cantidadFacturas DESC;
/*4) Obtener el Top 5 de clientes de acuerdo a su cantidad de facturas.*/
SELECT ClienteID, COUNT(*) AS cantidadFacturas FROM facturas
GROUP BY ClienteID
ORDER BY cantidadFacturas DESC
LIMIT 5;
/*5) ¿Cuál es el país de envío menos frecuente de acuerdo a la cantidad de facturas?*/
SELECT PaisEnvio, COUNT(*) AS cantidadFacturas FROM facturas
GROUP BY PaisEnvio
ORDER BY cantidadFacturas
LIMIT 1;
/*6) Se quiere otorgar un bono al empleado con más ventas. ¿Qué ID de empleado
realizó más operaciones de ventas?*/
SELECT EmpleadoID, COUNT(*) AS cantidadFacturas FROM facturas
GROUP BY EmpleadoID
ORDER BY cantidadFacturas DESC
LIMIT 1;

/*Factura detalle*/
/*1) ¿Cuál es el producto que aparece en más líneas de la tabla Factura Detalle?*/
SELECT ProductoID, COUNT(*) AS totalProductos FROM facturadetalle
GROUP BY ProductoID
ORDER BY totalProductos DESC
LIMIT 1;
/*2) ¿Cuál es el total facturado? Considerar que el total facturado es la suma de
cantidad por precio unitario.*/
SELECT SUM(PrecioUnitario * Cantidad) AS totalFacturado FROM facturadetalle;
/*3) ¿Cuál es el total facturado para los productos ID entre 30 y 50?*/
SELECT SUM(PrecioUnitario * Cantidad) AS totalFacturado FROM facturadetalle
WHERE  ProductoID BETWEEN 30 AND 50;
/*4) ¿Cuál es el precio unitario promedio de cada producto?*/
SELECT ProductoID, AVG(PrecioUnitario) AS promedioPrecioUnitario FROM facturadetalle
GROUP BY ProductoID;
/*5) ¿Cuál es el precio unitario máximo?*/
SELECT ProductoID, MAX(PrecioUnitario) AS maxPrecioUnitario FROM facturadetalle;


/*Parte II - Join*/

/*1) Generar un listado de todas las facturas del empleado 'Buchanan'.*/
SELECT * FROM facturas
INNER JOIN empleados ON facturas.EmpleadoID = empleados.EmpleadoID
WHERE Apellido = "Buchanan";
/*2) Generar un listado con todos los campos de las facturas del correo 'Speedy
Express'.*/
SELECT * FROM facturas
INNER JOIN correos ON facturas.EnvioVia = correos.CorreoID
WHERE Compania = "Speedy Express";
/*3) Generar un listado de todas las facturas con el nombre y apellido de los
empleados.*/
SELECT * FROM facturas
INNER JOIN empleados ON facturas.EmpleadoID = empleados.EmpleadoID;
/*4) Mostrar un listado de las facturas de todos los clientes “Owner” y país de envío
“USA”.*/
SELECT * FROM facturas
INNER JOIN clientes ON facturas.ClienteID = clientes.ClienteID
WHERE Titulo = "Owner" AND PaisEnvio = "USA";
/*5) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
“Leverling” o que incluyan el producto id = “42”.*/
SELECT * FROM facturas
INNER JOIN empleados ON facturas.EmpleadoID = empleados.EmpleadoID
INNER JOIN facturadetalle ON facturas.FacturaID = facturadetalle.FacturaID
WHERE Apellido = "Leverling" AND ProductoID = 42;
/*6) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
“Leverling” y que incluya los producto id = “80” o ”42”.*/
SELECT * FROM facturas
INNER JOIN empleados ON facturas.EmpleadoID = empleados.EmpleadoID
INNER JOIN facturadetalle ON facturas.FacturaID = facturadetalle.FacturaID
WHERE Apellido = "Leverling" AND (ProductoID = 80 OR ProductoID = 42);
/*7) Generar un listado con los cinco mejores clientes, según sus importes de
compras total (PrecioUnitario * Cantidad).*/
SELECT * , (PrecioUnitario * Cantidad) AS totalFacturacion FROM facturas
INNER JOIN facturadetalle ON facturas.FacturaID = facturadetalle.FacturaID
ORDER BY totalFacturacion DESC
LIMIT 5;
/*8) Generar un listado de facturas, con los campos id, nombre y apellido del cliente,
fecha de factura, país de envío, Total, ordenado de manera descendente por
fecha de factura y limitado a 10 filas.*/
SELECT facturas.FacturaID, Compania, FechaFactura, PaisEnvio, (PrecioUnitario * Cantidad) AS Total FROM facturas
INNER JOIN clientes ON facturas.ClienteID = clientes.ClienteID
INNER JOIN facturadetalle ON facturadetalle.FacturaID = facturas.FacturaID
ORDER BY FechaFactura DESC
LIMIT 10;