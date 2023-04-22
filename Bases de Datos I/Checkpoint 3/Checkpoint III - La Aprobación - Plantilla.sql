
-- ================= BASE DE DATOS I - PROYECTO - LA APROBACION ================== --
-- =============================== CHECKPOINT III ================================ --
-- Base de datos: la_aprobacion.sql
-- Equipo N°:
-- Integrantes: 


-- 1. Listar los servicios básicos de la habitación número 25.
-- rows:


-- 2. Listar absolutamente todos los servicios básicos y la cantidad de habitaciones en las que están instalados. Mostrar solo el nombre del servicio básico y cantidad
-- rows:


-- 3. Listar todos los huéspedes que tengan tres o más check-in. Mostrar el número de huésped, apellido y nombre separado por un espacio dentro de una misma columna denominada "Cliente" y, la cantidad de check-in que posee.
-- rows:


-- 4. Listar todos los huéspedes que no tengan un check-in. Mostrar el número de huésped, apellido y nombre en mayúsculas dentro de una misma columna denominada "huésped sin check-in".
-- rows:


-- 5. Listar todos los huéspedes que tengan al menos un check-in que corresponda a la habitación de clase 'Classic'. Se debe mostrar el número de huésped, apellido, nombre, número de habitación y la clase.
-- rows:


-- 6. Listar los huéspedes que tengan una o más reservas y que en la segunda letra de su apellido contenga una "u". Se debe mostrar el número de huésped, apellido, nombre, nombre del servicio.
-- rows:


-- 7. Listar absolutamente todos los países y la cantidad de huéspedes que tengan.
-- rows:


-- 8. Calcular el importe total y la cantidad de reservas realizadas en el mes de marzo por cada huésped. Mostrar el apellido del huésped, importe total y cantidad de reservas.
-- rows:


-- 9. Calcular el importe total recaudado por mes (fecha de entrada) para la habitación número 22. Mostrar el número de habitación, nombre de la decoración, clase, nombre del mes y el importe total.
-- rows:


-- 10. Determinar la recaudación total por país para las habitaciones número 5, 10 y 22. Mostrar nombre del país, número de habitación y el total recaudado.
-- rows:


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
-- rows:


-- 17. Calcular la edad de los empleados de Argentina. Mostrar el apellido, nombre y la edad del empleado.
-- rows:


-- 18. Calcular el importe total para los check-in realizados por el huésped 'Mercado Joel'. Mostrar apellido, nombre, importe total y el país de origen.
-- rows:


-- 19. Listar la forma de pago empleada por cada servicio extra. Se debe mostrar el nombre del servicio extra, nombre de la forma de pago y calcular la cantidad y total recaudado.
-- rows:


-- 20. Listar la forma de pago empleada para el servicio extra 'Sauna' y los huéspedes correspondientes. Se debe mostrar el nombre del servicio extra, nombre de la forma de pago, numero del cliente e importe total.
-- rows:


