select ad_id, if(sum(case when action <> 'Ignored' then 1 else 0 end) = 0, 0, round(100 * sum(case when action = 'Clicked' then 1 else 0 end)/sum(case when action <> 'Ignored' then 1 else 0 end), 2)) as ctr
from Ads
group by ad_id
order by ctr DESC, ad_id ASC