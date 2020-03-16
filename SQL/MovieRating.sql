
select title
from(
	select Movie_Rating.movie_id, sum(Movie_Rating.rating) / count(Movie_Rating.rating) as rat, Movies.title
	from Movie_Rating
	join Movies
	on Movie_Rating.movie_id = Movies.movie_id and year(Movie_Rating.created_at) = 2020 and month(Movie_Rating.created_at) = 2
	group by Movie_Rating.movie_id
	order by rat desc, Movies.title asc
) sub1
limit 1


select Movie_Rating.user_id, count(movie_id) as cnt
from Movie_Rating
group by Movie_Rating.user_id
order by cnt desc