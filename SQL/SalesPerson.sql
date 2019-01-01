select name from salesperson
where salesperson.sales_id in (select sales_id from
orders join company
on orders.com_id = company.com_id and company.name = "RED") as id
