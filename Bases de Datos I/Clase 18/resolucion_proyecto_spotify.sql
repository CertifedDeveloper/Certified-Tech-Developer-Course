/*1 - Mostrar el la playlist más se reprodujo y el nombre del  usuario que la creó. */
select nombreusuario, count(idPlaylist) as cantidad from playlist
join usuario
on usuario.idUsuario = playlist.idusuario
group by nombreusuario;

/*2. Generar un reporte, donde se muestre el método de pago , la cantidad de operaciones que se realizaron con cada uno y el importe total .*/

select t.tipoformapago, count(p.idPagos) as cantidad_operaciones, sum(importe) as importe_total  from tipoformapago t
join datospagoxusuario dp
on t.idTipoFormaPago = dp.idDatosPagoxUsuario
join usuario u
on u.idUsuario = dp.idusuario
join suscripcion s
on s.idusuario = u.idUsuario
join pagos p
on p.idPagos = s.idpagos
group by t.TipoFormaPago;

/*3. Listar las canciones que tienen los artistas cuyo nombre contiene la letra “r” y el pertenecen al código de género 20.
*/

select c.titulo from cancion c
join generoxcancion gc
on c.idCancion = gc.IdCancion
join album a
on a.idAlbum = c.IdAlbum
join artista ar
on a.idArtista = ar.idArtista
where ar.nombre like "%r%" and IdGenero = 20;

/*Listar todos los usuarios que que pagaron con efectivo y la fecha de pago sea del 2020*/

select distinct nombreusuario from tipoformapago t
join datospagoxusuario dp
on t.idTipoFormaPago = dp.idDatosPagoxUsuario
join usuario u
on u.idUsuario = dp.idusuario
join suscripcion s
on s.idusuario = u.idUsuario
join pagos p
on p.idPagos = s.idpagos
where TipoFormaPago = "efectivo" and year(fechaPago) = 2020;

/*5. Generar un reporte de todas las canciones, cuyo álbum no posee imagen de portada. */

select c.* from cancion c
join album a
on a.idAlbum = c.IdAlbum
where imagenportada is null;

-- 6. Genera un reporte por género e informar la cantidad de canciones que posee. 
-- Si una canción tiene más de un género, debe ser incluida en la cuenta de cada uno de esos géneros.

select g.genero, count(c.idCancion) as cantidad from cancion c
join generoxcancion gc
on c.idCancion = gc.IdCancion
join genero g
on g.idGenero = gc.IdGenero
group by g.genero;

-- 7. Listar todos las playlist que no están en estado activo y a que usuario pertenecen , ordenado por la fecha de eliminación.
select playlist.titulo, usuario.nombreusuario, descripcion,Fechaeliminada from playlist
join estadoplaylist
on playlist.idestado = estadoplaylist.idEstadoPlaylist
join usuario
on usuario.idUsuario = playlist.idusuario
where estadoplaylist.descripcion = "eliminada"
order by Fechaeliminada;

-- 8. Generar un reporte que muestre por tipo de usuario, la cantidad de usuarios que posee.
select t.TipoUsuario, count(idUsuario) as cantidad from usuario u
join tipousuario t
on t.idTipoUsuario = u.IdTipoUsuario
group by t.TipoUsuario;

-- 9.Listar la suma total obtenida por cada tipo de suscripción, en el periodo del 01-01-2020 al 31-12-2020
select tu.TipoUsuario, sum(importe) as suma_total from suscripcion s
join pagos p
on s.idpagos = p.idPagos
join tipousuario tu
on tu.idTipoUsuario = s.IdTipoUsuario
where fechaPago between "2020-01-01" and "2020-12-31"
group by tu.TipoUsuario;

-- 10. Listar el álbum y la discográfica que posea la canción con más reproducciones.
select a.titulo, d.nombre from album a
join discografica d
on a.iddiscografica = d.idDiscografica
join cancion c
on c.IdAlbum = a.idAlbum
order by c.cantreproduccion desc
limit 1;

-- 11. Listar todos los usuarios que no hayan generado una playlist 
select * from usuario u
left join playlist p
on u.idUsuario = p.idusuario
where p.idPlaylist is null;

-- 12. Listar todas las canciones hayan o no recibido likes (cuántos) y aclarar si han sido reproducidas o no
-- Listar las 15 primeras ordenadas como si fueran un Ranking
select titulo, cantlikes, 
case
	when cantreproduccion > 0 then "Reproducida"
    else "no reproducida"
end as reproducida
 from cancion
 order by cantlikes desc
 limit 15;

-- 13. Generar un reporte con el nombre del artista y el nombre de la canción que no pertenecen a ninguna lista. 

select ar.nombre, c.titulo from cancion c
join album a
on c.IdAlbum = a.idAlbum
join artista ar
on a.idArtista = ar.idArtista
left join playlistxcancion pc
on c.idCancion = pc.Idcancion
where pc.idPlaylistxCancion is null;

-- 14. Listar todas las canciones, el nombre del artista, la razón social de la discográfica y  la cantidad de veces que fue reproducida.
select c.titulo, ar.nombre, d.nombre as "Razon Social", cantreproduccion  from cancion c
join album a
on c.IdAlbum = a.idAlbum
join artista ar
on a.idArtista = ar.idArtista
join discografica d
on d.idDiscografica = a.iddiscografica;

-- 15. Listar todas las discográficas, que pertenezcan a Inglaterra y la cantidad de álbumes que hayan editado. 

select d.idDiscografica, d.nombre, count(a.idalbum) as cantidad from discografica d
join pais p
on d.idPais = p.idPais
join album a
on a.iddiscografica = d.idDiscografica
where p.pais = "inglaterra"
group by d.idDiscografica, d.nombre;

-- 16. Listar a todos los artistas que no poseen ningún álbum. 
select Nombre from artista ar
left join album a
on ar.idArtista = a.idArtista
where idAlbum is null;

-- 17. Listar todos los álbumes que tengan alguna canción que posea más de un género
select a.titulo, c.titulo, count(gc.idgenero) as generos from cancion c
join album a
on c.IdAlbum = a.idAlbum
join generoxcancion gc
on gc.IdCancion = c.idCancion
group by a.titulo, c.titulo
having generos > 1;

-- 18. Generar un reporte por usuario , listando las suscripciones que tiene o tuvo, el importe que abonó y  los datos de las formas de pago con que lo realizó.
select u.nombreusuario, tu.TipoUsuario, sum(p.importe) as total,t.TipoFormaPago  from usuario u
join suscripcion s
on u.idUsuario = s.idusuario
join pagos p
on p.idPagos = s.idpagos
join tipousuario tu
on tu.idTipoUsuario = s.IdTipoUsuario
join datospagoxusuario d
on u.idUsuario = d.idusuario
join tipoformapago t
on d.idTipoFormaPago = t.idTipoFormaPago
group by tu.TipoUsuario, u.nombreusuario, t.TipoFormaPago;
