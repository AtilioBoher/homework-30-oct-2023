-- Departments 
INSERT INTO `zoo`.`departments` (`name`,`description`) VALUES
("Cleaning Department", "The Cleaning Department is in charge of cleaning the facilities"),
("Security Department", "The Security Department is in charge of the security of all the dangerous attractions"),
("Custumers Department", "The Custumers Department is in charge of all things related with customers");
INSERT INTO `zoo`.`departments` (`name`) VALUES
("Animals Department"),  -- This one lacks the description
("To delete");

-- Attractions
INSERT INTO `zoo`.`attractions` (`name`, `description`) VALUES
("Lions", "This attraction is a cage that contains the lions"),
("Crocodiles", " a jslask lks jlkas djlaskdj "),
("To update", "This attraction is a cage that contains the elephants"),
("Birds", "This attraction is composed of many cages, all with a particular type of bird"),
("To delete", "faslajsldfalshdfas");

-- Linking department and attractions tables
INSERT INTO `zoo`.`department_attractions` (`department_id`, `attraction_id`) VALUES
(2, 1), (2, 2), (2, 3), -- Security Department, only takes care of dangerous attractions
(3, 1), (3, 2), (3, 3), (3, 4), -- Customers Department, takes care of all attractions
(4, 1), (4, 2), (4, 3), (4, 4); -- Animals Department, takes care of all attractions

-- Animals
INSERT INTO `zoo`.`animals` (`name`, `age`, `specie`, `attraction_id`) VALUES
("To update", 8, "Lion", 1),
("Tafarel", 10, "Lion", 1),
("To update", 5, "Lion", 1),
("Rafael", 8, "Crocodile", 2),
("Rolando", 10, "Crocodile", 2),
("Sonya", 6, "Crocodile", 2),
("To delete", 5, "Lion", 1),
("To delete", 8, "Crocodile", 2),
("To delete", 10, "Crocodile", 2);


-- Employees
INSERT INTO `zoo`.`employees` (`first_name`, `last_name`, `position`, `years_of_exp`, `department_id`) VALUES
-- Cleaning Department
("John", "Smith", "Manager", 10, 1),
("Josh", "Borsh", "Manager Assistant", 5, 1),
("Janne", "Swarts", "Cleaner", 2, 1),
-- Security Department
("Olivia", "Bennett", "Animal protection specialist", 15, 2),
("Marcus", "Rodriguez", "Officers Chief", 11, 2),
("Chloe", "Anderson", "Officer", 4, 2),
-- Animals Department
("Emma", "Reynolds", "Veterinarian Chief", 12, 4),
("Noah", "Mitchell", "Veterinarian", 11, 4),
-- To delete later
("Isabella", "Rodriguez", "Animal protection specialist", 15, 2),
("Mason", "Thompson", "Officers Chief", 11, 2),
("Grace", "Mitchell", "Officer", 4, 2),
("Aria", "Anderson", "Officer", 10, 2),
("Maya", "Davis", "Officer", 9, 2),
("Caleb", "Taylor", "Officer", 7, 2);

-- Employees that don't belong to any departments
INSERT INTO `zoo`.`employees` (`first_name`, `last_name`, `position`, `years_of_exp`) VALUES
("Susan", "Mueler", "Cleaner", 1),
("Tasha", "Rullier", "Cleaner", 3),
("Jackson", "Hayes", "Officer", 10),
("Maya", "Patel", "Officer", 9),
("Ethan", "Morgan", "Officer", 7),
("Sophia", "Turner", "Veterinarian", 5),
("Liam", "Parker", "Veterinarian", 10);




