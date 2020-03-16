select name, bonus
from Employee as e
join Bonus as b
on e.empId = b.empId and b.bonus < 1000
union
select name, null as bonus
from Employee
where empId not in(
select empId
from Bonus
)

