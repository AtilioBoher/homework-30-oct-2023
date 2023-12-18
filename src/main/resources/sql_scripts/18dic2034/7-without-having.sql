USE zoo;

-- Counts the number of employees in each department
SELECT d.name department_name, COUNT(DISTINCT CONCAT(e.first_name, ' ', e.last_name)) AS number_of_employees
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name;

-- Counts the number of employees that doesn't belong to any department
SELECT d.name department_name, COUNT(DISTINCT CONCAT(e.first_name, ' ', e.last_name)) AS number_of_employees
FROM departments d RIGHT JOIN employees e ON d.id = e.department_id WHERE ISNULL(d.name) GROUP BY d.name;

-- Average years of experience in each department
SELECT d.name department_name, AVG(e.years_of_exp) AS average_years_of_experience
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name;

-- Maximum years of experience in each department
SELECT d.name department_name, MAX(e.years_of_exp) AS maximum_years_of_experience
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name;

-- Minimum years of experience in each department
SELECT d.name department_name, MIN(e.years_of_exp) AS minimum_years_of_experience
FROM departments d LEFT JOIN employees e ON d.id = e.department_id GROUP BY d.name;

-- Count number of animals in each attraction
SELECT atr.name, COUNT(an.name) AS number_of_animals
FROM attractions atr LEFT JOIN animals an ON an.attraction_id = atr.id GROUP BY atr.name;

-- Oldest animal in each attraction
SELECT atr.name, MAX(an.age) AS max_animal_age
FROM attractions atr LEFT JOIN animals an ON an.attraction_id = atr.id GROUP BY atr.name;

