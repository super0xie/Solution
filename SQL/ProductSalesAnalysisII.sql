select s.product_id as product_id, sum(s.quantity) as total_quantity
from Product p
right join Sales s
on p.product_id = s.product_id
group by p.product_id