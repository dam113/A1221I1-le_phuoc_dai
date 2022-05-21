create database egd_sang_mo_hinh_quan_he;

use egd_sang_mo_hinh_quan_he;

create table phieu_xuat(
	so_px int primary key,
    ngay_xuat datetime
);

create table vat_tu(
	ma_vtu varchar(20) primary key,
    ten_vtu varchar(255)
);

create table phieu_nhap(
	so_pn int primary key,
    ngay_nhap datetime
);

create table don_dh(
	so_dh int primary key,
    ngay_dh datetime
);

create table nha_cc(
	ma_ncc varchar(20) primary key,
    ten_ncc varchar(255),
    dia_chi varchar(255)
);

create table sdt_ncc(
	ma_sdt varchar(20) primary key,
    sdt varchar(12),
    ma_ncc varchar(20),
	foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table ct_px(
	so_px int,
    ma_vtu varchar(20),
	dg_xuat long,
    sl_xuat int,
    primary key (so_px, ma_vtu),
    foreign key (so_px) references phieu_xuat(so_px),
    foreign key (ma_vtu) references vat_tu(ma_vtu)
);

create table ct_pn(
	ma_vtu varchar(20),
    so_pn int,
    dg_nhap long,
    sl_nhap int,
    primary key (ma_vtu, so_pn),
	foreign key (ma_vtu) references vat_tu(ma_vtu),
    foreign key (so_pn) references phieu_nhap(so_pn)
);

alter table don_dh add ma_ncc varchar(20);
alter table don_dh add foreign key (ma_ncc) references nha_cc(ma_ncc);

create table ct_dh(
	ma_vtu varchar(20),
    so_dh int,
    primary key (ma_vtu, so_dh),
    foreign key (ma_vtu) references vat_tu(ma_vtu),
    foreign key (so_dh) references don_dh(so_dh)
);
