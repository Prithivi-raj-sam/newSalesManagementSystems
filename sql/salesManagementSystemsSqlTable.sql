create table accounts(
account_id number(20) primary key,
company_name varchar(35) ,
contact_person varchar(30) not null,
contact_person_role varchar(30) not null,
email varchar(50) unique not null,
contact_person_phone number(15) not null,
address varchar(70)not null,
account_type varchar(20) not null,
marketer_id number(20) constraint fk_marketer_id REFERENCES Employee(emp_id) not null,
lead_through_channel varchar(30) not null,
customer_join_date date not null,
territory_id number(15) constraint fk_territory_id REFERENCES territories(territory_id) not null
);
select * from accounts;
insert into accounts values(3,'chainsys','sam','manager','sam3535@sam.com',6565865763,'samayapuram,trichy','permenent',1,'face book','03/08/2022',1);
delete from accounts where account_id=3;
create table leads(
lead_id number(20) primary key,
account_id number(20) constraint fk_account_id REFERENCES accounts(account_id) not null,
status varchar(20) not null,
saller_id number(20) constraint fk_sales_id REFERENCES Employee(emp_id) not null,
lead_date date not null,
stages varchar(20) not null,
propability number(15) not null
);

select * from leads;
insert into leads values(3,3,'good',4,'02/08/2022','intermidiate',98);
delete from leads where lead_id>0;

create table sales(
sale_id number(20) primary key,
seller_id number(20) constraint fk_seller_id REFERENCES Employee(emp_id) not null,
lead_id number(20)  constraint fk_lead_id REFERENCES leads(lead_id) not null,
sales_date date not null,
amount number(20) not null
);


select * from sales;
commit;
delete from sales where sale_id>0;
select * from sales where(sales_date between '01/08/2000' and '7/08/2022');

insert into sales values(4,2,1,'04/08/2022',4324);
create table Employee(
emp_id number(20) primary key,
emp_name varchar(20) not null,
emp_phone number(15) not null,
emp_email varchar(50) unique not null,
emp_address varchar(80) not null,
Territory_id number(20) constraint fk_terrtory_id REFERENCES territories(territory_id) not null,
emp_password varchar(30) not null,
emp_password_last_change_date date not null,
emp_role varchar(30) not null,
emp_profile blob
);
select * from employee;
select distinct from employee;
commit;
insert into employee values(4,'tamil',8773595638,'sam3535@gmail.com','yagappanagar,madurai',1,'raj@sam','04/08/2000','salesman',null);

delete from employee where emp_id>0;
create table territories(
territory_id  number(20) primary key,
territory_name varchar(30) not null,
no_of_customers number(20) not null
);
select * from territories;
insert into territories values(2,'madurai',2);
delete from territories where territory_id>0;

commit;

create table targets(
target_id number(20) primary key,
target_date date not null,
planned_target number(20) not null,
closed_target number(20),
employee_id number(20) constraint fk_emp_id REFERENCES Employee(emp_id) not null,
manager_comment varchar(70),
target_type varchar(20) not null,
target_set_Date Date not null
);
delete from targets where target_id=1;
commit;
drop table targets;
desc targets;
select * from targets;
select * from employee;
insert into targets values(4,'03/08/2022',15,13,4,'all the best','lead' ,'12/06/2022');

create sequence account_id
start with 10000 increment by 1;

create sequence lead_id_seq
start with 100000 increment by 1;

create sequence territory_id_seq
start with 200000 increment by 1;

create sequence sales_id_seq
start with 300000 increment by 1;

create sequence employee_id_seq
start with 400000 increment by 1;

drop sequence employee_id_seq;

create sequence target_id_seq
start with 500000 increment by 1;