select actor_id, director_id
from (select actor_id, director_id, count(timestamp) as c
from ActorDirector
group by actor_id, director_id) as sub
where c > 2