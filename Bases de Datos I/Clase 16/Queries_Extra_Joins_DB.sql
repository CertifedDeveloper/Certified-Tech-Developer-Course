USE extra_joins;
/*1. Obtener los artistas que han actuado en una o más películas.*/
SELECT * FROM artista
INNER JOIN artista_x_pelicula ON artista.id = artista_x_pelicula.artista_id
INNER JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id;
/*2. Obtener las películas donde han participado más de un artista según nuestra
base de datos.*/
SELECT * FROM pelicula
INNER JOIN artista_x_pelicula ON artista_x_pelicula.pelicula_id = pelicula.id 
INNER JOIN artista ON artista_x_pelicula.artista_id = artista.id;
/*3. Obtener aquellos artistas que han actuado en alguna película, incluso
aquellos que aún no lo han hecho, según nuestra base de datos.*/
SELECT * FROM artista
LEFT JOIN artista_x_pelicula ON artista.id = artista_x_pelicula.artista_id
LEFT JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id;
/*4. Obtener las películas que no se le han asignado artistas en nuestra base de
datos.*/
SELECT * FROM pelicula
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.pelicula_id = pelicula.id 
LEFT JOIN artista ON artista_x_pelicula.artista_id = artista.id
WHERE artista.id IS NULL;
/*5. Obtener aquellos artistas que no han actuado en alguna película, según
nuestra base de datos.*/
SELECT * FROM artista
LEFT JOIN artista_x_pelicula ON artista.id = artista_x_pelicula.artista_id
LEFT JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
WHERE pelicula.id IS NULL;
/*6. Obtener aquellos artistas que han actuado en dos o más películas según
nuestra base de datos.*/
SELECT artista.id, apellido, nombre FROM artista
INNER JOIN artista_x_pelicula ON artista.id = artista_x_pelicula.artista_id
INNER JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
GROUP BY artista.id
HAVING COUNT(artista.id) > 1;
/*7. Obtener aquellas películas que tengan asignado uno o más artistas, incluso
aquellas que aún no le han asignado un artista en nuestra base de datos.*/
SELECT * FROM pelicula
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.pelicula_id = pelicula.id 
LEFT JOIN artista ON artista_x_pelicula.artista_id = artista.id;