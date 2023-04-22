-- RESOLUCION DE E-MARKET CLASE 17 SOLO CON QUERYS SIN VISTAS

use emarket;

/*1.  mostrar Id, contacto, y el Fax. En caso que no tenga Fax, colocar el teléfono y en este caso aclararlo. Por ejemplo
'TEL: (01) 123-4567'*/

select clienteId, contacto,
coalesce(nullif(fax,""),concat("tel",telefono))
from clientes;

select clienteId, contacto,
case
	when fax = "" then concat("tel ",telefono)
end as telfax
from clientes;

/*proveedores: Id, contacto,
compañia y la dirección. Para la dirección tomar la dirección, ciudad, código
postal y país.
Listar los proveedores que vivan la calle Americanas en Brazil.*/

select proveedorid, contacto,compania, concat(direccion," ",ciudad," ", codigopostal) as direccion_mostrada 
from proveedores
where direccion like "%Americanas%" and pais like "bra%";

select  proveedorid, pais, titulo, count(*) as cantidad
from proveedores
group by pais, titulo, proveedorid
having cantidad != 1;

select * from proveedores;

/*1. Crear una vista de productos que se usará para control de stock. Incluir el id y
nombre del producto, el precio unitario redondeado sin decimales, las unidades
en stock y las unidades pedidas. Incluir además una nueva columna PRIORIDAD
con los siguientes valores:
BAJA si unidades pedidas es cero
MEDIA si unidades pedidas es menor que unidades en stock
URGENTE si unidades pedidas no duplica al número de unidades en stock
SUPERURGENTE en caso contrario*/

select ProductoID, ProductoNombre, round(PrecioUnitario), UnidadesStock, UnidadesPedidas,
case
	when unidadespedidas = 0 then "BAJA"
    when unidadespedidas < unidadesstock then "MEDIA"
    when unidadespedidas < 2 *unidadesstock then "URGENTE"
    else "SUPERURGENTE"
end as prioridad
from productos;
/*2. Se necesita un reporte de productos para identificar problemas de stock. Para
cada prioridad indicar cuántos productos hay y su precio promedio. No incluir
las prioridades para las que haya menos de 5 productos.*/

select 
case
	when unidadespedidas = 0 then "BAJA"
    when unidadespedidas < unidadesstock then "MEDIA"
    when unidadespedidas < 2 *unidadesstock then "URGENTE"
    else "SUPERURGENTE"
end as prioridad, count(*) as cantidad, avg(PrecioUnitario) as precio_promedio
from productos
group by prioridad
having cantidad > 5;
