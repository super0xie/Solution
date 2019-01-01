select x, y, z, IF(x+y<=z or x+z<=y or y+z<=x, "No", "Yes") as triangle 
from triangle 