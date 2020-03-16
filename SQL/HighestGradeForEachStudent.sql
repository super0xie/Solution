select student_id, 1000 - mod(aux, 10000) as course_id, cast(aux/10000 as SIGNED) as grade
from(
    select student_id, max(grade * 10000 + 1000 - course_id) as aux
    from Enrollments
    group by student_id
) sub