select Queries.id, Queries.year, ifnull(NPV.npv, 0) as npv
from Queries
left join NPV
on Queries.id = NPV.id and Queries.year = NPV.year