-- Them moi database
create database my_database;

-- xoa database
drop database my_database;

-- them moi database student management
create database student_management;

-- tao table student
create table student(
	id int not null,
    name varchar(45) null,
    age int null,
    country varchar(45) null,
    primary key(id)
);

select * from student


