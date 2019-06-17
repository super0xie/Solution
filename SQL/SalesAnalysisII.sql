select distinct buyer_id
from Sales
join Product
on Product.product_id = Sales.product_id
where Product.product_name = "S8" and buyer_id not in
(
    select buyer_id
    from Sales
    join Product
    on Product.product_id = Sales.product_id
    where Product.product_name = "iPhone"
)