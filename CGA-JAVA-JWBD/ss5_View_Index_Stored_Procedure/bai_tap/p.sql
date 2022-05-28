create database demo;

use demo;

create table products(
	id int primary key,
    product_code int,
    product_name varchar(45),
    product_price double,
    product_amount int,
    product_description varchar(45),
    product_status varchar(45)
);

ALTER TABLE products MODIFY COLUMN id int AUTO_INCREMENT;

insert into products() value(1, 1, 'banh mi', 12000, 50, 'gion ngon', 'dang ban'),
	(2,2,'nuoc ngot', 10000,30,'co ga','dang ban'),
    (3,3,'cha ca',15000,20,'ngon','tam dung ban');
    
select * from products;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
alter table products add unique index idx_product_code(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products add index idx_product_name_price(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products
where product_code='2';

explain select * from products
where product_name='cha ca' and product_price = 3;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view productView 
as
	select product_code, product_name, product_price, product_status
	from products;

-- Tiến hành sửa đổi view
rename table productView to product_view;

-- Tiến hành xoá view
drop view product_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure allproduct()
begin
select * from products;
end
// delimiter ;
call allproduct();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(pcode int, pname varchar(45), pprice double, pamount int, pdescription varchar(45), pstatus varchar(45))
begin
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) values
(pcode,pname,pprice,pamount,pdescription,pstatus);
end
// delimiter ;
call add_product(4,'tra da',5000,10,'mat lanh','tam dung ban');

select * from products;

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product_by_id(pid int, pcode int, pname varchar(45), pprice double, pamount int, pdescription varchar(45), pstatus varchar(45))
begin
update products
set product_name=pname, product_code=pcode, product_price=pprice, product_amount=pamount, product_description=pdescription, product_status=pstatus
where id=pid;
end
// delimiter ;
call update_product_by_id(1, 56, 'banh canh', 15000, 20, 'ngon', 'tam dung ban');

select * from products;

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product_by_id(pid int)
begin
delete from products
where id=pid;
end
// delimiter ;
call delete_product_by_id(2);

select * from products;