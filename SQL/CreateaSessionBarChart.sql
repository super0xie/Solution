select '[0-5>' as Bin, count(*) as TOTAL
from Sessions
where duration >= 0 && duration < 300
union
select '[5-10>' as Bin, count(*) as TOTAL
from Sessions
where duration >= 300 && duration < 600
union
select '[10-15>' as Bin, count(*) as TOTAL
from Sessions
where duration >= 600 && duration < 900
union
select '15 or more' as Bin, count(*) as TOTAL
from Sessions
where duration > 900