select s2.customer_id
from (select customer_id, count(product_key) as count
from (select distinct customer_id, product_key
from Customer) as s1
group by customer_id) as s2
where s2.count in (
    select count(product_key)
    from Product
)