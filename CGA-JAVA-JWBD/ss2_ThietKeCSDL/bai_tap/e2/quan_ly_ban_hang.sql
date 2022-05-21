create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customer(
	customer_id int primary key,
    customer_name varchar(50),
    customer_age int
);

create table order_(
	order_id int primary key,
    customer_id int,
    order_date date,
    order_total_price float,
    foreign key (customer_id) references customer(customer_id)
);

create table product(
	product_id int primary key,
    product_name varchar(255),
    product_price float
);

create table order_detail(
	order_id int,
    product_id int,
    odqty int,
    primary key (order_id, product_id),
    foreign key (order_id) references order_(order_id),
    foreign key (product_id) references product(product_id)
);