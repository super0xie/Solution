select Users.user_id as seller_id, if(isnull(s4.item_brand), "no", if(Users.favorite_brand = s4.item_brand, "yes", "no")) as 2nd_item_fav_brand
from Users
left join
(
    select s3.seller_id, Items.item_brand
    from Items 
    join
    (
        select Orders.seller_id, Orders.order_date, Orders.item_id
        from Orders
        join (   
            select Orders.seller_id, min(Orders.order_date) as mindate
            from Orders
            join (   
                select min(order_date) as order_date, seller_id
                from Orders
                group by seller_id
            ) s1
            on s1.seller_id = Orders.seller_id and Orders.order_date > s1.order_date
            group by Orders.seller_id
        ) s2
        on s2.seller_id = Orders.seller_id and Orders.order_date = s2.mindate
    ) s3
    on Items.item_id  = s3.item_id
) s4
on Users.user_id = s4.seller_id


