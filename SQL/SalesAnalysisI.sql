select seller_id
from Sales
group by seller_id
having sum(price) = 
(
    select sum(price)
    from Sales
    group by seller_id
    ORDER BY sum(price) desc
    LIMIT 1
)
