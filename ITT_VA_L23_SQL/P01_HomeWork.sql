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
select  department_name, city from departments natural join locations;
/*17.Write a SQL query to find all departments and the town of
their location. Use join with USING clause.*/
select d.department_name, l.city from departments d join locations l using (location_id);
/*18.Write a SQL query to find all departments and the town of
their location. Use inner join with ON clause.*/
select d.department_name, l.city from departments d join locations l on (d.location_id = l.location_id);
/*19.Modify the last SQL query to include also the name of the
manager for each department.*/
select concat(e.first_name,' ',e.last_name) as manager,d.department_name, l.city 
from departments d join locations l on (d.location_id = l.location_id) 
join employees e on(d.manager_id=e.manager_id);
/*20.Write a SQL query to find all the locations and the
departments for each location along with the locations that do not have
department. User right outer join.*/
select d.department_name,l.city from departments d 
right outer join locations l on d.location_id = l.location_id;
/*21.Rewrite the last SQL query to use left outer join.*/
select l.city, d.department_name from locations l 
left outer join departments d on d.location_id = l.location_id;
/*22.Rewrite the last query to use WHERE instead of JOIN.*/
/*select l.city, d.department_name from locations l full outer join departments d on (l.location_id = d.location_id);*/ 
select l.city, d.department_name from locations l, departments d where l.location_id = d.location_id
union
select l.city,null from locations l where l.location_id not in 
(select d.location_id from departments d);
/*and l.location_id not (select l.city from locations l, departments d where l.location_id = d.location_id);*/
select city from locations;
/*23.Write a SQL query to find the manager name of each
department.*/
select d.department_name, concat(e.first_name,' ',e.last_name) as manager from departments d join employees e on(d.manager_id=e.employee_id);
/*24.Modify the last SQL query to find also the location of each
department manager.*/
select d.department_name, concat(e.first_name,' ',e.last_name) as manager,l.city from departments d 
join employees e on(d.manager_id=e.employee_id) 
join locations l on(d.location_id=l.location_id);
/*25.Write a SQL query to find the names of all employees from
the departments "Sales" and "Finance" whose hire year is between 1995
and 2000.*/
select concat(e.first_name,' ',e.last_name) as employee_name,
d.department_name, e.hire_date
from employees as e 
inner join departments as d 
on (e.department_id = d.department_id)
where d.department_name in ('Sales','Finance') 
and e.hire_date between cast('1995-1-1' as date) and cast('2000-1-1' as date);

/*26.Find all employees that have worked in the past in the
department “Sales”. Use complex join condition.*/
select concat(e.first_name,' ',e.last_name) as employee_name,d.department_name,j.start_date,j.end_date
from employees as e
inner join job_history as j
on(e.employee_id = j.employee_id)
inner join departments d
on( e.department_id= d.department_id )
where d.department_name ='sales';

/*27.Write a SQL query to display all employees (first and last
name) along with their corresponding manager (first and last name). Use
self-join.*/
select concat(e.first_name,' ',e.last_name) as empl_name, concat(m.first_name,' ',m.last_name) as manager
from employees as e
inner join employees as m
on (e.manager_id = m.employee_id);
/*28.Combine all first names with all last names of the employees
with a CROSS JOIN.*/
select concat(e.first_name," ",e2.last_name) as full_name from employees e cross join employees e2;
/*29.Write a SQL query to display all employees, along with their
job title, department, location, country and region. Use multiple joins.*/

select concat(e.first_name,' ',e.last_name) as name, j.job_title, d.department_name, l.city, l.state_province,
c.country_name ,r.region_name
from employees as e
join departments as d
on (e.department_id = d.department_id)
join jobs as j
on(e.job_id = j.job_id)
join locations l
on(d.location_id = l.location_id)
join countries c
on(l.country_id = c.country_id)
join regions r
on(c.region_id = r.region_id);

/*30.Modify the last SQL query to display also the manager name
for each employee or “No manager” in case there is no manager. */
select concat(e.first_name,' ',e.last_name) as name,
coalesce(concat(m.first_name,' ',m.last_name),'N/A') as manager,
 j.job_title, d.department_name, l.city, l.state_province,
c.country_name ,r.region_name
from employees as e
left join employees as m
on(e.manager_id = m.employee_id)
join departments as d
on (e.department_id = d.department_id)
join jobs as j
on(e.job_id = j.job_id)
join locations l
on(d.location_id = l.location_id)
join countries c
on(l.country_id = c.country_id)
join regions r
on(c.region_id = r.region_id);
/*31.Write a SQL query to find all employees that have worked in
the past at job position “AC_ACCOUNT” and at some time later at job
position “AC_MGR”. Display the employees’ names and current job title.
Hint: first self-join JOB_HISTORY table, then apply filtering and finally
join the result with EMPLOYEES and JOBS tables.*/
select concat(e.first_name,' ',e.last_name) as name,jh.job_id as position_in_past1
,jh2.job_id as position_in_past2,j.job_id as position_now,j.job_title as job_title_now
from employees as e
join job_history as jh
on(e.employee_id = jh.employee_id and jh.job_id = 'AC_ACCOUNT')
join job_history as jh2
on (e.employee_id = jh2.employee_id and jh2.job_id = 'AC_MGR')
join jobs as j
on(e.job_id = j.job_id);