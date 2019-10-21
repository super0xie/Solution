select month, country, count(id) as trans_count, count(case when state = 'approved' then 1 else 0 end) as approved_count, 
sum(amount) as trans_total_amount, sum(case when state = 'approved' then amount else 0 end) as approved_total_amount
from
(
    select id, country, state, amount, concat(year(trans_date), "-", RIGHT(concat("0", MONTH(trans_date)), 2)) as month
    from Transactions
) sub
group by sub.month, sub.country
