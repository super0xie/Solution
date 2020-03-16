select min(diff) as shortest
from
(
select abs(p1.x-p2.x) as diff
from point p1, point p2
where p1.x != p2.x
) as q1