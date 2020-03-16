select distinct Sales.product_id, Product.product_name as product_name
from Sales
join Product
on Sales.product_id = Product.product_id
where sale_date >= CAST("2019-01-01" AS DATE) and sale_date <= CAST("2019-03-31" AS DATE) and Sales.product_id not in
(
    select product_id
    from Sales
    where sale_date < CAST("2019-01-01" AS DATE) or sale_date > CAST("2019-03-31" AS DATE)
)
