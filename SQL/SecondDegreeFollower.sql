SELECT followee as follower, count(follower) as num
FROM follow
where followee in (
    SELECT follower
    FROM follow
)
GROUP BY followee
ORDER BY followee


-- to pass test cases
SELECT f1.follower as follower, count(DISTINCT f2.follower) as num
FROM follow f1
join follow f2
on f1.follower = f2.followee
GROUP BY f1.follower
ORDER BY f1.follower

