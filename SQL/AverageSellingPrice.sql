select UnitsSold.product_id, cast(sum(UnitsSold.units * Prices.price) / sum(UnitsSold.units) as decimal(10,2)) as average_price
from UnitsSold
join Prices
on UnitsSold.product_id = Prices.product_id  and UnitsSold.purchase_date >= Prices.start_date and UnitsSold.purchase_date <= Prices.end_date
group by UnitsSold.product_id
