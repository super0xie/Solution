select employee_id, sub.team_size
from Employee
join (
	select team_id, count(*) as team_size
	from Employee
	group by team_id
) sub
on Employee.team_id = sub.team_id


