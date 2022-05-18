-- tao bang class
create table class(
	id int not null,
    name varchar(50) null,
    primary key(id)
);

-- them du lieu cho bang class
insert into class
value (1, 'A1'), (2, 'A2');

-- tao bang teacher
create table teacher(
	id int not null,
    name varchar(50) null,
    age int null,
    country varchar(255),
    primary key(id)
);

-- them du lieu cho bang teacher
insert into teacher
value (1, 'A1', 28, 'danang'), (2, 'A2', 32, 'hatinh');
