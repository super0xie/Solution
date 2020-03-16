select if(count(DISTINCT session_id) > 0, round(count(DISTINCT session_id)/count(DISTINCT user_id), 2), 0) as average_sessions_per_user
from Activity
where DATEDIFF('2019-07-27', activity_date) < 30