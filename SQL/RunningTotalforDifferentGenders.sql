select Scores.gender, sub.day, sum(Scores.score_points) as total
from Scores
join
(
	select gender, day
	from Scores
	group by gender, day
) sub
on Scores.gender = sub.gender and Scores.day <= sub.day
group by Scores.gender, sub.day