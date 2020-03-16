select min(dis) as shortest
from
(
select sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y)) as dis
from point_2d p1, point_2d p2
where p1.x <> p2.x or p1.y <>p2.y
) as q1