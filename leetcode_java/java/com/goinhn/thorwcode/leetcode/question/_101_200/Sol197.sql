select a.id
from weather as a
         inner join weather as b on datediff(a.recordDate, b.recordDate) = 1
where a.temperature > b.temperature;