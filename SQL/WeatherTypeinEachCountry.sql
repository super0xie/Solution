select country_name, if(sub.av >= 25, 'Hot', if(sub.av <= 15, 'Cold', 'Warm')) as weather_type
from Countries
join
(
	select country_id, sum(weather_state) / count(*) as av
	from Weather
	where MONTH(day) = '11' and YEAR(day) = '2019'
	group by country_id
) sub
on Countries.country_id  = sub.country_id
