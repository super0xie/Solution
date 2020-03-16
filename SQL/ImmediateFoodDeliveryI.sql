select cast(count(*) * 100 / (
    select count(*)
    from Delivery
) as decimal(10,2)) as immediate_percentage
from Delivery
where order_date = customer_pref_delivery_date
