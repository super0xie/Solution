select query_name, round(count(case when rating < 3 then 1 else null end) / count(*) * 100, 2) as poor_query_percentage, 
round(sum(rating / position) / count(*), 2) as quality 
from Queries
group by query_name