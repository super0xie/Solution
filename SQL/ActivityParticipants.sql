select activity as ACTIVITY
from
(
	select activity, count(*) as cnt
	from Friends
	group by activity
	having cnt not in (
		select sub1.ma
		from
		(
			select max(cnt) as ma, min(cnt) as mi
			from (
				select count(*) as cnt
				from Friends
				group by activity
				order by cnt
			) sub
		) sub1
		union
		select sub1.mi
		from
		(
			select max(cnt) as ma, min(cnt) as mi
			from (
				select count(*) as cnt
				from Friends
				group by activity
				order by cnt
			) sub
		) sub1
		
	) 
) sub