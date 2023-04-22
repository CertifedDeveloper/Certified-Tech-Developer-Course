/*Realizar una consulta sobre la tabla canciones con la siguiente información:
Solo los 10 primeros caracteres del nombre de la canción en mayúscula.
Los años de antigüedad que tiene cada canción desde su publicación. Ej: 25 años. 
El peso en KBytes en número entero (sin decimales, 1024 Bytes = 1 KB)
El precio formateado con 3 decimales, Ej: $100.123
El primer compositor de la canción (notar que si hay más de uno, estos se separan por coma)
*/
use musimundos;

create view compositor_query as
select upper(left(nombre,10)) as nombre, round(bytes/1024) as kbytes, format(precio_unitario,3), 
case
	when compositor = "" then "sin datos"
    when compositor not like "%,%" then compositor
    else left(compositor, locate(",",compositor)-1)
end  as compositor
from canciones;

select * from compositor_query;
drop view ccompositor_query;
delete from compositor_query;

select timestampdiff(day,fecha_nacimiento,now()) from empleados;
