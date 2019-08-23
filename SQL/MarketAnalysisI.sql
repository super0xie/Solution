select Users.user_id as buyer_id , Users.join_date, IFNULL(s1.count, 0) as orders_in_2019 
from
(
    select Orders.buyer_id, Users.join_date, count(Orders.order_id) as count
    from Orders
    join Users
    on Orders.buyer_id = Users.user_id and year(Orders.order_date) = 2019
    group by Orders.buyer_id
) s1
right join
Users 
on s1.buyer_id = Users.user_id



