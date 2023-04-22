USE la_aprobacion;

/*Consigna Checkpoint II*/

/*1. Listar todos los huéspedes cuyo nombre comience con la letra "S". Se debe
mostrar id como "Número de huésped", apellido y nombre.*/
SELECT id "Número de huésped", apellido, nombre FROM la_aprobacion.huesped
WHERE nombre LIKE "S%";
/*2. Mostrar el número de legajo del empleado con domicilio "Av. Rosalind Franklin
600".*/
SELECT legajo FROM empleado
WHERE domicilio = "Av. Rosalind Franklin 600";
/*3. Se requiere saber cuál es el mayor importe registrado en las reservas.*/
SELECT MAX(importe) "Mayor importe" FROM reserva;
/*4. Listar las reservas realizadas con números 15, 19, 21, 35.*/
SELECT * FROM reserva
WHERE id IN (15, 19, 21, 35);
/*5. Calcular el importe total recaudado para la habitación número 40. El reporte
debe tener dos columnas denominadas "Número de habitación " y el "Importe
Total".*/
SELECT habitacion_numero "Número de habitación", SUM(importe) Importe FROM checkin
WHERE habitacion_numero = 40
GROUP BY habitacion_numero;
/*6. Listar de manera ordenada (fecha de nacimiento), los empleados que no
pertenezcan al sector 3 y que la fecha de nacimiento sea mayor que 3/9/1989 o
igual a 7/11/1986.*/
SELECT * FROM empleado
WHERE sector_id != 3 AND (fecha_nacimiento > "1989-09-03" OR fecha_nacimiento = "1986-11-07")
ORDER BY fecha_nacimiento;
/*7. Listar los importes de las reservas con valor entre $10499,50 a $12000,00
(ordenarlos por el importe de mayor a menor).*/
SELECT * FROM reserva
WHERE importe BETWEEN 10499.50 AND 12000.00
ORDER BY importe DESC;
/*8. Mostrar el quinto importe del check-in realizado con menor valor.*/
SELECT * FROM checkin
ORDER BY importe
LIMIT 1
OFFSET 4;
/*9. Mostrar el check-in con mayor importe. Este reporte debe contener el número
del check-in, fecha de entrada y el importe.*/
SELECT id, fecha_entrada, importe FROM checkin
ORDER BY importe DESC
LIMIT 1;
/*10. Mostrar las diez reservas con menor importe. Este reporte debe contener el
número de reserva, importe y el número del servicio.*/
SELECT id, importe, servicio_extra_id FROM reserva
ORDER BY importe
LIMIT 10;
/*11. Listar las reservas registradas entre 14/07/21 al 15/08/21 (ordenarlos por fecha)*/
SELECT * FROM reserva
WHERE fecha BETWEEN "2021-07-14" AND "2021-08-15"
ORDER BY fecha;
/*12. Listar en forma ordenada los check-in que tengan un importe superior o igual a
$34125,00 y con fecha de salida inferior a 26/6/2020.*/
SELECT * FROM checkin
WHERE importe >= 34125.00 AND fecha_salida < "2020-06-26"
ORDER BY importe, fecha_salida;
/*13. Listar todos los empleados cuyo nombre termine con los caracteres "ia". Se debe
mostrar el legajo, apellido, nombre y teléfono móvil.*/
SELECT legajo, apellido, nombre, telefono_movil FROM empleado
WHERE nombre LIKE "%ia";
/*14. Se desea conocer cuál es el importe promedio de las reservas que se hayan
pagado en efectivo.*/
SELECT AVG(importe) importe_promedio_efectivo FROM reserva
INNER JOIN forma_pago ON reserva.forma_pago_id = forma_pago.id
WHERE nombre = "Efectivo";
/*15. Mostrar el tercer check-in con mayor importe pagado con tarjeta de crédito.*/
SELECT * FROM checkin
INNER JOIN forma_pago ON checkin.forma_pago_id = forma_pago.id
WHERE nombre = "Tarjeta de crédito"
ORDER BY importe DESC
LIMIT 1
OFFSET 2;
/*16. Calcular la cantidad de check-in que tiene la habitación número siete. El reporte
debe tener dos columnas denominadas "Habitación" y el "Cantidad".*/
SELECT habitacion_numero Habitación, COUNT(*) Cantidad FROM checkin
WHERE habitacion_numero = 7;
/*17. Mostrar todos los domicilios de los huéspedes que contengan una palabra de
cinco caracteres, pero el tercer carácter debe ser igual a "n".*/
SELECT * FROM huesped
WHERE domicilio LIKE "__n__" OR domicilio LIKE "% __n__ %" OR domicilio LIKE "% __n__" OR domicilio LIKE "__n__ %";
/*18. Modificar el tipo de decoración "italiana" por "romana"*/
UPDATE decoracion
SET nombre = "Romana"
WHERE id = 3;
/*19. Agregar al huésped Palermo Díaz Ricardo Omar cuyo pasaporte es 28001555 y
fecha de nacimiento 5/1/1980, domiciliado en calle Av. Sarmiento 752 este -
Argentina, teléfono móvil +542645667714 y el correo electrónico es
pal1980sj@gmail.com.*/
INSERT INTO huesped (apellido, nombre, pasaporte, fecha_nacimiento, domicilio, pais_id, telefono_movil, email)
VALUES ("Palermo Díaz", "Ricardo Omar", "28001555", "1980-01-05", "Av. Sarmiento 752 este", 1, "+542645667714", "pal1980sj@gmail.com");
/*20. Eliminar el registro del servicio básico número 5*/
DELETE FROM habitacion_x_servicio_basico WHERE servicio_basico_id = 5;
DELETE FROM servicio_basico WHERE id = 5;
/*DELETE habitacion_x_servicio_basico, servicio_basico FROM habitacion_x_servicio_basico
INNER JOIN servicio_basico ON habitacion_x_servicio_basico.servicio_basico_id = servicio_basico.id
WHERE servicio_basico.id = 5;*/