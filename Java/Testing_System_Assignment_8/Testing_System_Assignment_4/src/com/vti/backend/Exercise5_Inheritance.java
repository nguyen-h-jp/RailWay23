package com.vti.backend;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.CanBo;
import com.vti.entity.KySu;
import com.vti.entity.enums.GioiTinh;

public class Exercise5_Inheritance {
//	Question 1: inheritance
//	Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
//	Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ,
//	khác), địa chỉ.
//	Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
//	Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
//	Các nhân viên có thuộc tính riêng: công việc.
//	Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp
//	CanBo.

	private CanBo[] canBoArr;

	public Exercise5_Inheritance() {
		canBoArr = new CanBo[] {};
	};

	public void question1(Scanner sc) {
		while (true) {
			System.out.println("======================================================================");

			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");

			System.out.println("=== 1. Thêm mới cán bộ. ===");

			System.out.println("=== 2. Tìm kiếm theo họ tên. ===");

			System.out.println("=== 3. Hiện thị thông tin về danh sách các cán bộ. ===");

			System.out.println("=== 4. Nhập vào tên của cán bộ và delete cán bộ đó ===");

			System.out.println("=== 5. Thoát khỏi chương trình. ===");
			System.out.println("======================================================================");

			int menuChoose = sc.nextInt();

			switch (menuChoose) {
			case 1:
				themCanBo(sc);
				break;
			case 2:
				timTheoTen(sc);
				break;
			case 3:
				hienThiDanhSachCanBo();
				break;
			case 4:
				xoaTheoTen(sc);
				break;
			case 5:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

	public void themCanBo(Scanner sc) {
		System.out.println("----------------------------------------------------");
		System.out.println("--------Lựa chọn chức năng bạn muốn sử dụng---------");
		System.out.println("--- 1. Thêm Kỹ Sư---");
		System.out.println("--- 2. Thêm Công nhân ---");
		System.out.println("--- 3. Thêm nhân viên ---");
		System.out.println("----------------------------------------------------");
		int numChucNang = sc.nextInt();
		switch (numChucNang) {
		case 1:
			sc.nextLine();
			System.out.println("Nhập vào tên Kỹ Sư: ");
			String tenKySu = sc.nextLine();
			System.out.println("Nhập vào tuổi Kỹ Sư: ");
			Byte tuoiKySu = sc.nextByte();
			System.out.println("Nhập vào giới tính Kỹ Sư 1.Nam, 2.Nữ, 3.Chưa xác định: ");
			int numGioiTinh = sc.nextInt();
			String gioiTinhKySu = null;
			switch (numGioiTinh) {
			case 1:
				gioiTinhKySu = GioiTinh.NAM.getGioiTinh();
				break;
			case 2:
				gioiTinhKySu = GioiTinh.NU.getGioiTinh();
				break;
			case 3:
				gioiTinhKySu = GioiTinh.KHAC.getGioiTinh();
				break;
			}
			sc.nextLine();
			System.out.println("Nhập vào địa chỉ Kỹ Sư: ");
			String diaChiKySu = sc.nextLine();
			System.out.println("Nhập vào chuyên ngành Kỹ Sư: ");
			String chuyenNganhKySu = sc.nextLine();
			CanBo canbo = new KySu(tenKySu, tuoiKySu, gioiTinhKySu, diaChiKySu, chuyenNganhKySu);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1);
			canBoArr[canBoArr.length - 1] = canbo;
			for (CanBo canBo : canBoArr) {
				System.out.println(canBo);
			}
			break;
		default:
			break;
		}
	}

	public void timTheoTen(Scanner sc) {
		sc.nextLine();
		System.out.println("Nhập vào tên muốn tìm kiếm:");
		String ten = sc.nextLine();
		if (canBoArr.length > 0) {
			for (CanBo canBo : canBoArr) {
				if (canBo.getHoTen().equals(ten)) {
					System.out.println(canBo);
				}
			}
		}
	}

	// c) Hiển thị danh sách cán bộ
	private void hienThiDanhSachCanBo() {
		if (canBoArr.length > 0) {
			for (CanBo canbo : canBoArr) {
				System.out.println(canbo);
			}
		} else {
			System.out.println("Không có cán bộ để hiển thị!");
		}
	}

	// d) Nhập vào tên của cán bộ và delete cán bộ đó

	private void xoaTheoTen(Scanner sc) {
		sc.nextLine();
		System.out.println("Nhập tên của cán bộ cần xóa");
		String ten = sc.nextLine();
		int index = 0;
		int[] indexArr = new int[] {};
		if (canBoArr.length > 0) {
			for (CanBo canbo : canBoArr) {
				if (canbo.getHoTen().equals(ten)) {
					indexArr = ArrayUtils.add(indexArr, index);
					index++;
				}
			}
			if (canBoArr.length > 0) {
				canBoArr = ArrayUtils.removeAll(canBoArr, indexArr);
			}
		}
	}
}
