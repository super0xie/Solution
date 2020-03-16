select id, IF(p_id is null, "Root", IF(id in (select p_id from tree), "Inner", "Leaf" )) as Type 
from tree
order by id