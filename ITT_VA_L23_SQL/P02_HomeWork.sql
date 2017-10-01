/*1.	Write a SQL query to find the average salary in the "Sales" department. Use AVG().*/
SELECT d.department_name,
       Round(Avg(salary), 2)
FROM   departments AS d
       INNER JOIN employees AS e
               ON( e.department_id = d.department_id )
GROUP  BY department_name;

/*2.	Write a SQL query to find the number of employees in the "Sales" department. Use COUNT(*).*/
SELECT Count(*) AS count_at_sales
FROM   employees AS e
       INNER JOIN departments AS d
               ON( e.department_id = d.department_id )
WHERE  department_name = 'Sales';

/*3.	Write a SQL query to find the number of all locations where the company has an office.*/
SELECT Count(d.location_id) AS departments_in_location,
       l.city
FROM   departments AS d
       INNER JOIN locations AS l
               ON( d.location_id = l.location_id )
GROUP  BY l.location_id;

/*4.	Write a SQL query to find the number of all departments that has manager.*/
SELECT Concat(e.first_name, ' ', e.last_name) AS name,
       Count(d.manager_id)                    AS owned_departments
FROM   departments AS d
       INNER JOIN employees AS e
               ON( d.manager_id = e.employee_id )
GROUP  BY( d.manager_id );

/*check the solution*/
SELECT Count(DISTINCT manager_id) AS total_dif_owners,
       Count(manager_id)          AS total_owners
FROM   departments;

/*5.	Write a SQL query to find the number of all departments that has no manager.*/
SELECT Count(*) AS has_no_managers
FROM   departments
WHERE  manager_id IS NULL;

/*6.	Write a SQL query to find all departments' names and the average salary for each of them.*/
SELECT d.department_name,
       Round(Avg(e.salary)) AS avg_salary
FROM   employees AS e
       INNER JOIN departments AS d
               ON( e.department_id = d.department_id )
GROUP  BY ( e.department_id );

/*7.	Write a SQL query to find the count of all employees in each department. 
Display the name, location and number of employees for each department.*/
SELECT d.department_name,
       Count(e.employee_id) AS number_employees
FROM   employees AS e
       INNER JOIN departments AS d
               ON( e.department_id = d.department_id )
GROUP  BY( d.department_id );

/*8.	Write a SQL query to find for each department and for each manager the 
count of all corresponding employees.*/
SELECT Concat(mn.first_name, ' ', mn.last_name) AS manager,
       d.department_name,
       Count(e.manager_id)                      AS count_employees
FROM   employees AS e
       INNER JOIN departments AS d
               ON( e.department_id = d.department_id )
       INNER JOIN employees AS mn
               ON ( e.manager_id = mn.employee_id )
GROUP  BY( e.manager_id );

/*9.	Write a SQL query to find all managers that have exactly 5 employees. 
Display their names and the name and location of their department.*/
SELECT Concat(mn.first_name, ' ', mn.last_name) AS manager,
       Count(e.manager_id)                      AS count_employees
FROM   employees AS e
       INNER JOIN employees AS mn
               ON ( e.manager_id = mn.employee_id )
GROUP  BY( e.manager_id )
HAVING Count(e.manager_id) = 5;

/*10.	Write a SQL query to find the total number of employees for each region.*/
SELECT r.region_name        AS region,
       Count(e.employee_id) AS count_employees
FROM   employees AS e
       INNER JOIN departments AS d
               ON( e.department_id = d.department_id )
       INNER JOIN locations AS l
               ON( d.location_id = l.location_id )
       INNER JOIN countries AS c
               ON( l.country_id = c.country_id )
       INNER JOIN regions AS r
               ON( c.region_id = r.region_id )
GROUP  BY( r.region_id );

/*11.	Write a SQL query to find for each department and for each job title the total number of employees.*/
SELECT d.department_name,
       j.job_title,
       Count(e.employee_id) AS count_employees
FROM   employees AS e
       INNER JOIN departments AS d
               ON( e.department_id = d.department_id )
       INNER JOIN jobs AS j
               ON( e.job_id = j.job_id )
GROUP  BY department_name,
          job_title;

/*12.	Write a SQL query to find the names and salaries of the employees 
that take the minimal salary in the company. Use nested SELECT statement.*/
SELECT Concat(first_name, ' ', last_name) AS name,
       salary
FROM   employees
HAVING salary = (SELECT Min(salary)
                 FROM   employees);

/*13.	Write a SQL query to find the names and salaries of the employees 
that get a salary that is up to 10% higher than the minimal salary for the company.*/
SELECT Concat(first_name, ' ', last_name) AS name,
       salary
FROM   employees
HAVING salary <= (SELECT Min(salary) * 1.1
                  FROM   employees);

/*14.	Write a SQL that displays all departments and the highest salary for each department 
along with the name of the employee that takes it. If multiple employees in the same department 
have highest salary, display the first of them.*/
SELECT Concat(first_name, ' ', last_name) AS name,
       department_name,
       salary
FROM   employees AS e
       INNER JOIN departments AS d
               ON ( e.department_id = d.department_id )
GROUP  BY department_name
HAVING salary = Max(salary);

/*15.	Write a SQL query to find the names of all employees whose last name is exactly 5 characters long.*/
SELECT Concat(first_name, ' ', last_name) AS name
FROM   employees
WHERE  Length(last_name) = 5;

/*16.	Write a SQL query to find the names of all employees whose first name 
and last name start with the same letter. */
SELECT Concat(first_name, ' ', last_name) AS name
FROM   employees
WHERE  Substr(first_name, 1, 1) = Substr(last_name, 1, 1);

/*17.	Display all departments names and their manager's name. 
For departments without manager display "(No manager)". */
SELECT d.department_name,
       Coalesce(Concat(e.first_name, ' ', e.last_name), 'no manager') AS manager
FROM   departments AS d
       LEFT OUTER JOIN employees AS e
                    ON( d.manager_id = e.employee_id );

/*18.	Display all employees along with their number of directly managed people. 
For employees not managing anybody display "Just and employee". 
For employees managing only 1 employee display "Junior manager". .*/
SELECT Concat(e.first_name, ' ', e.last_name)                            AS name
       ,
       IF(Count(m.employee_id) = 0, 'just an employee',
       IF(Count(m.employee_id) = 1, 'junior manager', 'senior manager')) AS rang
FROM   employees AS e
       LEFT OUTER JOIN employees AS m
                    ON( e.employee_id = m.manager_id )
GROUP  BY( e.employee_id );

/*19.	Write a SQL query to print the current date and time in the format 
" hour:minutes:seconds day-month-year". Display also the date coming after a week.*/
SELECT Concat(Current_time(), ' ', Dayofmonth(CURRENT_DATE()), '-', Month(
              CURRENT_DATE()), '-', Year(CURRENT_DATE())) AS date,
       Date_add(CURRENT_DATE(), INTERVAL 7 day)           AS time_nextweek;

/*20.	Write a SQL statement to create a table USERS. Users should have username, password, 
full name and last login time. Choose appropriate data types for the fields of the table. 
Define a primary key column with a primary key constraint.  
Define a trigger to automatically fill the full name column value before inserting a record.*/
CREATE TABLE users
  (
     user_id    INT (11) UNSIGNED auto_increment,
     username   VARCHAR(25) NOT NULL,
     password   VARCHAR(25) NOT NULL,
     first_name VARCHAR(40),
     last_name  VARCHAR(40),
     last_login DATETIME,
     PRIMARY KEY (user_id)
  );

/* preview table*/
SELECT *
FROM   users;

/*example create several rows */
INSERT INTO users
VALUES     (1,
            'Vilio',
            '79746asd',
            'Velichko',
            'Angelov',
            Now());

INSERT INTO users
            (username,
             password,
             last_login)
VALUES     ('Pesho',
            'sadasd',
            Now());

INSERT INTO `hr`.`users`
            (`username`,
             `password`,
             `last_login`)
VALUES      ('Misho',
             'alaskdja',
             Now());

UPDATE users
SET    last_login = Now()
WHERE  user_id = 1;

UPDATE users
SET    last_login = Date_add(Now(), INTERVAL -7 day)
WHERE  user_id = 2;
/*SHOW CREATE TABLE users /*view code of created table*/
/*drop table USERS;users_table_view*/
/*21. Write a SQL statement to create a view that displays the users 
from the USERS table that have been in the system today. Test if the view works correctly.*/ 
DROP VIEW users_table_view;CREATE VIEW users_table_vieusers_table_vieww AS 
SELECT * 
FROM   users 
WHERE  last_login BETWEEN CURRENT_DATE() AND    adddate(Curdate(),interval 1 day); 

/*22. Write a SQL statement to create a table GROUPS. 
Groups should have unique name (use unique constraint).*/ALTER TABLE users ADD group_id INT(11) unsigned;ALTER TABLE users change goup_id group_id int(11);ALTER TABLE users ADD CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES groups(group_id);

/*24. Write SQL statements to insert several records in the USERS and GROUPS tables.*/UPDATE users
SET    last_login= Now() 
WHERE  user_id=1;INSERT INTO groups 
            ( 
                        group_name 
            ) 
            VALUES 
            ( 
                        'punk' 
            );INSERT INTO groups 
            ( 
                        group_name 
            ) 
            VALUES 
            ( 
                        'rock' 
            );INSERT INTO groups 
            ( 
                        group_name 
            ) 
            VALUES 
            ( 
                        'metal' 
            );SELECT * 
FROM   users;INSERT INTO users 
            ( 
                        username, 
                        password, 
                        first_name, 
                        last_login 
            ) 
            VALUES 
            ( 
                        'user1', 
                        'pass1', 
                        'name1', 
                        Now() 
            );SELECT     u.username, 
           g.group_name 
FROM       users  AS u 
INNER JOIN groups AS g 
ON        ( 
                      u.group_id=g.group_id);UPDATE users 
SET    group_id = 2 
WHERE  user_id = 3; 

/*25. Write SQL statements to insert in the USERS table the names of all employees 
from the employees table. Combine the first and last names as a full name. 
For user name use the email column from employees. Use blank password.*/
ALTER TABLE users modify COLUMN password varchar(25);
ALTER TABLE users modify COLUMN username varchar(100);
ALTER TABLE users modify COLUMN group_id int(11) unsigned;
TRUNCATE TABLE users;TRUNCATE TABLE groups;

-- ready for problem ;)
INSERT INTO users 
            ( 
                        username, 
                        first_name, 
                        last_name 
            ) 
SELECT e.email, 
       e.first_name, 
       e.last_name 
FROM   employees AS e;SELECT * 
FROM   users; 

/*26. Run the above 10 times to generate enough testing data for the USERS table.*/ 
-- ok 
/*27. Write a SQL statement that changes the password to NULL 
for all USERS that have not been in the system since 10.03.2006. 
Select table data to see the changes. */UPDATE users 
SET    password = 'bbb';UPDATE users 
SET    last_login = Str_to_date('10.03.2005', '%m.%d.%Y');SELECT password, 
       last_login 
FROM   users;UPDATE users 
SET    password = NULL 
WHERE  last_login < Str_to_date('10.03.2006', '%m.%d.%Y'); 

/*28. Write a SQL statement that deletes all users without passwords (NULL or empty password).
Select table data to see the changes. */DELETE 
FROM   users 
WHERE  password IS NULL 
OR     password = ''; 

/*29. Write a SQL query to list all users whose username starts with 's' and the number of 
groups for each of them. */SELECT username, 
       group_id 
FROM   users 
WHERE  username LIKE 's%'; 

/*30. Define table WORKHOURS to store work reports for each employee (date, task, hours, comments).*/ALTER TABLE workhours modify COLUMN employee_id int(11) unsigned;ALTER TABLE workhours ADD CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employees(employee_id);

/*32. Write several SQL statements to fill some data in the WORKHOURS table.*/INSERT INTO workhours
            ( 
                        employee_id, 
                        hours 
            ) 
SELECT e.employee_id, 
       8 
FROM   employees AS e;TRUNCATE TABLE workhours;INSERT INTO workhours 
            ( 
                        employee_id, 
                        hours 
            ) 
SELECT e.employee_id, 
       8 
FROM   employees AS e 
WHERE  employee_id BETWEEN 100 AND    120;INSERT INTO workhours 
            ( 
                        employee_id, 
                        hours 
            ) 
SELECT e.employee_id, 
       9 
FROM   employees AS e 
WHERE  employee_id BETWEEN 120 AND    150;INSERT INTO workhours 
            ( 
                        employee_id, 
                        hours 
            ) 
SELECT e.employee_id, 
       6 
FROM   employees AS e 
WHERE  employee_id >= 150;SELECT * 
FROM   workhours; 

/*33. Write a SQL query to find all the average work hours per week for each country.*/SELECT     c.country_name,
           Avg(w.hours) 
FROM       employees   AS e 
INNER JOIN departments AS d 
ON        ( 
                      e.department_id = d.department_id) 
INNER JOIN locations AS l 
ON        ( 
                      d.location_id = l.location_id) 
INNER JOIN countries AS c 
ON        ( 
                      l.country_id = c.country_id) 
INNER JOIN workhours AS w 
ON        ( 
                      e.employee_id = w.employee_id) 
GROUP BY   c.country_name; 

/*34. Write a SQL query to find all the departments 
where some employee worked overtime (over 8 hours/day) during the last week.*/SELECT     d.department_name,
           Max(w.hours) 
FROM       employees   AS e 
INNER JOIN departments AS d 
ON        ( 
                      d.department_id= e.department_id) 
INNER JOIN workhours AS w 
ON        ( 
                      e.employee_id= w.employee_id) 
GROUP BY   (department_name) 
HAVING     Max(w.hours)>8; 

/*35. Write a SQL query to find all employees that have worked 3 or more days overtime in the last week.
Display their name, location department and country.*/