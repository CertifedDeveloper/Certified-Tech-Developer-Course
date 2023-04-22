-- ================= BASE DE DATOS I - PROYECTO - LA APROBACION ================== --
-- =============================== CHECKPOINT III ================================ --
-- Base de datos: la_aprobacion.sql
-- Equipo N°: 4
-- Integrantes: Paloma Gras, Cristian Besada, Arturo Hernandez, Marcos Suarez 


-- 1. Listar los servicios básicos de la habitación número 25.

SELECT sb.nombre
FROM servicio_basico sb
LEFT JOIN habitacion_x_servicio_basico hxsb ON sb.id = hxsb.servicio_basico_id
LEFT JOIN habitacion hab ON hxsb.habitacion_numero = hab.numero
WHERE hab.numero = 25;

-- 2. Listar absolutamente todos los servicios básicos y la cantidad de habitaciones en las que están instalados. Mostrar solo el nombre del servicio básico y cantidad

SELECT sb.nombre, COUNT(hab.numero) AS canthabxsb
FROM servicio_basico sb
LEFT JOIN habitacion_x_servicio_basico hxsb ON sb.id = hxsb.servicio_basico_id
LEFT JOIN habitacion hab ON hxsb.habitacion_numero = hab.numero
GROUP BY sb.nombre;

-- 3. Listar todos los huéspedes que tengan tres o más check-in. Mostrar el número de huésped, apellido y nombre separado por un espacio dentro de una misma columna denominada "Cliente" y, la cantidad de check-in que posee.

SELECT CONCAT(hus.id, " ", hus.apellido, " ", hus.nombre) AS Cliente, COUNT(chec.id) AS cantCheckin
FROM huesped hus
LEFT JOIN checkin chec ON hus.id = chec.huesped_id
GROUP BY hus.id
HAVING cantCheckin >= 3;

-- 4. Listar todos los huéspedes que no tengan un check-in. Mostrar el número de huésped, apellido y nombre en mayúsculas dentro de una misma columna denominada "huésped sin check-in".

SELECT CONCAT(hus.id, " ",  UPPER(hus.apellido), " ", UPPER(hus.nombre)) AS "huésped sin check-in"
FROM huesped hus
LEFT JOIN checkin chec ON hus.id = chec.huesped_id
WHERE chec.id IS NULL;

-- 5. Listar todos los huéspedes que tengan al menos un check-in que corresponda a la habitación de clase 'Classic'. Se debe mostrar el número de huésped, apellido, nombre, número de habitación y la clase.

SELECT hus.id, hus.apellido, hus.nombre, hab.numero, cl.nombre
FROM huesped hus
INNER JOIN checkin chec ON hus.id = chec.huesped_id
LEFT JOIN habitacion hab ON chec.habitacion_numero = hab.numero
LEFT JOIN clase cl ON hab.clase_id = cl.id
WHERE cl.nombre = "Classic"
GROUP BY hus.id, hab.numero;

-- 6. Listar los huéspedes que tengan una o más reservas y que en la segunda letra de su apellido contenga una "u". Se debe mostrar el número de huésped, apellido, nombre, nombre del servicio.
-- rows:

SELECT huesped.id AS nroHuesped, huesped.apellido, huesped.nombre, servicio_extra.nombre AS nombre_servicio
FROM huesped
INNER JOIN reserva ON huesped.id = huesped_id
INNER JOIN servicio_extra ON servicio_extra.id = servicio_extra_id 
WHERE apellido LIKE '_u%';

-- 7. Listar absolutamente todos los países y la cantidad de huéspedes que tengan.
-- rows:

SELECT pais.nombre AS pais, COUNT(huesped.id) AS cantidadHuespedes
FROM pais
LEFT JOIN huesped ON pais.id = pais_id
GROUP BY pais.id;

-- 8. Calcular el importe total y la cantidad de reservas realizadas en el mes de marzo por cada huésped. Mostrar el apellido del huésped, importe total y cantidad de reservas.
-- rows:

SELECT sum(importe) AS importeTotal, count(reserva.id) AS cantidadReservas
FROM reserva
INNER JOIN huesped ON huesped_id = huesped.id
WHERE MONTH(fecha) = '03';

-- 9. Calcular el importe total recaudado por mes (fecha de entrada) para la habitación número 22. Mostrar el número de habitación, nombre de la decoración, clase, nombre del mes y el importe total.
-- rows:

SELECT ch.habitacion_numero as "Número de habitación", d.nombre as "Decoración", cl.nombre as Clase, monthname(ch.fecha_entrada) as Mes, sum(ch.importe)
FROM checkin ch 
JOIN habitacion ha ON ha.numero=ch.habitacion_numero
JOIN decoracion d ON d.id=ha.decoracion_id
JOIN clase cl ON cl.id=ha.clase_id
WHERE ch.habitacion_numero = 22
GROUP BY monthname(ch.fecha_entrada);

-- 10. Determinar la recaudación total por país para las habitaciones número 5, 10 y 22. Mostrar nombre del país, número de habitación y el total recaudado.
-- rows:

SELECT p.nombre, ha.numero AS numeroHabitacion, SUM(ci.importe) AS importeTotal
FROM pais p
LEFT JOIN huesped h ON h.pais_id = p.id
LEFT JOIN checkin ci ON ci.huesped_id = h.id
LEFT JOIN habitacion ha ON ha.numero = ci.habitacion_numero
WHERE ha.numero IN (5, 10, 22)
GROUP BY p.id, ha.numero;


-- 11. Calcular la recaudación total de cada forma de pago para las reservas. Mostrar la forma de pago y el total.
-- rows:
SELECT fp.nombre "Forma de pago", SUM(importe) Total FROM forma_pago fp
INNER JOIN reserva rsv ON fp.id = rsv.forma_pago_id
GROUP BY fp.nombre;

-- 12. Listar los empleados del sector 'administración' que su país de origen sea 'Argentina'. Mostrar el número de legajo, apellido, la primera inicial del primer nombre y un punto, nombre de su país de origen y el nombre del sector. 
-- rows:
SELECT emp.legajo Legajo, emp.apellido Apellido, CONCAT(LEFT(emp.nombre, 1), '.') "Inicial Primer Nombre", p.nombre Pais, sct.nombre Sector FROM sector sct
INNER JOIN empleado emp ON sct.id = emp.sector_id
INNER JOIN pais p ON p.id = emp.pais_id
WHERE sct.nombre = "Administración" AND p.nombre = "Argentina";

-- 13. Listar todos los servicios básicos que tienen las habitaciones (desde la 20 hasta la 24) y su clase. Mostrar número de habitación, clase y el nombre de los servicios básicos. Ordenar por número de habitación y servicio.
-- rows:
SELECT hb.numero "Número habitación", cls.nombre Clase, sb.nombre "Servicio Básico" FROM servicio_basico sb
INNER JOIN habitacion_x_servicio_basico hpsb ON sb.id = hpsb.servicio_basico_id
INNER JOIN habitacion hb ON hpsb.habitacion_numero = hb.numero
INNER JOIN clase cls ON hb.clase_id = cls.id
WHERE hb.numero BETWEEN 20 AND 24
ORDER BY hb.numero, sb.nombre;

-- 14. Listar las decoraciones que no están aplicadas en ninguna habitación.
-- rows:
SELECT * FROM decoracion dc
LEFT JOIN habitacion hb ON dc.id = hb.decoracion_id
WHERE hb.decoracion_id IS NULL;

-- 15. Listar todos los empleados categorizados por edad. Las categorías son: 'junior' (hasta 35 años), 'semi-senior' (entre 36 a 40 años) y 'senior' (más de 40). Mostrar el apellido, nombre, edad, categoría y ordenar de mayor a menor por categoría y edad.
-- rows:
SELECT apellido Apellido, nombre Nombre, TIMESTAMPDIFF(YEAR,emp.fecha_nacimiento,NOW()) Edad,
CASE 
WHEN TIMESTAMPDIFF(YEAR,emp.fecha_nacimiento,NOW()) <= 35 THEN "junior"
WHEN TIMESTAMPDIFF(YEAR,emp.fecha_nacimiento,NOW()) <= 40 THEN "semi-senior"
ELSE "senior" 
END Categoria
FROM empleado emp
ORDER BY Categoria DESC, Edad DESC;

-- 16. Calcular la cantidad y el promedio de cada forma de pago para los check-in. Mostrar la forma de pago, cantidad y el promedio formateado con dos decimales.

SELECT fp.nombre, COUNT(ci.id) AS cantidadPagos, ROUND(AVG(importe), 2) AS importePromedio
FROM forma_pago fp
LEFT JOIN checkin ci ON ci.forma_pago_id = fp.id
GROUP BY fp.id;

-- 17. Calcular la edad de los empleados de Argentina. Mostrar el apellido, nombre y la edad del empleado.

SELECT e.apellido, e.nombre, TIMESTAMPDIFF(YEAR, e.fecha_nacimiento, DATE(NOW())) AS edad
FROM empleado e
LEFT JOIN pais p ON p.id = e.pais_id
WHERE p.nombre = "Argentina";

-- 18. Calcular el importe total para los check-in realizados por el huésped 'Mercado Joel'. Mostrar apellido, nombre, importe total y el país de origen.

SELECT h.apellido, h.nombre, SUM(ci.importe) AS importeTotal, p.nombre AS pais
FROM huesped h
LEFT JOIN checkin ci ON ci.huesped_id = h.id
LEFT JOIN pais p ON p.id = h.pais_id
WHERE h.apellido = "Mercado"
AND h.nombre = "Joel"
GROUP BY h.id;


-- 19. Listar la forma de pago empleada por cada servicio extra. Se debe mostrar el nombre del servicio extra, nombre de la forma de pago y calcular la cantidad y total recaudado.

SELECT se.nombre AS servicioExtra, fp.nombre AS formaPago, COUNT(r.id) AS cantidadPagos, SUM(r.importe) AS importaTotal
FROM servicio_extra se
INNER JOIN reserva r ON r.servicio_extra_id = se.id
INNER JOIN forma_pago fp ON fp.id = r.forma_pago_id
GROUP BY se.id, fp.id;

-- 20. Listar la forma de pago empleada para el servicio extra 'Sauna' y los huéspedes correspondientes. Se debe mostrar el nombre del servicio extra, nombre de la forma de pago, numero del cliente e importe total.

SELECT se.nombre AS servicioExtra, fp.nombre AS formaPago, h.id AS numeroCliente, SUM(r.importe) AS importaTotal
FROM servicio_extra se
LEFT JOIN reserva r ON r.servicio_extra_id = se.id
LEFT JOIN forma_pago fp ON fp.id = r.forma_pago_id
LEFT JOIN huesped h ON h.id = r.huesped_id
WHERE se.nombre = "Sauna"
GROUP BY se.id, h.id, fp.id;

