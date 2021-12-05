SELECT
    a.NAME AS Employee
FROM
    Employee AS a
INNER JOIN
    Employee AS b
ON
    a.ManagerId = b.Id
AND
    a.Salary > b.Salary