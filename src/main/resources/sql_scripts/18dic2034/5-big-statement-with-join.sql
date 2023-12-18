USE zoo;
SELECT 
d.name department_name,
e.first_name employee_first_name,
e.last_name employee_last_name,
e.position employee_position,
e.years_of_exp employee_years_of_experience,
atr.name attraction_name,
an.name animal_name
FROM departments d
INNER JOIN employees e on e.department_id = d.id
LEFT JOIN department_attractions da on d.id = da.department_id
LEFT JOIN attractions atr on atr.id = da.attraction_id
INNER JOIN animals an on an.attraction_id = atr.id;
