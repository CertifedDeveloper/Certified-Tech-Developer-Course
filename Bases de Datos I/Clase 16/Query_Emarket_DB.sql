USE emarket;

/*Reportes Parte I*/
/*Realizar una consulta de la facturación de e-market. Incluir la siguiente información:
● Id de la factura
● fecha de la factura
● nombre de la empresa de correo
● nombre del cliente
● categoría del producto vendido
● nombre del producto
● precio unitario
● cantidad
*/
SELECT facturas.FacturaID, FechaFactura, correos.Compania NombreEmpresaCorreo, facturas.ClienteID NombreCliente, CategoriaNombre, ProductoNombre, facturadetalle.PrecioUnitario PrecioUnitario, facturadetalle.Cantidad FROM facturas
INNER JOIN correos ON facturas.EnvioVia = correos.CorreoID
INNER JOIN facturadetalle ON facturas.FacturaID = facturadetalle.FacturaID
INNER JOIN productos ON productos.ProductoID = facturadetalle.ProductoID
INNER JOIN categorias ON productos.CategoriaID = categorias.CategoriaID;


/*Reportes Parte II*/

/*1. Listar todas las categorías junto con información de sus productos. Incluir todas
las categorías aunque no tengan productos.*/
SELECT * FROM categorias
LEFT JOIN productos ON categorias.CategoriaID = productos.CategoriaID;
/*2. Listar la información de contacto de los clientes que no hayan comprado nunca
en emarket.*/
SELECT * FROM clientes
LEFT JOIN facturas ON clientes.ClienteID = facturas.ClienteID
WHERE facturas.FacturaID IS NULL;
/*3. Realizar un listado de productos. Para cada uno indicar su nombre, categoría, y
la información de contacto de su proveedor. Tener en cuenta que puede haber
productos para los cuales no se indicó quién es el proveedor.*/
SELECT ProductoID, ProductoNombre, CategoriaNombre, productos.ProveedorID, Compania, Contacto, Titulo, Direccion, Ciudad, Regiones, CodigoPostal, Pais, Telefono, Fax, Pagina FROM productos
INNER JOIN categorias ON productos.CategoriaID = categorias.CategoriaID
LEFT JOIN proveedores ON productos.ProveedorID = proveedores.ProveedorID;
/*4. Para cada categoría listar el promedio del precio unitario de sus productos.*/
SELECT categorias.CategoriaID, CategoriaNombre, AVG(PrecioUnitario) "Promedio Precio Unitario" FROM categorias
INNER JOIN productos ON  categorias.CategoriaID = productos.CategoriaID
GROUP BY categorias.CategoriaID;
/*5. Para cada cliente, indicar la última factura de compra. Incluir a los clientes que
nunca hayan comprado en e-market.*/
SELECT clientes.ClienteID, MAX(FacturaID) FacturaUltimaCompra FROM clientes
LEFT JOIN facturas ON clientes.ClienteID = facturas.ClienteID
GROUP BY clientes.ClienteID;
/*6. Todas las facturas tienen una empresa de correo asociada (enviovia). Generar un
listado con todas las empresas de correo, y la cantidad de facturas
correspondientes. Realizar la consulta utilizando RIGHT JOIN.*/
SELECT CorreoID, Compania, COUNT(FacturaID) CantidadFacturas FROM correos
RIGHT JOIN facturas ON correos.CorreoID = facturas.EnvioVia
GROUP BY CorreoID;