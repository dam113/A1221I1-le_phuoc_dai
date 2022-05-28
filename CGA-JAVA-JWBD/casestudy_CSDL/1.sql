-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema furama_resort
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema furama_resort
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `furama_resort` DEFAULT CHARACTER SET utf8 ;
USE `furama_resort` ;

-- -----------------------------------------------------
-- Table `furama_resort`.`vi_tri`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`vi_tri` (
  `ma_vi_tri` INT NOT NULL AUTO_INCREMENT,
  `ten_vi_tri` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_vi_tri`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`trinh_do`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`trinh_do` (
  `ma_trinh_do` INT NOT NULL AUTO_INCREMENT,
  `ten_trinh_do` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_trinh_do`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`bo_phan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`bo_phan` (
  `ma_bo_phan` INT NOT NULL AUTO_INCREMENT,
  `ten_bo_phan` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_bo_phan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`nhan_vien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`nhan_vien` (
  `ma_nha_vien` INT NOT NULL AUTO_INCREMENT,
  `ho_ten` VARCHAR(45) NULL,
  `ngay_sinh` DATE NULL,
  `so_cmnd` VARCHAR(45) NULL,
  `luong` DOUBLE NULL,
  `so_dien_thoai` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `dia_chi` VARCHAR(45) NULL,
  `ma_vi_tri` INT NULL,
  `ma_trinh_do` INT NULL,
  `ma_bo_phan` INT NULL,
  PRIMARY KEY (`ma_nha_vien`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`loai_khach`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`loai_khach` (
  `ma_loai_khach` INT NOT NULL AUTO_INCREMENT,
  `ten_loai_khach` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_loai_khach`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`khach_hang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`khach_hang` (
  `ma_khach_hang` INT NOT NULL AUTO_INCREMENT,
  `ma_loai_khach` INT NULL,
  `ho_ten` VARCHAR(45) NULL,
  `ngay_sinh` VARCHAR(45) NULL,
  `gioi_tinh` BIT(1) NULL,
  `so_cmnd` VARCHAR(45) NULL,
  `so_dien_thoai` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `dia_chi` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_khach_hang`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`kieu_thue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`kieu_thue` (
  `ma_kieu_thue` INT NOT NULL AUTO_INCREMENT,
  `ten_kieu_thue` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_kieu_thue`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`loai_dich_vu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`loai_dich_vu` (
  `ma_loai_dich_vu` INT NOT NULL,
  `ten_loai_dich_vu` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_loai_dich_vu`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`dich_vu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`dich_vu` (
  `ma_dich_vu` INT NOT NULL AUTO_INCREMENT,
  `ten_dich_vu` VARCHAR(45) NULL,
  `dien_tich` INT NULL,
  `chi_phi_thue` DOUBLE NULL,
  `so_nguoi_toi_da` INT NULL,
  `ma_kieu_thue` INT NULL,
  `ma_loai_dich_vu` INT NULL,
  `tieu_chuan_phong` VARCHAR(45) NULL,
  `mo_ta_tien_nghi_khac` VARCHAR(45) NULL,
  `dien_tich_ho_boi` DOUBLE NULL,
  `so_tang` INT NULL,
  PRIMARY KEY (`ma_dich_vu`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`hop_dong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`hop_dong` (
  `ma_hop_dong` INT NOT NULL AUTO_INCREMENT,
  `ngay_lam_hop_dong` DATETIME NULL,
  `ngay_ket_thuc` DATETIME NULL,
  `tien_dat_coc` DOUBLE NULL,
  `ma_nhan_vien` INT NULL,
  `ma_khach_hang` INT NULL,
  `ma_dich_vu` INT NULL,
  PRIMARY KEY (`ma_hop_dong`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`dich_vu_di_kem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`dich_vu_di_kem` (
  `ma_dich_vu_di_kem` INT NOT NULL AUTO_INCREMENT,
  `ten_dich_vu_di_kem` VARCHAR(45) NULL,
  `gia` DOUBLE NULL,
  `don_vi` VARCHAR(10) NULL,
  `trang_thai` VARCHAR(45) NULL,
  PRIMARY KEY (`ma_dich_vu_di_kem`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `furama_resort`.`hop_dong_chi_tiet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `furama_resort`.`hop_dong_chi_tiet` (
  `ma_hop_dong_chi_tiet` INT NOT NULL AUTO_INCREMENT,
  `ma_hop_dong` INT NULL,
  `ma_dich_vu_di_kem` INT NULL,
  `so_luong` INT NULL,
  PRIMARY KEY (`ma_hop_dong_chi_tiet`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`vi_tri`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`vi_tri` (`ma_vi_tri`, `ten_vi_tri`) VALUES (1, 'quan ly');
INSERT INTO `furama_resort`.`vi_tri` (`ma_vi_tri`, `ten_vi_tri`) VALUES (2, 'nhan vien cham soc');
INSERT INTO `furama_resort`.`vi_tri` (`ma_vi_tri`, `ten_vi_tri`) VALUES (3, 'nhan vien thu ngan');
INSERT INTO `furama_resort`.`vi_tri` (`ma_vi_tri`, `ten_vi_tri`) VALUES (4, 'nhan vien ki thuat');

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`trinh_do`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`trinh_do` (`ma_trinh_do`, `ten_trinh_do`) VALUES (1, 'cao dang');
INSERT INTO `furama_resort`.`trinh_do` (`ma_trinh_do`, `ten_trinh_do`) VALUES (2, 'dai hoc');

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`bo_phan`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`bo_phan` (`ma_bo_phan`, `ten_bo_phan`) VALUES (1, 'nhan su');
INSERT INTO `furama_resort`.`bo_phan` (`ma_bo_phan`, `ten_bo_phan`) VALUES (2, 'ki thuat');
INSERT INTO `furama_resort`.`bo_phan` (`ma_bo_phan`, `ten_bo_phan`) VALUES (3, 'maketting');

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`nhan_vien`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`nhan_vien` (`ma_nha_vien`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `ma_vi_tri`, `ma_trinh_do`, `ma_bo_phan`) VALUES (1, 'dai', '2000-01-01', '123456789', 12000000, '0123456789', 'ledai010120@gmail.com', 'quang tri', 1, 2, 1);
INSERT INTO `furama_resort`.`nhan_vien` (`ma_nha_vien`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `ma_vi_tri`, `ma_trinh_do`, `ma_bo_phan`) VALUES (2, 'hoang', '1993-02-12', '234567890', 15000000, '0456789123', 'hoang1201@gmail.com', 'da nang', 2, 1, 1);
INSERT INTO `furama_resort`.`nhan_vien` (`ma_nha_vien`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `ma_vi_tri`, `ma_trinh_do`, `ma_bo_phan`) VALUES (3, 'nam', '1997-11-28', '789456123', 10000000, '0834555666', 'nam1128@gmail.com', 'hue', 3, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`kieu_thue`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) VALUES (1, 'theo ngay ');
INSERT INTO `furama_resort`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) VALUES (2, 'qua dem');
INSERT INTO `furama_resort`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) VALUES (3, 'theo gio');

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`loai_dich_vu`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`loai_dich_vu` (`ma_loai_dich_vu`, `ten_loai_dich_vu`) VALUES (1, 'an sang');
INSERT INTO `furama_resort`.`loai_dich_vu` (`ma_loai_dich_vu`, `ten_loai_dich_vu`) VALUES (2, 'xe du lich');
INSERT INTO `furama_resort`.`loai_dich_vu` (`ma_loai_dich_vu`, `ten_loai_dich_vu`) VALUES (3, 'tiec tung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`dich_vu`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES (1, 'phong don 1', 30, 200000, 3, 1, 1, 'loai 1', 'co dieu hoa, view nhin ra bien', 15.5, 3);
INSERT INTO `furama_resort`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES (2, 'phong don 2', 25, 150000, 3, 1, 1, 'loai 2', 'co dieu hoa', 15.5, 2);
INSERT INTO `furama_resort`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES (3, 'phong doi 1', 40, 250000, 6, 2, 2, 'loai 2', 'co dieu hoa, view nhin ra bien', 15.5, 4);
INSERT INTO `furama_resort`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES (4, 'phong doi 2', 45, 300000, 6, 2, 2, 'loai 1', 'co dieu hoa, view nhin ra bien', 15.5, 5);
INSERT INTO `furama_resort`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES (5, 'can ho', 50, 1000000, 5, 3, 3, 'loai 1', 'co dieu hoa, view nhin ra bien, co bep', 20, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`hop_dong`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`hop_dong` (`ma_hop_dong`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `ma_nhan_vien`, `ma_khach_hang`, `ma_dich_vu`) VALUES (1, '2022-05-25', '2022-05-28', 200000, 1, 2, 1);
INSERT INTO `furama_resort`.`hop_dong` (`ma_hop_dong`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `ma_nhan_vien`, `ma_khach_hang`, `ma_dich_vu`) VALUES (2, '2022-05-22', '2022-05-30', 500000, 2, 4, 1);
INSERT INTO `furama_resort`.`hop_dong` (`ma_hop_dong`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `ma_nhan_vien`, `ma_khach_hang`, `ma_dich_vu`) VALUES (3, '2022-04-20', '2022-04-25', 100000, 2, 1, 2);
INSERT INTO `furama_resort`.`hop_dong` (`ma_hop_dong`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `ma_nhan_vien`, `ma_khach_hang`, `ma_dich_vu`) VALUES (4, '2022-04-25', '2022-05-30', 3000000, 3, 3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`dich_vu_di_kem`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai`) VALUES (1, 'nuoc uong', 5000, 'chai', 'san sang');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai`) VALUES (2, 'do an sang', 40000, 'suat', 'san sang');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai`) VALUES (3, 'khan tam', 10000, 'cai', 'san sang');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai`) VALUES (4, 'dau goi', 2000, 'goi', 'san sang');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai`) VALUES (5, 'ao phao', 20000, 'cai', 'san sang');

COMMIT;


-- -----------------------------------------------------
-- Data for table `furama_resort`.`hop_dong_chi_tiet`
-- -----------------------------------------------------
START TRANSACTION;
USE `furama_resort`;
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`ma_hop_dong_chi_tiet`, `ma_hop_dong`, `ma_dich_vu_di_kem`, `so_luong`) VALUES (1, 1, 2, 1);
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`ma_hop_dong_chi_tiet`, `ma_hop_dong`, `ma_dich_vu_di_kem`, `so_luong`) VALUES (2, 1, 1, 2);
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`ma_hop_dong_chi_tiet`, `ma_hop_dong`, `ma_dich_vu_di_kem`, `so_luong`) VALUES (3, 2, 3, 3);
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`ma_hop_dong_chi_tiet`, `ma_hop_dong`, `ma_dich_vu_di_kem`, `so_luong`) VALUES (4, 3, 2, 5);
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`ma_hop_dong_chi_tiet`, `ma_hop_dong`, `ma_dich_vu_di_kem`, `so_luong`) VALUES (5, 4, 1, 1);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
