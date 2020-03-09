select Invoices.invoice_id, Customers.customer_name, Invoices.price, IFNULL(sub.contacts_cnt, 0) as contacts_cnt, IFNULL(sub.trusted_contacts_cnt, 0) as trusted_contacts_cnt
from Invoices
join Customers
on Invoices.user_id = Customers.customer_id
left join
(
	select user_id, count(*) as contacts_cnt, count(case when contact_email in (
	select email
	from Customers
	) then 1 else null end) as trusted_contacts_cnt
	from Contacts
	group by user_id
) sub
on Invoices.user_id = sub.user_id
order by Invoices.invoice_id
