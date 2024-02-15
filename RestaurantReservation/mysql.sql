create database RestaurnantReservation;
use RestaurnantReservation;
create table customer_tbl(
cust_id int auto_increment primary key,
cust_name varchar(200),
cust_address varchar(200),
cust_phNo varchar(200),
cust_email varchar(200),
cust_password varchar(200)
);
select * from customer_tbl;
  
truncate table customer_tbl;


select * from customer_tbl where cust_email = "raju@gmail.com" and cust_password = "1234";





create table tabledetails_tbl
(
table_id int auto_increment primary key,
table_available int,
table_capacity int
);
select * from tabledetails_tbl; 

create table reservation_tbl(
res_id int auto_increment primary key,
res_date date,
res_time time,
res_partySize int,
res_cust_name varchar(200),
res_phoneNumber varchar(200),
table_id int,
FOREIGN KEY (table_id) REFERENCES tabledetails_tbl(table_id)
);

ALTER TABLE reservation_tbl Modify column res_date varchar(100);  

ALTER TABLE reservation_tbl Modify column res_time varchar(100);  

select * from reservation_tbl; 	

CREATE TABLE restaurant_tbl (
    rest_Id INT auto_increment PRIMARY KEY,
    rest_name VARCHAR(255),
    rest_address VARCHAR(255),
    rest_phNo VARCHAR(15),
    rest_email_id varchar(200),
    rest_password varchar(50),
    rest_capacity INT
);
ALTER TABLE restaurant_tbl
ADD COLUMN number_of_tables INT;
select * from restaurant_tbl;