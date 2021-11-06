DROP DATABASE IF EXISTS quan_ly_dat_phong;
CREATE DATABASE quan_ly_dat_phong;
USE quan_ly_dat_phong;

ALTER DATABASE quan_ly_dat_phong CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- câu 1: Tạo Bảng và thêm tối thiểu 5 bản ghi cho mỗi Bảng
DROP TABLE IF EXISTS KHACH_HANG;
CREATE TABLE KHACH_HANG(
	MaKH 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    TenKH 	VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    DiaChi 	VARCHAR(50) CHAR SET utf8mb4,
    SoDT 	CHAR(11) UNIQUE 
);

INSERT INTO KHACH_HANG(TenKH, DiaChi, SoDT)
VALUES 
	('Nguyễn Khánh Linh', 'Hà Nội'	, '0986888663'),
	('Nguyễn Văn B'		, 'Hà Nội'	, '0986888664'),
	('Nguyễn Văn C'		, 'Hà Nội'	, '0986888665'),
	('Nguyễn Văn D'		, 'Bắc Ninh', '0986888666'),
	('Nguyễn Văn E'		, 'Cao Bằng', '0986888667');

DROP TABLE IF EXISTS PHONG;
CREATE TABLE PHONG(
	MaPhong 			TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    LoaiPhong 			VARCHAR(50) CHAR SET utf8mb4 UNIQUE NOT NULL,
    SoKhachHangToiDa 	TINYINT,
    GiaPhong 			DECIMAL(9,0),
    MoTa 				VARCHAR(50) CHAR SET utf8mb4
);

INSERT INTO PHONG(LoaiPhong, SoKhachHangToiDa, GiaPhong, MoTa)
VALUES 
	('Loại 1', 5	, 500000	, 'Không có'),
	('Loại 2', 10	, 1000000	, 'Không có'),
	('Loại 3', 15	, 1500000	, 'Không có'),
	('Loại 4', 20	, 2000000	, 'Không có'),
	('Loại 5', 25	, 2500000	, 'Không có');
	
DROP TABLE IF EXISTS DICH_VU_DI_KEM;
CREATE TABLE DICH_VU_DI_KEM(
	MaDV 		TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    TenDV 		VARCHAR(50) CHAR SET utf8mb4 UNIQUE NOT NULL,
    DonViTinh 	VARCHAR(50) CHAR SET utf8mb4,
    DonGia 		DECIMAL(9,0)
);

INSERT INTO DICH_VU_DI_KEM(TenDV, DonViTinh, DonGia)
VALUES 
	('Bia'		, 'Lon', 20000),
	('Nước ngọt', 'Lon', 10000),
	('Bò húc'	, 'Lon', 15000),
	('Trái cây'	, 'Đĩa', 50000),
	('Khăn ướt'	, 'Cái', 5000);
	    
DROP TABLE IF EXISTS DAT_PHONG;
CREATE TABLE DAT_PHONG(
	MaDatPhong 		INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    MaPhong 		TINYINT NOT NULL, -- fk
    MaKH 			INT NOT NULL, -- fk
    NgayDat 		DATE,
    TienDatCoc 		DECIMAL(9,0),
    GhiChu 			VARCHAR(50) CHAR SET utf8mb4,
    TrangThaiDat 	ENUM('đã đặt', 'đã hủy'),
    FOREIGN KEY (MaPhong) REFERENCES PHONG(MaPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaKH) REFERENCES KHACH_HANG(MaKH) ON DELETE CASCADE ON UPDATE CASCADE
);  

INSERT INTO DAT_PHONG(MaPhong, MaKH, NgayDat, TienDatCoc, GhiChu, TrangThaiDat)
VALUES 
	(1, 1, '2020/01/02', 200000, 'Không có', 'đã đặt'),
	(2, 1, '2020/01/01', 200000, 'Không có', 'đã đặt'),
	(3, 3, '2020/03/03', 200000, 'Không có', 'đã đặt'),
	(4, 4, '2020/02/03', 200000, 'Không có', 'đã hủy'),
	(5, 5, '2020/05/05', 200000, 'Không có', 'đã đặt'),
	(1, 5, '2021/04/05', 200000, 'Không có', 'đã đặt'),
	(2, 5, '2021/09/05', 200000, 'Không có', 'đã đặt'),
	(1, 4, '2021/06/06', 200000, 'Không có', 'đã đặt');
    
DROP TABLE IF EXISTS CHI_TIET_SU_DUNG_DV;
CREATE TABLE CHI_TIET_SU_DUNG_DV(
	MaDatPhong 		INT NOT NULL, -- fk
    MaDV 			TINYINT NOT NULL, -- fk
    PRIMARY KEY(MaDatPhong, MaDV),
    SoLuong 		TINYINT,
    FOREIGN KEY (MaDatPhong) REFERENCES dat_phong(MaDatPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaDV) REFERENCES dich_vu_di_kem(MaDV) ON DELETE CASCADE ON UPDATE CASCADE
);  

INSERT INTO CHI_TIET_SU_DUNG_DV(MaDatPhong, MaDV, SoLuong)
VALUES 
	(1, 1, 1),
	(1, 2, 2),
	(1, 3, 2),
	(2, 2, 2),
	(2, 1, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5);

-- câu 2: Hiển thị loại phòng đã thuê, tên dịch vụ đã sử dụng của khách hàng có tên là “Nguyễn Khánh Linh”

SELECT p.LoaiPhong, dvdk.TenDV
FROM KHACH_HANG kh LEFT JOIN DAT_PHONG dp ON kh.MaKH = dp.MaKH
	LEFT JOIN PHONG p ON dp.MaPhong = p.MaPhong
	LEFT JOIN CHI_TIET_SU_DUNG_DV ctsd ON dp.MaDatPhong = ctsd.MaDatPhong
    LEFT JOIN DICH_VU_DI_KEM dvdk ON ctsd.MaDV = dvdk.MaDV
	WHERE kh.TenKH = 'Nguyễn Khánh Linh'
    GROUP BY p.LoaiPhong, dvdk.TenDV;

-- câu 3: Viết Function để trả về Số điện thoại của Khách hàng thuê nhiều phòng nhất trong năm 2020

SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS f_return_phone_number;
DELIMITER $$
CREATE FUNCTION f_return_phone_number() RETURNS VARCHAR(50)
	BEGIN
		DECLARE phone_number_of_max VARCHAR(50);
        SET phone_number_of_max = '';
        SELECT kh.SoDT INTO phone_number_of_max
		FROM khach_hang kh LEFT JOIN dat_phong dp ON kh.MaKH = dp.MaKH
		WHERE dp.TrangThaiDat = 'đã đặt' AND YEAR(dp.NgayDat) = '2020'
		GROUP BY kh.MaKH
        HAVING count(dp.MaDatPhong) = 
			(SELECT MAX(phong_da_dat_count)
				FROM (SELECT COUNT(dp.MaDatPhong) AS phong_da_dat_count
					FROM khach_hang kh LEFT JOIN dat_phong dp ON kh.MaKH = dp.MaKH
						WHERE dp.TrangThaiDat = 'đã đặt' AND YEAR(dp.NgayDat) = '2020'
							GROUP BY kh.MaKH) AS temp);
		RETURN phone_number_of_max;
    END$$
DELIMITER ;

SELECT f_return_phone_number();

-- câu 4: Viết thủ tục tăng giá phòng thêm 10,000 VNĐ so với giá phòng hiện tại cho những phòng có số khách
-- tối đa lớn hơn 5.

DROP PROCEDURE IF EXISTS sp_tang_gia_phong_co_so_nguoi_lon_hon_5;
DELIMITER $$
CREATE PROCEDURE sp_tang_gia_phong_co_so_nguoi_lon_hon_5()
	BEGIN
		UPDATE phong
        SET GiaPhong = GiaPhong + 10000
        WHERE SoKhachHangToiDa > 5;
		SELECT * FROM phong;
	END$$
DELIMITER ;

CALL sp_tang_gia_phong_co_so_nguoi_lon_hon_5();

-- câu 5: Viết thủ tục thống kê khách hàng và số lần thuê phòng tương ứng của từng khách hàng trong năm nay.

DROP PROCEDURE IF EXISTS sp_thong_ke_khach_hang_va_so_lan_thue_phong_trong_nam_nay;
DELIMITER $$
CREATE PROCEDURE sp_thong_ke_khach_hang_va_so_lan_thue_phong_trong_nam_nay()
	BEGIN
		SELECT kh.TenKH, count(dp.MaDatPhong) AS 'Số lần thuê phòng trong năm nay'
		FROM khach_hang kh LEFT JOIN dat_phong dp ON kh.MaKH = dp.MaKH
		WHERE dp.TrangThaiDat = 'đã đặt' AND YEAR(dp.NgayDat) = YEAR(CURDATE())
		GROUP BY kh.MaKH;
	END$$
DELIMITER ;

CALL sp_thong_ke_khach_hang_va_so_lan_thue_phong_trong_nam_nay();

-- câu 6: Viết thủ tục hiển thị 5 đơn đặt phòng gần nhất bao gồm có các thông tin: Mã đặt phòng, tên khách
-- hàng, loại phòng, giá phòng.

DROP PROCEDURE IF EXISTS sp_5_don_dat_phong_gan_nhat;
DELIMITER $$
CREATE PROCEDURE sp_5_don_dat_phong_gan_nhat()
	BEGIN
		SELECT dp.MaDatPhong, kh.TenKH, p.LoaiPhong, p.GiaPhong
		FROM dat_phong dp LEFT JOIN khach_hang kh ON dp.MaKH = kh.MaKH
		LEFT JOIN phong p ON dp.MaPhong = p.MaPhong
		GROUP BY dp.MaDatPhong
		ORDER BY DATE(dp.NgayDat) DESC
		LIMIT 5;
	END$$
DELIMITER ;

CALL sp_5_don_dat_phong_gan_nhat();


-- câu 7: Viết Trigger kiểm tra khi thêm phòng mới có Số khách tối đa vượt quá 10 người thì không cho thêm
-- mới và hiển thị thông báo “Vượt quá số người cho phép”.

DROP TRIGGER IF EXISTS trg_toi_da_10_nguoi;
DELIMITER $$
CREATE TRIGGER trg_toi_da_10_nguoi
	BEFORE INSERT ON PHONG
    FOR EACH ROW
    BEGIN
		IF NEW.SoKhachHangToiDa > 10
        THEN 
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Vượt quá số người cho phép';
		END IF;
    END$$
DELIMITER ;

INSERT INTO phong(LoaiPhong, SoKhachHangToiDa, GiaPhong, MoTa)
VALUES 
	('Loại 6', 11, 500000, 'Không có');

    
    
    
    