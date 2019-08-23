select activity_date as day, count(DISTINCT user_id) as active_users
from Activity
where DATEDIFF('2019-07-27', activity_date) < 30
group by activity_date
having count(DISTINCT user_id) > 1
