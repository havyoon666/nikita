select * from departments;
select name from departments;
select name, description from departments where name = 'Engeneiging' order by description asc ;
select name, description from departments where name = 'Engeneiging' order by description desc ;

create table employee
(
    id     integer,
    name   varchar,
    salary DECIMAL
);

select * from employee;
insert into employee values (1, 'Dmtytro', 4444.3);
insert into employee values (2, 'Mykyta', 14444.3);
update employee set salary = 7787 where id = 1;
delete from employee where id = 1;



