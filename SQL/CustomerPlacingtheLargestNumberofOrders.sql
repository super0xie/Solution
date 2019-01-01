select customer_number 
from (
select count(order_number) as count, customer_number
from orders
group by customer_number
) as s
where count in (select max(count)
from (
select count(order_number) as count
from orders 
group by customer_number 
) as m)