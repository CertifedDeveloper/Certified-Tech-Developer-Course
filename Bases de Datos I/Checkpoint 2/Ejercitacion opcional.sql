use movies_db;

SELECT COUNT(*) FROM movies_db.movies;

SELECT COUNT(*) FROM movies_db.movies
WHERE awards BETWEEN 3 AND 7;

SELECT COUNT(*) FROM movies_db.movies
WHERE awards BETWEEN 3 AND 7 AND rating > 7;

SELECT genre_id, COUNT(*) FROM movies_db.movies
GROUP BY genre_id;

SELECT genre_id, SUM(awards), COUNT(*) FROM movies_db.movies
GROUP BY genre_id
HAVING SUM(awards) > 5;