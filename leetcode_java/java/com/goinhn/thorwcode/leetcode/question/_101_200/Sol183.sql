SELECT
    a.Name AS Customers
FROM
    Customers AS a
LEFT JOIN
    Orders AS b
ON
    a.Id = b.CustomerId
WHERE
    b.CustomerId IS NULL;