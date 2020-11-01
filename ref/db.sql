CREATE DATABASE HR DEFAULT CHARACTER SET UTF8 DEFAULT COLLATE UTF8_GENERAL_CI;
USE HR;
CREATE TABLE Department (
 dept_id INT PRIMARY KEY,
 dept_name VARCHAR(150) UNIQUE,
 dept_desc VARCHAR(100)
);
CREATE TABLE Project(
    project_id INT PRIMARY KEY,
    project_name VARCHAR (150),
    project_desc VARCHAR(100),
    dept_id INT,
    FOREIGN KEY(dept_id) REFERENCES Department(dept_id)
);
CREATE TABLE Employee(
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(120) UNIQUE,
    salary DOUBLE,
    DOB DATE,
    position VARCHAR(100),
    dept_id INT,
    FOREIGN KEY(dept_id) REFERENCES Department(dept_id)
);
CREATE TABLE Emp_car(
    emp_id INT,
    make VARCHAR(50),
    model VARCHAR(50),
    next_maintinance_date DATE,
    FOREIGN KEY(emp_id) REFERENCES Employee(emp_id)
); 

CREATE TABLE workOn(
    emp_id INT,
    project_id INT,
    PRIMARY KEY(emp_id,project_id),
    FOREIGN KEY(emp_id) REFERENCES Employee(emp_id),
    FOREIGN KEY(project_id) REFERENCES Project(project_id)
);
CREATE TABLE users (
    username VARCHAR(40) PRIMARY KEY,
    pass     VARCHAR(40) NOT NULL
);
INSERT INTO users VALUES ('a','a');
INSERT INTO users VALUES('admin','admin');