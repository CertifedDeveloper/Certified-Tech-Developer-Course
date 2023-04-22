USE sakila;

/*EndPoints*/


/*Parte 1*/

/*1. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes
que más dinero gastan y en cuantos alquileres lo hacen?*/
SELECT first_name nombre, last_name apellido, COUNT(rental_id) CantidadAlquileres FROM customer custr
INNER JOIN rental rent ON custr.customer_id = rent.customer_id
GROUP BY custr.customer_id;
/*2. Generar un reporte que indique: el id del cliente, la cantidad de alquileres y
el monto total para todos los clientes que hayan gastado más de 150 dólares
en alquileres.*/
SELECT custr.customer_id, COUNT(rent.rental_id) CantidadAlquileres, SUM(amount) PagoAlquileres FROM customer custr
INNER JOIN rental rent ON custr.customer_id = rent.customer_id
INNER JOIN payment pay ON pay.rental_id = rent.rental_id
GROUP BY custr.customer_id;
/*3. Generar un reporte que responda a la pregunta: ¿cómo se distribuyen la
cantidad y el monto total de alquileres en los meses pertenecientes al año
2005? (tabla payment).*/
SELECT MONTHNAME(payment_date) Mes, (payment_id) Cantidad, SUM(amount) Pago FROM payment
WHERE YEAR(payment_date) = 2005
GROUP BY MONTH(payment_date);
/*4. Generar un reporte que responda a la pregunta: ¿cuáles son los 5 inventarios
más alquilados? (columna inventory_id en la tabla rental) Para cada una de
ellas, indicar la cantidad de alquileres.*/
SELECT inventory_id, SUM(rental_id) Cantidad FROM rental rent
GROUP BY inventory_id;



/*Parte 2*/

/*1. Generar un reporte que responda a la pregunta: Para cada tienda
(store), ¿cuál es la cantidad de alquileres y el monto total del dinero
recaudado por mes?*/
SELECT inv.store_id Tienda, COUNT(rent.rental_id) Cantidad, SUM(amount) Pago FROM rental rent
INNER JOIN inventory inv ON inv.inventory_id = rent.inventory_id
INNER JOIN payment pay ON pay.rental_id = rent.rental_id
GROUP BY inv.store_id;
/*2. Generar un reporte que responda a la pregunta: ¿cuáles son las 10 películas
que generan más ingresos? ¿ Y cuáles son las que generan menos ingresos?
Para cada una de ellas indicar la cantidad de alquileres.*/
SELECT title Pelicula, SUM(pay.amount) Recaudacion, COUNT(rent.rental_id) CantidadAlquileres FROM film fl
INNER JOIN inventory inv ON fl.film_id = inv.film_id
INNER JOIN rental rent ON inv.inventory_id = rent.inventory_id
INNER JOIN payment pay ON pay.rental_id = rent.rental_id
GROUP BY fl.film_id
ORDER BY Recaudacion DESC
LIMIT 10;
SELECT title Pelicula, SUM(pay.amount) Recaudacion, COUNT(rent.rental_id) CantidadAlquileres FROM film fl
INNER JOIN inventory inv ON fl.film_id = inv.film_id
INNER JOIN rental rent ON inv.inventory_id = rent.inventory_id
INNER JOIN payment pay ON pay.rental_id = rent.rental_id
GROUP BY fl.film_id
ORDER BY Recaudacion
LIMIT 10;
/*3. ¿Existen clientes que no hayan alquilado películas?*/
SELECT * FROM customer custm
LEFT JOIN rental rent ON rent.customer_id = custm.customer_id
WHERE rent.rental_id IS NULL;
/*No existen clientes que no hayan alquilado películas*/
/*4. Nivel avanzado: El jefe de stock quiere discontinuar las películas (film) con
menos alquileres (rental). ¿Qué películas serían candidatas a discontinuar?
Recordemos que pueden haber películas con 0 (Cero) alquileres.*/
SELECT title Pelicula, COUNT(rent.rental_id) CantidadAlquileres FROM film flm
LEFT JOIN inventory inv ON flm.film_id = inv.film_id
LEFT JOIN rental rent ON inv.inventory_id = rent.inventory_id
GROUP BY flm.film_id
ORDER BY CantidadAlquileres;