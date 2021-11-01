use testing_system;
-- vi du 1 tao thu tuc lay ten phong ban theo ma phong ban = 1
-- tao thu tuc
describe department;

drop procedure if exists sp_lay_ten_phong_theo_ma_phong;

DELIMITER $$
create procedure sp_lay_ten_phong_theo_ma_phong(in departmentId int, out departmentName varchar(50))
	begin
		select department_name into departmentName
			from department
				where department_id = departmentId;
	end $$
DELIMITER ;

-- su dung va goi thu tuc
set @ten_phong_ban = '';
call sp_lay_ten_phong_theo_ma_phong(1, @ten_phong_ban);
select @ten_phong_ban;
select * from department;

-- viet thu tuc lay thong tin cau hoi cua tac gia co ten la nguyen van the hoac dia chi email la nguyenvanthe@gmail.com
select * from question;
select * from `account`;
DESCRIBE question;
DESCRIBE `account`;

drop procedure if exists sp_lay_thong_tin_cau_hoi_theo_tac_gia;

DELIMITER $$
create procedure sp_lay_thong_tin_cau_hoi_theo_tac_gia(in fullName varchar(50) char set utf8mb4, in Email varchar(50))
	begin
		select q.content
			from question q join `account` a on q.creator_id = a.account_id
				where a.full_name = fullName or a.email = Email;
	end $$
DELIMITER ;

-- su dung va goi thu tuc
set @ten_tac_gia = 'tran van a';
call sp_lay_thong_tin_cau_hoi_theo_tac_gia(@ten_tac_gia,'');

select * from department;