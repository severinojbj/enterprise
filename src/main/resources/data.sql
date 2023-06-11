CREATE TABLE `departments` (
	`dept_num` char(4) NOT NULL,
	`dept_name` varchar(100) NOT NULL,
	PRIMARY KEY (`dept_num`)
);

CREATE TABLE `dept_manager` (
	`emp_num` INT NOT NULL,
	`dept_num` char(4) NOT NULL,
	`from_date` DATE NOT NULL,
	`to_date` DATE NOT NULL,
	PRIMARY KEY (`emp_num`,`dept_num`)
);

CREATE TABLE `employees` (
	`emp_num` INT NOT NULL,
	`birth_date` DATE NOT NULL,
	`first_name` varchar (40) NOT NULL,
	`last_name` varchar (40) NOT NULL,
	`gender` char(1) NOT NULL,
	`hire_date` DATE NOT NULL,
	PRIMARY KEY (`emp_num`)
);

CREATE TABLE `dept_emp` (
	`emp_num` INT NOT NULL,
	`dept_num` char(4) NOT NULL,
	`from_date` DATE NOT NULL,
	`to_date` DATE NOT NULL,
	PRIMARY KEY (`emp_num`,`dept_num`)
);

CREATE TABLE `salaries` (
	`emp_num` int NOT NULL,
	`salary` int NOT NULL,
	`from_date` DATE NOT NULL,
	`to_date` DATE NOT NULL,
	PRIMARY KEY (`emp_num`)
);

CREATE TABLE `titles` (
	`emp_num` int NOT NULL,
	`title` varchar (100) NOT NULL,
	`from_date` DATE NOT NULL,
	`to_date` DATE NOT NULL,
	PRIMARY KEY (`emp_num`)
);

ALTER TABLE `dept_emp` ADD CONSTRAINT `dept_emp_fk0` FOREIGN KEY (`emp_num`) REFERENCES `employees`(`emp_num`);

ALTER TABLE `dept_emp` ADD CONSTRAINT `dept_emp_fk1` FOREIGN KEY (`dept_num`) REFERENCES `departments`(`dept_num`);

ALTER TABLE `dept_manager` ADD CONSTRAINT `dept_manager_fk0` FOREIGN KEY (`emp_num`) REFERENCES `employees`(`emp_num`);

ALTER TABLE `dept_manager` ADD CONSTRAINT `dept_manager_fk1` FOREIGN KEY (`dept_num`) REFERENCES `departments`(`dept_num`);

ALTER TABLE `salaries` ADD CONSTRAINT `salaries_fk0` FOREIGN KEY (`emp_num`) REFERENCES `employees`(`emp_num`);

ALTER TABLE `titles` ADD CONSTRAINT `titles_fk0` FOREIGN KEY (`emp_num`) REFERENCES `employees`(`emp_num`);
