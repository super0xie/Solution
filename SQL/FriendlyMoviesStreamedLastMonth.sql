select title
from Content
where Kids_content='Y' and content_type='Movies' and content_id in (
	select content_id
	from TVProgram 
	where month(program_date) = 6 and year(program_date) = 2020
)