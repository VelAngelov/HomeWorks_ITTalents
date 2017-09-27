/* 1.Write a SQL query to display all information about all departments*/
select * from hr.departments;
/* 2.. Write a SQL query to find all department names.*/
select department_name from hr.departments;
/*3.Write a SQL query to find the salary of each employee by month, by day
and hour. Consider that one month has 20 workdays and each workday
has 8 work hours.*/
select first_name, salary, ROUND(salary/30,2) as salary_by_day, ROUND(salary/30/8,2) as salary_by_hour  from hr.employees;
/*4.Write a SQL query to find the email addresses of each employee.
Consider that the mail domain is mail.somecompany.com. Emails should
look like "bernst@mail.somecompany.com". The produced column
should be named "Full Email Address".*/
select concat(lower(email),'@mail.somecompany.com') as email_adress from hr.employees;
/*5.Write a SQL query to find all different salaries that are paid to
the employees. Use DISTINCT.
*/
select distinct salary as salaries from hr.employees order by salaries desc;
/*6.Write a SQL query to find all departments and all region
names, country names and city names as a single list. Use UNION.*/
select department_name from hr.departments
union
select region_name from hr.regions
union
select country_name from hr.countries
union
select city from hr.locations;
/*7.Write a SQL query to find all information about the
employees whose position is "AC_MGR" (Accounting Manager)*/
select first_name, job_id from hr.employees where job_id = 'AC_MGR';
/*8.Write a SQL query to find the names of all employees whose
first name starts with "Sa". Use LIKE.*/
select first_name from hr.employees where first_name like '%sa%';
/*9.Write a SQL query to find the names of all employees whose last name
contains the character sequence "ei". Use LIKE.*/
select last_name from hr.employees where last_name like '%ei%';
/*10.Write a SQL query to find the names of all employees whose
salary is in the range [3000...5000]. Use BETWEEN.*/
select first_name,salary from hr.employees where salary between 3000 and 5000;
/*11.Write a SQL query to find the names of all employees whose
salary is in the range [2000...15000] but is not in range [5000 … 10000].
Use MINUS.*/
/*11.1*/
select first_name,salary from hr.employees where salary between 2000 and 15000
and not (salary > 5000 and salary < 10000);
/*11.2*/
select first_name,salary from hr.employees where salary between 2000 and 5000
union
select first_name,salary from hr.employees where salary between 10000 and 15000;
/*11.3*/
select first_name,salary from hr.employees where salary 
in (select salary from hr.employees where salary between 2000 and 15000) and
salary not in( select salary from hr.employees where salary between 5000 and 10000);
/*12.Write a SQL query to find the names of all employees whose
salary is 2500, 4000 or 5000. Use IN.*/
select first_name,salary from hr.employees where salary in (2500,4000,5000);
/*13.Write a SQL query to find all locations that have no state or
post code defined. Use IS NULL.*/
select city,state_province from hr.locations where state_province is null;
/*14.Write a SQL query to find all employees that are paid more
than 10 000. Order them in decreasing order by salary. Use ORDER BY.*/
select first_name, salary from hr.employees where salary>=10000 order by salary desc;
/*15.Write a SQL query to find the first 10 employees joined the
company (most senior people).*/
select first_name, hire_date from hr.employees order by hire_date asc limit 10;
/*16.Write a SQL query to find all departments and the town of
their location. Use NATURAL JOIN.*/

/*17.Write a SQL query to find all departments and the town of
their location. Use join with USING clause.*/
/*18.Write a SQL query to find all departments and the town of
their location. Use inner join with ON clause.*/
/*19.Modify the last SQL query to include also the name of the
manager for each department.*/
/*20.Write a SQL query to find all the locations and the
departments for each location along with the locations that do not have
department. User right outer join.*/
/*21.Rewrite the last SQL query to use left outer join.*/
/*22.Rewrite the last query to use WHERE instead of JOIN.*/
/*23.Write a SQL query to find the manager name of each
department.*/
/*24.Modify the last SQL query to find also the location of each
department manager.*/
/*25.Write a SQL query to find the names of all employees from
the departments "Sales" and "Finance" whose hire year is between 1995
and 2000.*/
/*26.Find all employees that have worked in the past in the
department “Sales”. Use complex join condition.*/
/*27.Write a SQL query to display all employees (first and last
name) along with their corresponding manager (first and last name). Use
self-join.*/
/*28.Combine all first names with all last names of the employees
with a CROSS JOIN.
*/
/*29.Write a SQL query to display all employees, along with their
job title, department, location, country and region. Use multiple joins.*/
/*30.Modify the last SQL query to display also the manager name
for each employee or “No manager” in case there is no manager. */
/*31.Write a SQL query to find all employees that have worked in
the past at job position “AC_ACCOUNT” and at some time later at job
position “AC_MGR”. Display the employees’ names and current job title.
Hint: first self-join JOB_HISTORY table, then apply filtering and finally
join the result with EMPLOYEES and JOBS tables.*/