select e.business_id
from Events e
join(
    select event_type, sum(occurences) / count(*) as average
    from Events
    group by event_type
) sub
on e.event_type = sub.event_type
where e.occurences > sub.average
group by e.business_id
having count(*) > 1


