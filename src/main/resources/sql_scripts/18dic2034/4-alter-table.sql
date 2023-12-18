ALTER TABLE `zoo`.`departments` ADD dummy VARCHAR(45) NOT NULL DEFAULT "default value";
ALTER TABLE `zoo`.`departments` RENAME COLUMN dummy TO dummy2;
ALTER TABLE `zoo`.`departments` RENAME COLUMN dummy2 TO dummy;
ALTER TABLE `zoo`.`departments` MODIFY COLUMN dummy VARCHAR(100) NULL;
ALTER TABLE `zoo`.`departments` DROP COLUMN dummy;
