USE sakila;

/*Reportes*/


/*Reportes Parte 1*/

/*1. Obtener el nombre y apellido de los primeros 5 actores disponibles. Utilizar
alias para mostrar los nombres de las columnas en español.*/
SELECT * FROM actor
LIMIT 5;
/*2. Obtener un listado que incluya nombre, apellido y correo electrónico de los
clientes (customers) inactivos. Utilizar alias para mostrar los nombres de las
columnas en español.*/
SELECT first_name nombre, last_name apellido, email "correo electrónico" FROM customer
WHERE active = 0;
/*3. Obtener un listado de films incluyendo título, año y descripción de los films
que tienen un rental_duration mayor a cinco. Ordenar por rental_duration de
mayor a menor. Utilizar alias para mostrar los nombres de las columnas en
español.*/
SELECT title título, release_year año, description descripcion FROM film
WHERE rental_duration > 5
ORDER BY rental_duration DESC;
/*4. Obtener un listado de alquileres (rentals) que se hicieron durante el mes de
mayo de 2005, incluir en el resultado todas las columnas disponibles.*/
SELECT * FROM rental
WHERE MONTH(rental_date) = 05 AND YEAR(return_date) = 2005;


/*Reportes Parte 2*/

/*1. Obtener la cantidad TOTAL de alquileres (rentals). Utilizar un alias para
mostrarlo en una columna llamada “cantidad”.*/
SELECT COUNT(*) cantidad FROM rental;
/*2. Obtener la suma TOTAL de todos los pagos (payments). Utilizar un alias para
mostrarlo en una columna llamada “total”, junto a una columna con la
cantidad de alquileres con el alias “Cantidad” y una columna que indique el
“Importe promedio” por alquiler.*/
SELECT SUM(amount) total, COUNT(payment_id) Cantidad, AVG(amount) "Importe promedio" FROM payment;
/*3. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes
que más dinero gastan y en cuántos alquileres lo hacen?*/
SELECT first_name nombre, last_name apellido, COUNT(payment_id) alquileres, SUM(amount) suma_pagos FROM payment
INNER JOIN customer ON payment.customer_id = customer.customer_id
GROUP BY payment.customer_id
ORDER BY suma_pagos DESC
LIMIT 10;
/*4. Generar un reporte que indique: ID de cliente, cantidad de alquileres y monto
total para todos los clientes que hayan gastado más de 150 dólares en
alquileres.*/
SELECT payment.customer_id "ID cliente", COUNT(payment_id) "cantidad de alquileres", SUM(amount) monto_total FROM payment
INNER JOIN customer ON payment.customer_id = customer.customer_id
GROUP BY payment.customer_id
HAVING monto_total > 150;
/*5. Generar un reporte que muestre por mes de alquiler (rental_date de tabla
rental), la cantidad de alquileres y la suma total pagada (amount de tabla
payment) para el año de alquiler 2005 (rental_date de tabla rental).*/
SELECT MONTH(rental_date) Mes , SUM(rental.rental_id) "Cantidad de alquileres", SUM(amount) "Suma total pagada" FROM rental
INNER JOIN payment ON rental.rental_id = payment.rental_id
WHERE YEAR(rental_date) = 2005
GROUP BY MONTH(rental_date);
/*6. Generar un reporte que responda a la pregunta: ¿cuáles son los 5
inventarios más alquilados? (columna inventory_id en la tabla rental). Para
cada una de ellas indicar la cantidad de alquileres.*/
SELECT inventory_id, SUM(rental_id) cantidad_de_alquileres FROM rental
GROUP BY inventory_id
ORDER BY cantidad_de_alquileres DESC
LIMIT 5;