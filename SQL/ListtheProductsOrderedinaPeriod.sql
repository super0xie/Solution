select product_name, sub.unit
from Products
join
(
	select product_id, sum(unit) as unit
	from Orders
	where year(order_date) = 2020 and month(order_date) = 2
	group by product_id
) sub
on Products.product_id = sub.product_id and sub.unit >= 100
