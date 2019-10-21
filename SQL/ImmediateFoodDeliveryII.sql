select cast(count(*) * 100 / (select count(distinct Delivery.customer_id) from Delivery ) as decimal(10,2)) as immediate_percentage 
from
(
    select Delivery.customer_id
    from Delivery
    join
    (
        select customer_id, min(order_date) as order_date
        from Delivery
        group by customer_id
    ) s1
    on Delivery.customer_id = s1.customer_id and Delivery.order_date = s1.order_date
    where Delivery.order_date = Delivery.customer_pref_delivery_date
) s2