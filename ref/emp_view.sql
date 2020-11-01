CREATE VIEW Emp_Data
AS 
SELECT emp_id AS 'ID',
       emp_name AS 'Name',
       salary,
       DOB AS 'Date_Of_Birth',
       position,
       Employee.dept_id AS 'Department_id',
       dept_name  AS 'Department'
FROM Employee,Department WHERE Employee.dept_id = Department.dept_id; 

CREATE VIEW Department_Data
AS
SELECT dept_id AS 'ID',
       dept_name AS 'Department',
       dept_desc AS 'Description'
FROM Department;

CREATE VIEW Project_Data
AS
SELECT project_id AS 'ID',
       project_name AS 'Name',
       project_desc AS 'Description',
       project.dept_id AS 'Department_id',
        dept_name AS 'Department'
FROM project , Department WHERE 
project.dept_id = Department.dept_id;

CREATE VIEW Employee_Car_Data
AS
SELECT Employee.emp_id AS 'Employee_id',
       emp_name AS 'Employee_Name',
       make,
       model,
       next_maintinance_date
FROM Employee , emp_car WHERE Employee.emp_id = emp_car.emp_id;


CREATE VIEW workOn_Data
AS
SELECT workon.dept_id AS 'Department_id',
       dept_name AS 'Department_Name',
       workon.project_id AS 'Project_id',
       project_name AS 'Project_Name'
FROM workon , Department , project 
WHERE workon.dept_id = Department.dept_id
AND   workon.project_id = project.project_id;