USE zoo;

-- Counts the number of employees in each department, but only display the ones where the maximum years of experiance it's greater than 14
SELECT d.name department_name, COUNT(DISTINCT CONCAT(e.first_name, ' ', e.last_name)) AS number_of_employees
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name HAVING MAX(e.years_of_exp) > 14;

-- Counts the number of employees in each department, but only display the ones where the minimum years of experiance it's lower than 3
SELECT d.name department_name, COUNT(DISTINCT CONCAT(e.first_name, ' ', e.last_name)) AS number_of_employees
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name HAVING MIN(e.years_of_exp) < 3;

-- Minimum years of experience (only lower than 4) in each department
SELECT d.name department_name, MIN(e.years_of_exp) AS minimum_years_of_experience
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name HAVING MIN(e.years_of_exp) < 4;

-- Average years of experience (only the ones greater than 10) in each department
SELECT d.name department_name, AVG(e.years_of_exp) AS average_years_of_experience
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name HAVING AVG(e.years_of_exp) > 10;

-- Maximum years of experience (only the ones greater than 11) in each department
SELECT d.name department_name, MAX(e.years_of_exp) AS maximum_years_of_experience
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name HAVING MAX(e.years_of_exp) > 11;

-- Count number of animals in each attraction, but displays only the ones where the minimun age it's lower than 6
SELECT atr.name, COUNT(an.name) AS number_of_animals
FROM attractions atr LEFT JOIN animals an ON an.attraction_id = atr.id GROUP BY atr.name HAVING MIN(an.age) < 6;

-- Count number of animals in each attraction, but displays only the ones where the maximum age it's greater than 6
SELECT atr.name, COUNT(an.name) AS number_of_animals
FROM attractions atr LEFT JOIN animals an ON an.attraction_id = atr.id GROUP BY atr.name HAVING MAX(an.age) > 10;



