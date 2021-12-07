delete
t1 from Person t1, Person t2
where t1.Email = t2.Email and t1.Id > t2.Id