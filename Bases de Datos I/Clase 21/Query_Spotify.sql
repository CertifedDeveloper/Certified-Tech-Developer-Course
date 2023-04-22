USE proyectospotify;


/*Responder las siguientes preguntas:*/

/*1. ¿Cuál es la diferencia entre LEFT y RIGHT JOIN?*/
/*LEFT JOIN muestra los resultados de la intersección de dos tablas más la información de la primera tabla
declarada que no tiene relación con la segunda tabla.  El RIGHT JOIN muestra los resultados de la 
intersección de dos tablas más la información de la segunda tabla declarada que no tiene realción con la
primera tabla*/
/*2. ¿Cuál es el orden en el que se procesan las queries SELECT, FROM, WHERE,
GROUP BY, HAVING y ORDER BY?*/
/*Primero FROM, segundo WHERE, tercero GROUP BY, cuarto HAVING, quinto SELECT, sexto ORDER BY.*/
/*3. ¿Qué función podríamos utilizar si quisiéramos traer el promedio de likes de
todas las canciones?*/
/*AVG(cantlikes)*/
/*4. Si tenemos una query que trae un listado ordenado por el ID de usuarios la cual
cuenta con un LIMIT 20 OFFSET 27, ¿cuál sería el primer ID de los registros y cuál
el último?*/
/*El primer ID  sería el 28 y el último el 48*/
/*5. ¿Por qué no se recomienda utilizar en exceso DISTINCT, ORDER BY y GROUP BY?*/
/*Debido a que consumen elevada cantidad de recursos*/


/*Realizar los siguientes informes*/

/*1. Mostrar la cantidad de canciones que pertenecen a ambos géneros pop y rock
cuyo nombre contiene la letra “m”.*/
SELECT * FROM cancion c
INNER JOIN generoxcancion gc ON c.idCancion = gc.IdCancion
INNER JOIN genero g ON g.idGenero = gc.IdGenero
WHERE g.Genero = "Rock" AND g.Genero = "Pop" AND titulo LIKE "%m%";
/*2. Listar todas las canciones que pertenezcan a más de una playlist. Incluir en el
listado el nombre de la canción, el código y a cuántas playlists pertenecen.*/
SELECT c.titulo, c.idCancion, COUNT(plxc.IdPlaylist) Cantidad FROM cancion c
INNER JOIN playlistxcancion plxc ON c.idCancion = plxc.Idcancion
GROUP BY c.idCancion;
/*3. Generar un reporte con el nombre del artista y el nombre de la canción que no
pertenecen a ninguna lista, ordenados alfabéticamente por el nombre del
artista.*/
SELECT art.Nombre, c.titulo FROM artista art
INNER JOIN album alb ON art.idArtista = alb.idArtista
INNER JOIN cancion c ON c.IdAlbum = alb.idAlbum
LEFT JOIN playlistxcancion plxc ON plxc.Idcancion = c.idCancion
WHERE plxc.IdPlaylist IS NULL
ORDER BY art.Nombre;
/*4. Modificar el país de todos los usuarios con el código postal “7600” a “Argentina”.*/
UPDATE usuario usr
SET usr.CP = "7600"
WHERE usr.Pais_idPais = 1;
/*5. Listar todos los álbumes que tengan alguna canción que posea más de un
género.*/
SELECT a.titulo TituloAlbum, c.titulo TituloCancion, COUNT(gxc.IdGenero) CantidadGeneros FROM album a
INNER JOIN cancion c ON a.idAlbum = c.IdAlbum
INNER JOIN generoxcancion gxc ON c.idCancion = gxc.IdCancion
GROUP BY c.titulo;
/*6. Crear un índice agrupado para las canciones cuyo identificador sea el ID.*/
CREATE UNIQUE INDEX idx_idCancion
ON cancion (idCancion);
DROP INDEX idx_idCancion ON cancion;
SHOW INDEXES FROM cancion;