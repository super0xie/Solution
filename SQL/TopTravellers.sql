select name, ifnull(sub.distance, 0) as travelled_distance 
from Users
left join (
	select user_id, sum(distance) as distance
	from Rides
	group by user_id
) sub
on Users.id = sub.user_id
order by distance desc, name