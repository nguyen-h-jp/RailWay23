drop database if exists quan_ly_dat_phong;
create database quan_ly_dat_phong;
use quan_ly_dat_phong;

-- câu 1: Tạo Bảng và thêm tối thiểu 5 bản ghi cho mỗi Bảng
drop table if exists khach_hang;
create table khach_hang(
	MaKH 	int not null primary key auto_increment unique,
    TenKH 	varchar(50),
    DiaChi 	varchar(50),
    SoDT 	varchar(50)
);

insert into khach_hang(TenKH, DiaChi, SoDT)
values 
	('Nguyễn Khánh Linh', 'Hà Nội'	, '0986888663'),
	('Nguyễn Văn B'		, 'Hà Nội'	, '0986888664'),
	('Nguyễn Văn C'		, 'Hà Nội'	, '0986888665'),
	('Nguyễn Văn D'		, 'Bắc Ninh', '0986888666'),
	('Nguyễn Văn E'		, 'Cao Bằng', '0986888667');

drop table if exists phong;
create table phong(
	MaPhong 			int not null primary key auto_increment unique,
    LoaiPhong 			varchar(50),
    SoKhachHangToiDa 	int,
    GiaPhong 			decimal(9,0),
    MoTa 				varchar(50)
);

insert into phong(LoaiPhong, SoKhachHangToiDa, GiaPhong, MoTa)
values 
	('Loại 1', 5	, 500000	, 'Không có'),
	('Loại 2', 10	, 1000000	, 'Không có'),
	('Loại 3', 15	, 1500000	, 'Không có'),
	('Loại 4', 20	, 2000000	, 'Không có'),
	('Loại 5', 25	, 2500000	, 'Không có');
	
drop table if exists dich_vu_di_kem;
create table dich_vu_di_kem(
	MaDV 		int not null primary key auto_increment unique,
    TenDV 		varchar(50),
    DonViTinh 	varchar(50),
    DonGia 		decimal(9,0)
);

insert into dich_vu_di_kem(TenDV, DonViTinh, DonGia)
values 
	('Bia'		, 'Lon', 20000),
	('Nước ngọt', 'Lon', 10000),
	('Bò húc'	, 'Lon', 15000),
	('Trái cây'	, 'Đĩa', 50000),
	('Khăn ướt'	, 'Cái', 5000);
	    
drop table if exists dat_phong;
create table dat_phong(
	MaDatPhong 		int not null primary key auto_increment unique,
    MaPhong 		int not null, -- fk
    MaKH 			int not null, -- fk
    NgayDat 		date,
    TienDatCoc 		decimal(9,0),
    GhiChu 			varchar(50),
    TrangThaiDat 	enum('đã đặt', 'đã hủy'),
    FOREIGN KEY (MaPhong) REFERENCES phong(MaPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaKH) REFERENCES khach_hang(MaKH) ON DELETE CASCADE ON UPDATE CASCADE
);  

insert into dat_phong(MaPhong, MaKH, NgayDat, TienDatCoc, GhiChu, TrangThaiDat)
values 
	(1, 1, '2020/01/02', 200000, 'Không có', 'đã đặt'),
	(2, 1, '2020/01/01', 200000, 'Không có', 'đã đặt'),
	(3, 3, '2020/03/03', 200000, 'Không có', 'đã đặt'),
	(4, 4, '2020/02/03', 200000, 'Không có', 'đã hủy'),
	(5, 5, '2020/05/05', 200000, 'Không có', 'đã đặt'),
	(1, 5, '2021/04/05', 200000, 'Không có', 'đã đặt'),
	(2, 5, '2021/09/05', 200000, 'Không có', 'đã đặt'),
	(1, 4, '2021/06/06', 200000, 'Không có', 'đã đặt');
    
drop table if exists chi_tiet_su_dung_dv;
create table chi_tiet_su_dung_dv(
	MaDatPhong 		int not null, -- fk
    MaDV 			int not null, -- fk
    primary key(MaDatPhong, MaDV),
    SoLuong 		int,
    FOREIGN KEY (MaDatPhong) REFERENCES dat_phong(MaDatPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaDV) REFERENCES dich_vu_di_kem(MaDV) ON DELETE CASCADE ON UPDATE CASCADE
);  

insert into chi_tiet_su_dung_dv(MaDatPhong, MaDV, SoLuong)
values 
	(1, 1, 1),
	(1, 2, 2),
	(1, 3, 2),
	(2, 2, 2),
	(2, 1, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5);

-- câu 2: Hiển thị loại phòng đã thuê, tên dịch vụ đã sử dụng của khách hàng có tên là “Nguyễn Khánh Linh”

select * from khach_hang;
select * from phong;
select * from dat_phong;
select * from dich_vu_di_kem;
select * from chi_tiet_su_dung_dv;

select p.LoaiPhong, dvdk.TenDV
from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
	left join phong p on dp.MaPhong = p.MaPhong
	left join chi_tiet_su_dung_dv ctsd on dp.MaDatPhong = ctsd.MaDatPhong
    left join dich_vu_di_kem dvdk on ctsd.MaDV = dvdk.MaDV
	where kh.TenKH = 'Nguyễn Khánh Linh'
    group by p.LoaiPhong, dvdk.TenDV;

-- câu 3: Viết Function để trả về Số điện thoại của Khách hàng thuê nhiều phòng nhất trong năm 2020

select * from khach_hang;
select * from phong;
select * from dat_phong;
select * from dich_vu_di_kem;
select * from chi_tiet_su_dung_dv;

SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS return_phone_number;
DELIMITER $$
CREATE FUNCTION return_phone_number() RETURNS varchar(50)
	BEGIN
		declare phone_number_of_max varchar(50);
        set phone_number_of_max = '';
        select kh.SoDT into phone_number_of_max
		from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
		where dp.TrangThaiDat = 'đã đặt' and year(dp.NgayDat) = '2020'
		group by kh.MaKH
        having count(dp.MaDatPhong) = 
			(select max(phong_da_dat_count)
				from (select count(dp.MaDatPhong) as phong_da_dat_count
					from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
						where dp.TrangThaiDat = 'đã đặt' and year(dp.NgayDat) = '2020'
							group by kh.MaKH) as temp);
		RETURN phone_number_of_max;
    END$$
DELIMITER ;

select return_phone_number();

-- câu 4: Viết thủ tục tăng giá phòng thêm 10,000 VNĐ so với giá phòng hiện tại cho những phòng có số khách
-- tối đa lớn hơn 5.

select * from khach_hang;
select * from phong;
select * from dat_phong;
select * from dich_vu_di_kem;
select * from chi_tiet_su_dung_dv;

drop procedure if exists tang_gia_phong_co_so_nguoi_lon_hon_5;
delimiter $$
create procedure tang_gia_phong_co_so_nguoi_lon_hon_5()
	begin
		update phong
        set GiaPhong = GiaPhong + 10000
        where SoKhachHangToiDa > 5;
		select * from phong;
	end$$
delimiter ;

call tang_gia_phong_co_so_nguoi_lon_hon_5();

-- câu 5: Viết thủ tục thống kê khách hàng và số lần thuê phòng tương ứng của từng khách hàng trong năm nay.

select * from khach_hang;
select * from phong;
select * from dat_phong;
select * from dich_vu_di_kem;
select * from chi_tiet_su_dung_dv;

drop procedure if exists thong_ke_khach_hang_va_so_lan_thue_phong_trong_nam_nay;
delimiter $$
create procedure thong_ke_khach_hang_va_so_lan_thue_phong_trong_nam_nay()
	begin
		select kh.TenKH, count(dp.MaDatPhong) as 'Số lần thuê phòng trong năm nay'
		from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
		where dp.TrangThaiDat = 'đã đặt' and year(dp.NgayDat) = year(curdate())
		group by kh.MaKH;
	end$$
delimiter ;

call thong_ke_khach_hang_va_so_lan_thue_phong_trong_nam_nay();

-- câu 6: Viết thủ tục hiển thị 5 đơn đặt phòng gần nhất bao gồm có các thông tin: Mã đặt phòng, tên khách
-- hàng, loại phòng, giá phòng.

select * from khach_hang;
select * from phong;
select * from dat_phong;
select * from dich_vu_di_kem;
select * from chi_tiet_su_dung_dv;


drop procedure if exists 5_don_dat_phong_gan_nhat;
delimiter $$
create procedure 5_don_dat_phong_gan_nhat()
	begin
		select dp.MaDatPhong, kh.TenKH, p.LoaiPhong, p.GiaPhong
		from dat_phong dp left join khach_hang kh on dp.MaKH = kh.MaKH
		left join phong p on dp.MaPhong = p.MaPhong
		group by dp.MaDatPhong
		order by date(dp.NgayDat) desc
		limit 5;
	end$$
delimiter ;

call 5_don_dat_phong_gan_nhat();


-- câu 7: Viết Trigger kiểm tra khi thêm phòng mới có Số khách tối đa vượt quá 10 người thì không cho thêm
-- mới và hiển thị thông báo “Vượt quá số người cho phép”.

select * from khach_hang;
select * from phong;
select * from dat_phong;
select * from dich_vu_di_kem;
select * from chi_tiet_su_dung_dv;

drop trigger if exists toi_da_10_nguoi;
DELIMITER $$
create trigger toi_da_10_nguoi
	before insert on phong
    for each row
    begin
		if new.SoKhachHangToiDa > 10
        then 
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Vượt quá số người cho phép';
		end if;
    end$$
DELIMITER ;

insert into phong(LoaiPhong, SoKhachHangToiDa, GiaPhong, MoTa)
values 
	('Loại 6', 11, 500000, 'Không có');

-- select dp.MaDatPhong, kh.TenKH, p.LoaiPhong, p.GiaPhong
-- from dat_phong dp left join khach_hang kh on dp.MaKH = kh.MaKH
-- 	left join phong p on dp.MaPhong = p.MaPhong
--     group by dp.MaDatPhong
--     order by date(dp.NgayDat) asc
--     limit 5;
-- select *
-- from khach_hang kh left join pho;

-- select kh.TenKH, count(dp.MaDatPhong) as 'Số lần thuê phòng trong năm nay'
-- from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
-- where dp.TrangThaiDat = 'đã đặt' and year(dp.NgayDat) = year(curdate())
-- group by kh.MaKH

-- select return_phone_number();
-- select kh.SoDT,count(dp.MaDatPhong)
-- from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
-- where dp.TrangThaiDat = 'đã đặt' and year(dp.NgayDat) = '2020'
-- group by kh.MaKH;

    
--       select count(dp.MaDatPhong) as phong_da_dat_count
-- 		from khach_hang kh left join dat_phong dp on kh.MaKH = dp.MaKH
-- 		where dp.TrangThaiDat = 'đã đặt' and year(dp.NgayDat) = '2020'
-- 		group by kh.MaKH;
    
    
    
    
    