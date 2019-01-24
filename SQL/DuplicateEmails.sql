select distinct a.Email
from Person as a, Person as b
where a.Email = b.Email and a.id != b.id