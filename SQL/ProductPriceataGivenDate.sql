select distinct Products.product_id, IFNULL(s2.new_price, 10) as price 
from Products
left join
(
    select Products.product_id, Products.new_price
    from Products
    join 
    (
        select product_id, max(change_date) as change_date
        from Products
        where DATEDIFF('2019-08-16', change_date) >= 0
        group by product_id
    ) s
    on Products.product_id = s.product_id and Products.change_date = s.change_date
) s2
on Products.product_id = s2.product_id
