select s1.Score as Score, s2.Rank as Rank
from Scores s1
join (SELECT Score, @n := @n + 1 Rank
  FROM  (select distinct Score
 from Scores
 ORDER BY Score desc) as s, (SELECT @n := 0 AS INT) m) s2
 on s1.Score = s2.Score
 order by Score desc