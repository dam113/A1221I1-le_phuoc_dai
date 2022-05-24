use quan_ly_ban_hang;

insert into customer
value (1,'Minh Quan',10), (2,'Ngoc Oanh',20), (3,'Hong Ha',50);

insert into order_
value (3,1,'2006-03-15',null), (3,2,'2006-03-23', null), (4,1,'2006-03-16', null);

insert into product
value (1, 'may giat', 3), (2, 'tu lanh', 5), (3, 'dieu hoa', 7), (4, 'quat', 1), (5, 'bep dien', 2);

insert into order_detail
value (1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o.order_id, o.order_date, p.product_price
from order_ o join order_detail od on o.order_id = od.order_id
join product p on od.product_id = p.product_id;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.customer_name, p.product_name
from order_ o 
join customer c on o.customer_id = c.customer_id
join order_detail od on o.order_id = od.order_id
join product p on od.product_id = p.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT * from customer WHERE customer_id not in (SELECT customer_id FROM order_);

select *
from customer c left join order_ o on o.customer_id = c.customer_id
where order_id is null;

select * from customer c where not exists (select * from order_ o where o.customer_id = c.customer_id);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT o.order_id, o.order_date , sum(p.product_price* d.odqty) as total 
from order_ o
INNER JOIN order_detail d on d.order_id= o.order_id
INNER JOIN product p on p.product_id= d.product_id
GROUP BY o.order_id