select customer_id, name
from Customers
where customer_id in (
    select Orders.customer_id
    from Orders
    join Product
    on month(order_date) = 6 and year(order_date) = 2020 and Orders.product_id = Product.product_id
    group by Orders.customer_id
    having sum(price * quantity) >= 100
)

and customer_id in (
    select Orders.customer_id
    from Orders
    join Product
    on month(order_date) = 7 and year(order_date) = 2020 and Orders.product_id = Product.product_id
    group by Orders.customer_id
    having sum(price * quantity) >= 100
)