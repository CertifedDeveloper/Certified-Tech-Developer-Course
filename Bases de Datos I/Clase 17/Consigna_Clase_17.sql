USE musimundos;

SELECT UPPER(SUBSTRING(nombre, 1, 10)) CANCION, ROUND(bytes / 1024,0) KBYTES, CONCAT("$", FORMAT(precio_unitario, 3)) PRECIO, SUBSTRING(compositor, 1, INSTR(compositor, ',') - 1) COMPOSITOR FROM canciones;