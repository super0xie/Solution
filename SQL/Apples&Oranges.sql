select Sales.sale_date, Sales.sold_num-s1.sold_num as diff
from Sales
join (  
    select sale_date, sold_num
    from Sales
    where fruit = 'oranges'
) s1
on Sales.sale_date = s1.sale_date and Sales.fruit = 'apples'