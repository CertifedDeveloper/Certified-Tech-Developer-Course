/*Ejercicio 1*/

/*1. Crear una vista para poder organizar los envíos de las facturas. Indicar número
de factura, fecha de la factura y fecha de envío, ambas en formato dd/mm/yyyy,
valor del transporte formateado con dos decimales, y la información del
domicilio del destino incluyendo dirección, ciudad, código postal y país, en una
columna llamada Destino.*/
CREATE VIEW facturasView AS
SELECT FacturaID NumeroFactura, DATE_FORMAT(FechaFactura, '%d/%m/%Y') FechaFactura, DATE_FORMAT(FechaEnvio, '%d/%m/%Y') FechaEnvio, FORMAT(Transporte, 2) Transporte, CONCAT(DireccionEnvio, ", ", CiudadEnvio, ", ", CodigoPostalEnvio, ", ", PaisEnvio) Destino FROM facturas fac;
/*2. Realizar una consulta con todos los correos y el detalle de las facturas que
usaron ese correo. Utilizar la vista creada.*/
SELECT Compania, ProductoID, PrecioUnitario, Cantidad, Descuento FROM facturasView
INNER JOIN facturas ON facturasView.NumeroFactura = facturas.FacturaID
INNER JOIN correos ON correos.CorreoID = facturas.EnvioVia
INNER JOIN facturadetalle ON facturasView.NumeroFactura = facturadetalle.FacturaID;
/*3. ¿Qué dificultad o problema encontrás en esta consigna? Proponer alguna
alternativa o solución.*/
/*La consulta podría heberse realizado empleando la tabla facturas directamente en vez de usar la vista.
En este caso podría haberse creado una vista nueva con la información adicional o una primera vista con
un mayor número de información que luego se puede filtrar en otra consulta.*/


/*Ejercicio 2*/

/*1. Crear una vista con un detalle de los productos en stock. Indicar id, nombre del
producto, nombre de la categoría y precio unitario.*/
CREATE VIEW productos_B AS
SELECT ProductoID, ProductoNombre, CategoriaNombre, PrecioUnitario FROM productos pro
INNER JOIN categorias cat ON pro.CategoriaID = cat.CategoriaID;
/*2. Escribir una consulta que liste el nombre y la categoría de todos los productos
vendidos. Utilizar la vista creada.*/
SELECT fac.FacturaID, ProductoNombre, CategoriaNombre FROM facturas fac 
INNER JOIN facturadetalle facdet ON fac.FacturaID = facdet.FacturaID
INNER JOIN productos_b pro_b ON facdet.ProductoID = pro_b.ProductoID;
/*3. ¿Qué dificultad o problema encontrás en esta consigna? Proponer alguna
alternativa o solución.*/
/*La consulta pudo haber utilizado la tabla productos directamente en vez de usar la vista.
En este caso podría haberse creado una vista nueva con la información adicional o una primera vista con
un mayor número de información que luego se puede filtrar en otra consulta.*/