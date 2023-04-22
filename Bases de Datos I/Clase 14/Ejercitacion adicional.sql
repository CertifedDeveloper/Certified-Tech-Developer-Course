use movies_db;

SELECT title, genres.name FROM series
INNER JOIN genres ON genre_id = genres.id;

SELECT title, actors.first_name, actors.last_name FROM episodes
INNER JOIN actor_episode ON episode_id = episodes.id
INNER JOIN actors ON actor_id = actors.id;

SELECT first_name, last_name FROM actors
INNER JOIN actor_movie ON actors.id = actor_id
INNER JOIN movies ON movie_id = movies.id
WHERE title LIKE "%La Guerra de las galaxias%";

SELECT genres.name, COUNT(*) AS Total FROM movies
INNER JOIN genres ON genre_id = genres.id
GROUP BY genres.name;