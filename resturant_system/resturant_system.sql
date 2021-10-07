create database resturant_system
create table users(Users_id int primary key ,Users_name nvarchar(30),roles_id int,Users_password nvarchar(30))
create table customer(Customer_id int primary key  ,Customer_adress nvarchar(50),Customer_phone nvarchar(20),Customer_genter nvarchar(20),
users_id int ,foreign key (users_id) references users(Users_id))
create table customer_type(customer_type int primary key,Customer1_id int,name_type nvarchar(30),foreign key (Customer1_id) references  customer(Customer_id))
create table meals(meals_id int primary key ,meal_title nvarchar(30),descriptions nvarchar(50),prices float ,usersm_id int,
foreign key (usersm_id ) references users(Users_id))
create table orders(
O_id int primary key ,
order_time nvarchar(50),
total_bill float,
co_id int foreign key references customer(Customer_id),
uo_id int foreign key references users(Users_id),
customer_id int ,users_id int
)

create table orders_descriptions(OD_id int primary key ,quantity int,ood_id int ,omd_id int ,
foreign key (ood_id) references orders(O_id),foreign key (omd_id) references meals(meals_id))

create table offer (offer_id int primary key ,dates date,offer nvarchar(20),fu_id int,foreign key (fu_id) references users(Users_id))

alter table meals add constraint fk_mealof foreign key (offer_id) references offer(offer_id)

alter table meals add users_meal int

alter table offer add dates  nvarchar(30)
alter table offer drop column dates 
select * from meals

ALTER TABLE meals
DROP CONSTRAINT fk_mealus
select * from users