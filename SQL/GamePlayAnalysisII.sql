select Activity.player_id, Activity.device_id
from Activity
join
(
    select player_id, min(event_date) as mindate
    from Activity
    group by player_id
) as sub
on Activity.player_id = select.player_id and Activity.event_date = sub.mindate

