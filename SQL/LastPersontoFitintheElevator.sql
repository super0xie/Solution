select person_name
from (
    select q1.person_id, q1.person_name, sum(q2.weight) as sum_weight
    from Queue q1
    join Queue q2
    on q2.turn <= q1.turn
    group by q1.person_id
    having sum(q2.weight) <= 1000
    order by sum_weight desc
) sub
limit 1
