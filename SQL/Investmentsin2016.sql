# Write your MySQL query statement below
select sum(val) as TIV_2016
from
(select distinct t1.PID as id, t1.TIV_2016 as val
from insurance t1, insurance t2
where t1.PID <> t2.PID and t1.TIV_2015 = t2.TIV_2015) s1
where id in 
(select distinct t3.PID as id
from insurance t3, insurance t4
where t3.PID <> t4.PID and t3.LAT = t4.LAT and T3.LON = t4.LON
)