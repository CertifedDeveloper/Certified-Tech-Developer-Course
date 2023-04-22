/*Where*/

/*1. Mostrar los nombre de los productos que tengan cualquier combinación de
‘mountain bike’
Tablas: Product
Campos: Name*/
SELECT Name FROM product
WHERE Name LIKE "%mountain%bike%";
/*2. Mostrar las personas cuyo nombre empiece con la letra “y”
Tablas: Contact
Campos: FirstName*/
SELECT FirstName FROM contact
WHERE FirstName LIKE "y%";


/*Order by*/

/*1. Mostrar cinco productos más caros y su nombre ordenado en forma alfabética
Tablas: Product
Campos: Name, ListPrice*/
SELECT Name, ListPrice FROM product
ORDER BY ListPrice DESC, Name
LIMIT 5;


/*Operadores y joins*/

/*1. Mostrar el nombre concatenado con el apellido de las personas cuyo apellido sea
johnson
Tablas: Contact
Campos: FirstName, LastName*/
SELECT CONCAT(FirstName, " ", LastName) Nombre FROM contact
WHERE LastName = "Johnson";
/*2. Mostrar todos los productos cuyo precio sea inferior a 150$ de color rojo o cuyo
precio sea mayor a 500$ de color negro
Tablas: Product
Campos: ListPrice, Color*/
SELECT ListPrice, Color FROM product
WHERE (ListPrice < 150 AND Color = "Red") OR (ListPrice > 500 AND Color = "Black");


/*Funciones de agregación*/

/*1. Mostrar la fecha más reciente de venta
Tablas: SalesOrderHeader
Campos: OrderDate*/
SELECT MIN(OrderDate) "Fecha más reciente" FROM salesorderheader;
/*2. Mostrar el precio más barato de todas las bicicletas
Tablas: Product
Campos: ListPrice, Name*/
SELECT Name, MIN(ListPrice) "Precio más barato" FROM product;


/*Group by*/

/*1. Mostrar los productos y la cantidad total vendida de cada uno de ellos
Tablas: SalesOrderDetail
Campos: ProductID, OrderQty*/
SELECT ProductID, SUM(OrderQty) Cantidad FROM salesorderdetail
GROUP BY ProductID;


/*Having*/

/*1. Mostrar la cantidad de facturas que vendieron más de 20 unidades.
Tablas: Sales.SalesOrderDetail
Campos: SalesOrderID, OrderQty*/
SELECT ProductID, SUM(OrderQty) Cantidad FROM salesorderdetail
GROUP BY ProductID
HAVING Cantidad > 20;


/*Joins*/

/*1. Mostrar el código de logueo, número de territorio y sueldo básico de los
vendedores
Tablas: Employee, SalesPerson
Campos: LoginID, TerritoryID, Bonus, BusinessEntityID*/
SELECT  sp.SalesPersonID, emp.LoginID, sp.TerritoryID, sp.Bonus FROM salesperson sp
LEFT JOIN employee emp ON sp.SalesPersonID = emp.EmployeeID;
/*2. Mostrar los productos que sean ruedas
Tablas: Product, ProductSubcategory
Campos: Name, ProductSubcategoryID*/
SELECT p.Name, psc.ProductSubcategoryID, psc.Name FROM product p
INNER JOIN productsubcategory psc ON p.ProductSubcategoryID = psc.ProductSubcategoryID
WHERE psc.Name = "Wheels";
/*3. Mostrar los nombres de los productos que no son bicicletas
Tablas: Product, ProductSubcategory
Campos: Name, ProductSubcategoryID*/
SELECT p.Name, psc.ProductSubcategoryID, psc.Name FROM product p
RIGHT JOIN productsubcategory psc ON p.ProductSubcategoryID = psc.ProductSubcategoryID
WHERE psc.Name NOT LIKE "%Bikes%";