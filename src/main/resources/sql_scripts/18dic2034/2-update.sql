-- Add missing description
UPDATE `zoo`.`departments` SET `description` = "The Animals Department is in charge of all things related with animals" WHERE `id` = 4;

UPDATE `zoo`.`attractions` SET `description` = "This attraction is a cage that contains crocodiles" WHERE `id` = 2;
UPDATE `zoo`.`attractions` SET `name` = "Elephants" WHERE `id` = 3;

UPDATE `zoo`.`animals` SET `name` = "Zipi" WHERE `id` = 1;
UPDATE `zoo`.`animals` SET `name` = "Chandoso" WHERE `id` = 3;
UPDATE `zoo`.`animals` SET `age` = 11 WHERE `id` = 5;

UPDATE `zoo`.`employees` SET `position` = "Officer" WHERE `id` = 5;
UPDATE `zoo`.`employees` SET `position` = "Officers Chief" WHERE `id` = 6;
UPDATE `zoo`.`employees` SET `years_of_exp` = `years_of_exp` + 1 WHERE `id` = 1;
UPDATE `zoo`.`employees` SET `years_of_exp` = `years_of_exp` + 1 WHERE `id` = 2;
UPDATE `zoo`.`employees` SET `first_name` = "Jackson" WHERE `id` = 2;
