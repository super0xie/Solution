select Name
from
(select count(*) as c, e2.Name as Name
from Employee e1 
join Employee e2
on e1.ManagerId = e2.Id
group by e2.Name) r1
where c >= 5