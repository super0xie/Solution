select sub1.student_id, sub1.student_name, sub1.subject_name, count(case when not isnull(Examinations.student_id) then 1 else null end) as attended_exams 
from
(
	select *
	from Students, Subjects
	order by student_id
) sub1
left join Examinations
on sub1.student_id  = Examinations.student_id and sub1.subject_name = Examinations.subject_name
group by student_id, student_name, subject_name