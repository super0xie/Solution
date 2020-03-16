select distinct page_id as recommended_page
from(
    select * from
    (select user1_id, user2_id from Friendship 
    union
    select user2_id, user1_id from Friendship) sub1
    join Likes
    on user1_id = 1 and user2_id = user_id 
) sub2
where page_id not in
(
    select page_id 
    from Likes 
    where user_id = 1
)