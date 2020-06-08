select s1.stock_name, s2.s-s1.s as capital_gain_loss 
from (
    select stock_name, sum(price) as s
    from Stocks
    where operation = 'Buy'
    group by stock_name
) s1
join (
    select stock_name, sum(price) as s
    from Stocks
    where operation = "Sell"
    group by stock_name
) s2
on s1.stock_name = s2.stock_name