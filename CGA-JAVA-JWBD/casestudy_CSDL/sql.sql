use furama_resort;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from nhan_vien
where (ho_ten like 'h%') AND (length(ho_ten) <= 15);

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (timestampdiff(Year, ngay_sinh, now()) between 18 AND 50) AND (dia_chi ='da nang' OR dia_chi = 'quang tri');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select h.ma_khach_hang, count(h.ma_khach_hang) as lsd
from khach_hang k inner join loai_khach l on k.ma_loai_khach = l.ma_loai_khach
inner join hop_dong h on k.ma_khach_hang = h.ma_khach_hang
where l.ten_loai_khach = 'vip'
group by h.ma_khach_hang
order by lsd asc;

-- 


