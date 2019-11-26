select parent_id as post_id, count(case when not isnull(child_id) then 1 else null end) as number_of_comments 
from (
    select distinct s1.sub_id as parent_id, s2.sub_id as child_id
    from (
        select sub_id
        from Submissions
        where isnull(parent_id)
    ) s1
    left join Submissions s2
    on s1.sub_id = s2.parent_id
) sub
group by parent_id
