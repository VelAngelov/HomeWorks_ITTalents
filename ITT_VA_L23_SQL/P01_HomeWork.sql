/* 1.Write a SQL query to display all information about all departments*/ 
SELECT * 
FROM   hr.departments; 

/* 2.. Write a SQL query to find all department names.*/ 
SELECT department_name 
FROM   hr.departments; 

/*3.Write a SQL query to find the salary of each employee by month, by day 
and hour. Consider that one month has 20 workdays and each workday 
has 8 work hours.*/ 
SELECT first_name, 
       salary, 
       Round(salary / 30, 2)     AS salary_by_day, 
       Round(salary / 30 / 8, 2) AS salary_by_hour 
FROM   hr.employees; 

/*4.Write a SQL query to find the email addresses of each employee. 
Consider that the mail domain is mail.somecompany.com. Emails should 
look like "bernst@mail.somecompany.com". The produced column 
should be named "Full Email Address".*/ 
SELECT Concat(Lower(email), '@mail.somecompany.com') AS email_adress 
FROM   hr.employees; 

/*5.Write a SQL query to find all different salaries that are paid to 
the employees. Use DISTINCT. 
*/ 
SELECT DISTINCT salary AS salaries 
FROM   hr.employees 
ORDER  BY salaries DESC; 

/*6.Write a SQL query to find all departments and all region 
names, country names and city names as a single list. Use UNION.*/ 
SELECT department_name 
FROM   hr.departments 
UNION 
SELECT region_name 
FROM   hr.regions 
UNION 
SELECT country_name 
FROM   hr.countries 
UNION 
SELECT city 
FROM   hr.locations; 

/*7.Write a SQL query to find all information about the 
employees whose position is "AC_MGR" (Accounting Manager)*/ 
SELECT first_name, 
       job_id 
FROM   hr.employees 
WHERE  job_id = 'AC_MGR'; 

/*8.Write a SQL query to find the names of all employees whose 
first name starts with "Sa". Use LIKE.*/ 
SELECT first_name 
FROM   hr.employees 
WHERE  first_name LIKE '%sa%'; 

/*9.Write a SQL query to find the names of all employees whose last name 
contains the character sequence "ei". Use LIKE.*/ 
SELECT last_name 
FROM   hr.employees 
WHERE  last_name LIKE '%ei%'; 

/*10.Write a SQL query to find the names of all employees whose 
salary is in the range [3000...5000]. Use BETWEEN.*/ 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary BETWEEN 3000 AND 5000; 

/*11.Write a SQL query to find the names of all employees whose 
salary is in the range [2000...15000] but is not in range [5000 … 10000]. 
Use MINUS.*/ 
/*11.1*/ 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary BETWEEN 2000 AND 15000 
       AND NOT ( salary > 5000 
                 AND salary < 10000 ); 

/*11.2*/ 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary BETWEEN 2000 AND 5000 
UNION 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary BETWEEN 10000 AND 15000; 

/*11.3*/ 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary IN (SELECT salary 
                  FROM   hr.employees 
                  WHERE  salary BETWEEN 2000 AND 15000) 
       AND salary NOT IN(SELECT salary 
                         FROM   hr.employees 
                         WHERE  salary BETWEEN 5000 AND 10000); 

/*12.Write a SQL query to find the names of all employees whose 
salary is 2500, 4000 or 5000. Use IN.*/ 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary IN ( 2500, 4000, 5000 ); 

/*13.Write a SQL query to find all locations that have no state or 
post code defined. Use IS NULL.*/ 
SELECT city, 
       state_province 
FROM   hr.locations 
WHERE  state_province IS NULL; 

/*14.Write a SQL query to find all employees that are paid more 
than 10 000. Order them in decreasing order by salary. Use ORDER BY.*/ 
SELECT first_name, 
       salary 
FROM   hr.employees 
WHERE  salary >= 10000 
ORDER  BY salary DESC; 

/*15.Write a SQL query to find the first 10 employees joined the 
company (most senior people).*/ 
SELECT first_name, 
       hire_date 
FROM   hr.employees 
ORDER  BY hire_date ASC 
LIMIT  10; 

/*16.Write a SQL query to find all departments and the town of 
their location. Use NATURAL JOIN.*/ 
SELECT department_name, 
       city 
FROM   departments 
       NATURAL JOIN locations; 

/*17.Write a SQL query to find all departments and the town of 
their location. Use join with USING clause.*/ 
SELECT d.department_name, 
       l.city 
FROM   departments d 
       JOIN locations l USING (location_id); 

/*18.Write a SQL query to find all departments and the town of 
their location. Use inner join with ON clause.*/ 
SELECT d.department_name, 
       l.city 
FROM   departments d 
       JOIN locations l 
         ON ( d.location_id = l.location_id ); 

/*19.Modify the last SQL query to include also the name of the 
manager for each department.*/ 
SELECT Concat(e.first_name, ' ', e.last_name) AS manager, 
       d.department_name, 
       l.city 
FROM   departments d 
       JOIN locations l 
         ON ( d.location_id = l.location_id ) 
       JOIN employees e 
         ON( d.manager_id = e.manager_id ); 

/*20.Write a SQL query to find all the locations and the 
departments for each location along with the locations that do not have 
department. User right outer join.*/ 
SELECT d.department_name, 
       l.city 
FROM   departments d 
       RIGHT OUTER JOIN locations l 
                     ON d.location_id = l.location_id; 

/*21.Rewrite the last SQL query to use left outer join.*/ 
SELECT l.city, 
       d.department_name 
FROM   locations l 
       LEFT OUTER JOIN departments d 
                    ON d.location_id = l.location_id; 

/*22.Rewrite the last query to use WHERE instead of JOIN.*/ 
SELECT l.city, 
       d.department_name 
FROM   locations l, 
       departments d 
WHERE  l.location_id = d.location_id 
UNION 
SELECT l.city, 
       NULL 
FROM   locations l 
WHERE  l.location_id NOT IN (SELECT d.location_id 
                             FROM   departments d); 

/*and l.location_id not (select l.city from locations l, departments d where l.location_id = d.location_id);*/
SELECT city 
FROM   locations; 

/*23.Write a SQL query to find the manager name of each 
department.*/ 
SELECT d.department_name, 
       Concat(e.first_name, ' ', e.last_name) AS manager 
FROM   departments d 
       JOIN employees e 
         ON( d.manager_id = e.employee_id ); 

/*24.Modify the last SQL query to find also the location of each 
department manager.*/ 
SELECT d.department_name, 
       Concat(e.first_name, ' ', e.last_name) AS manager, 
       l.city 
FROM   departments d 
       JOIN employees e 
         ON( d.manager_id = e.employee_id ) 
       JOIN locations l 
         ON( d.location_id = l.location_id ); 

/*25.Write a SQL query to find the names of all employees from 
the departments "Sales" and "Finance" whose hire year is between 1995 
and 2000.*/ 
SELECT Concat(e.first_name, ' ', e.last_name) AS employee_name, 
       d.department_name, 
       e.hire_date 
FROM   employees AS e 
       INNER JOIN departments AS d 
               ON ( e.department_id = d.department_id ) 
WHERE  d.department_name IN ( 'Sales', 'Finance' ) 
       AND e.hire_date BETWEEN Cast('1995-1-1' AS date) AND 
                               Cast('2000-1-1' AS date); 

/*26.Find all employees that have worked in the past in the 
department “Sales”. Use complex join condition.*/ 
SELECT Concat(e.first_name, ' ', e.last_name) AS employee_name, 
       d.department_name, 
       j.start_date, 
       j.end_date 
FROM   employees AS e 
       INNER JOIN job_history AS j 
               ON( e.employee_id = j.employee_id ) 
       INNER JOIN departments d 
               ON( e.department_id = d.department_id ) 
WHERE  d.department_name = 'sales'; 

/*27.Write a SQL query to display all employees (first and last 
name) along with their corresponding manager (first and last name). Use 
self-join.*/ 
SELECT Concat(e.first_name, ' ', e.last_name) AS empl_name, 
       Concat(m.first_name, ' ', m.last_name) AS manager 
FROM   employees AS e 
       INNER JOIN employees AS m 
               ON ( e.manager_id = m.employee_id ); 

/*28.Combine all first names with all last names of the employees 
with a CROSS JOIN.*/ 
SELECT Concat(e.first_name, "", e2.last_name) AS full_name 
FROM   employees e 
       CROSS JOIN employees e2; 

/*29.Write a SQL query to display all employees, along with their 
job title, department, location, country and region. Use multiple joins.*/ 
SELECT Concat(e.first_name, ' ', e.last_name) AS name, 
       j.job_title, 
       d.department_name, 
       l.city, 
       l.state_province, 
       c.country_name, 
       r.region_name 
FROM   employees AS e 
       JOIN departments AS d 
         ON ( e.department_id = d.department_id ) 
       JOIN jobs AS j 
         ON( e.job_id = j.job_id ) 
       JOIN locations l 
         ON( d.location_id = l.location_id ) 
       JOIN countries c 
         ON( l.country_id = c.country_id ) 
       JOIN regions r 
         ON( c.region_id = r.region_id ); 

/*30.Modify the last SQL query to display also the manager name 
for each employee or “No manager” in case there is no manager. */ 
SELECT Concat(e.first_name, ' ', e.last_name)                  AS name, 
       Coalesce(Concat(m.first_name, ' ', m.last_name), 'N/A') AS manager, 
       j.job_title, 
       d.department_name, 
       l.city, 
       l.state_province, 
       c.country_name, 
       r.region_name 
FROM   employees AS e 
       LEFT JOIN employees AS m 
              ON( e.manager_id = m.employee_id ) 
       JOIN departments AS d 
         ON ( e.department_id = d.department_id ) 
       JOIN jobs AS j 
         ON( e.job_id = j.job_id ) 
       JOIN locations l 
         ON( d.location_id = l.location_id ) 
       JOIN countries c 
         ON( l.country_id = c.country_id ) 
       JOIN regions r 
         ON( c.region_id = r.region_id ); 

/*31.Write a SQL query to find all employees that have worked in 
the past at job position “AC_ACCOUNT” and at some time later at job 
position “AC_MGR”. Display the employees’ names and current job title. 
Hint: first self-join JOB_HISTORY table, then apply filtering and finally 
join the result with EMPLOYEES and JOBS tables.*/ 
SELECT Concat(e.first_name, ' ', e.last_name) AS name, 
       jh.job_id                              AS position_in_past1, 
       jh2.job_id                             AS position_in_past2, 
       j.job_id                               AS position_now, 
       j.job_title                            AS job_title_now 
FROM   employees AS e 
       JOIN job_history AS jh 
         ON( e.employee_id = jh.employee_id 
             AND jh.job_id = 'AC_ACCOUNT' ) 
       JOIN job_history AS jh2 
         ON ( e.employee_id = jh2.employee_id 
              AND jh2.job_id = 'AC_MGR' ) 
       JOIN jobs AS j 
         ON( e.job_id = j.job_id ); 