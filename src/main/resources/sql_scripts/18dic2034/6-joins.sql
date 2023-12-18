USE zoo;

-- Using LEFT JOIN we get all the elements from the left table (employees), even the ones that don't
-- belong to any department (right table), because the LEFT join selects all in the LEFT table, even if there is no match.
SELECT e.first_name employee_fist_name, e.last_name employee_last_name, d.name department_name
FROM employees e LEFT JOIN departments d ON d.id = e.department_id;

-- Similarly, using RIGHT JOIN, we get the same table, but this time with all the elements from the right table (departments),
-- even if there is no match with the left table (employees). In this case we get the Customers Department,
-- that doesn't have any employees in it.
SELECT e.first_name employee_fist_name, e.last_name employee_last_name, d.name department_name
FROM employees e RIGHT JOIN departments d ON d.id = e.department_id;

-- And if we need only the elements that are related (employees that belong to a deparment),
-- and not the ones that are not related (employees that don't belong to any deparment, and deparments with no employees),
-- then we need to use INNER JOIN, which only returns the elements that have a match.
SELECT e.first_name employee_fist_name, e.last_name employee_last_name, d.name department_name
FROM employees e INNER JOIN departments d ON d.id = e.department_id;

-- MySQL doesn't have OUTER JOIN (returns all records when there is a match in left (table1) or right (table2) table records),
-- but there is a trick to emulate doing a left join and a right join, and then using union to combine the resulting tables.
-- https://stackoverflow.com/questions/4796872/how-can-i-do-a-full-outer-join-in-mysql#:~:text=You%20don%27t%20have%20full%20joins%20in%20MySQL%2C%20but%20you%20can%20sure%20emulate%20them.
SELECT e.first_name employee_fist_name, e.last_name employee_last_name, d.name department_name
FROM employees e LEFT JOIN departments d ON d.id = e.department_id
UNION
SELECT e.first_name employee_fist_name, e.last_name employee_last_name, d.name department_name
FROM employees e RIGHT JOIN departments d ON d.id = e.department_id;