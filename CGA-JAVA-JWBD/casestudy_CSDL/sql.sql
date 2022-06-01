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

-- 5. Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, h.ma_hop_dong, dv.ten_dich_vu, h.ngay_lam_hop_dong, h.ngay_ket_thuc, (dv.chi_phi_thue + hdct.so_luong*dvdk.gia) as tong_tien
from (hop_dong h inner join dich_vu dv on h.ma_dich_vu = dv.ma_dich_vu)  
inner join (hop_dong_chi_tiet hdct inner join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem) on h.ma_hop_dong = hdct.ma_hop_dong
right join (khach_hang kh inner join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach) on h.ma_khach_hang = kh.ma_khach_hang
group by kh.ma_khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 2 của năm 2022 (Quý 2 là tháng 4, 5, 6).
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv left join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where !(quarter(hd.ngay_lam_hop_dong) = 2 AND year(hd.ngay_lam_hop_dong) = 2022);

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2021 nhưng chưa từng được khách hàng đặt phòng trong năm 2022.
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv left join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where year(hd.ngay_lam_hop_dong) = 2021 AND !(year(hd.ngay_lam_hop_dong) = 2022);

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
select distinct(ho_ten) from khach_hang;

select ho_ten from khach_hang
group by ho_ten;

select ho_ten from khach_hang
union
select ho_ten from khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select year(ngay_lam_hop_dong) as nam, month(ngay_lam_hop_dong) as thang, count(ma_hop_dong) as so_luong from hop_dong hd
group by year(ngay_lam_hop_dong), month(ngay_lam_hop_dong)
order by year(ngay_lam_hop_dong);

-- 10.  Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, count(hdct.ma_dich_vu_di_kem) as so_luong_dvdk from hop_dong hd
inner join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
inner join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
group by hdct.ma_hop_dong;

