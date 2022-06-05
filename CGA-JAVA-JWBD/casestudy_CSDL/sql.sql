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

-- 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách
-- hàng có ten_loai_khach là “Diamond” và có dia_chi ở “quang tri” hoặc “Đà nẳng”.
select dvdk.ten_dich_vu_di_kem as ten_dich_vu_da_su_dung from khach_hang kh
join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang=hd.ma_khach_hang
join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
where lk.ten_loai_khach="vip" and kh.dia_chi in ('quang tri', 'da nag')
group by dvdk.ten_dich_vu_di_kem;

-- 12. Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), 
-- so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả 
-- các dịch vụ đã từng được khách hàng đặt vào 8 tháng cuối năm 2021 
-- nhưng chưa từng được khách hàng đặt vào 2 tháng đầu năm 2022.
SELECT hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu AS so_luong_dich_vu_di_kem,sum(hd.tien_dat_coc) as tong_tien_coc
FROM hop_dong hd 
	JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
    JOIN nhan_vien nv ON  hd.ma_nhan_vien = nv.ma_nhan_vien
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong 
WHERE ngay_lam_hop_dong BETWEEN '2021-05-01' AND '2021-12-31' AND dv.ma_dich_vu
	NOT IN
		(SELECT ma_dich_vu
		 FROM dich_vu
		 WHERE ngay_lam_hop_dong BETWEEN '2022-01-01' AND '2022-03-01')
GROUP BY hd.ma_hop_dong;    

-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã 
-- đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create or replace view sum_dvdk as
select ma_dich_vu_di_kem, count(ma_dich_vu_di_kem) as so_lan_su_dung from hop_dong_chi_tiet
group by ma_dich_vu_di_kem; 
select * from dich_vu_di_kem
having  ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from sum_dvdk where so_lan_su_dung=(select max(so_lan_su_dung)  from sum_dvdk));


-- 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem)
SELECT hdct.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
FROM  dich_vu_di_kem dvdk
	JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
	JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
GROUP BY dvdk.ten_dich_vu_di_kem
HAVING COUNT(dvdk.ma_dich_vu_di_kem) = 1
ORDER BY COUNT(dvdk.ma_dich_vu_di_kem);

-- 15.Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten,
-- ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được
-- tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi, count(nv.ma_nhan_vien) as so_hop_dong 
from nhan_vien nv
join vi_tri vt on nv.ma_vi_tri = vt.ma_vi_tri
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where year(hd.ngay_lam_hop_dong) between '2020' and '2021'
group by nv.ma_nhan_vien
having count(nv.ma_nhan_vien)<=3;

-- 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien
where not exists (select ma_nhan_vien from hop_dong hd where hd.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31' and hd.ma_nhan_vien=nhan_vien.ma_nhan_vien);

-- 17.Cập nhật thông tin những khách hàng có ten_loai_khach từ thành viên
-- lên vip, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
create or replace view update_loai_kh as
select kh.ma_khach_hang, sum(hdct.so_luong*dvdk.gia) as thanh_tien from hop_dong hd
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong)='2022'
group by kh.ma_khach_hang;

update khach_hang
set ma_loai_khach=1
where  ma_khach_hang in (select ma_khach_hang from update_loai_kh) and ma_loai_khach=2;


-- 18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

delete khach_hang, hop_dong, hop_dong_chi_tiet from khach_hang inner join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where not exists (select hop_dong.ma_hop_dong where year(hop_dong.ngay_lam_hop_dong) > '2021' and khach_hang.ma_khach_hang = hop_dong.ma_khach_hang);

-- 19.Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 3 lần trong năm 2022 lên gấp đôi.
create or replace view update_price as
select dvdk.ma_dich_vu_di_kem, count(dvdk.ma_dich_vu_di_kem) as so_lan from hop_dong_chi_tiet hdct
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having count(dvdk.ma_dich_vu_di_kem) > 3;

update dich_vu_di_kem
set gia = gia*2
where ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from update_price);

-- 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien
union All
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang;