select extra as report_reason, count(DISTINCT post_id) as report_count
from Actions
where DATEDIFF(action_date , '2019-07-05') = -1 and extra is not null
group by extra