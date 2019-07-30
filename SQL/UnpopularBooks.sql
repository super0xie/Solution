select Books.book_id, Books.name
from Books
where DATEDIFF(Books.available_from, '2019-06-23') < 30 and Books.book_id not in 
(
    select book_id
    from Orders
    where DATEDIFF(Orders.dispatch_date , '2019-06-23') > -365
    group by book_id
    having sum(quantity) >= 10
)