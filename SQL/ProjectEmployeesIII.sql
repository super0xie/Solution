select Project.project_id, Project.employee_id
from Project
join Employee
on Project.employee_id = Employee.employee_id
join (
    select Project.project_id as project_id, max(Employee.experience_years) as max
    from Project
    join Employee
    on Project.employee_id = Employee.employee_id
    group by Project.project_id
) sub
on Project.project_id = sub.project_id and Employee.experience_years = sub.max

