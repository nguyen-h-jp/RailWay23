package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;

public class Testing_Mid_Term {
	private User[] userArr;

	public Testing_Mid_Term() {
		userArr = new User[5];
	}

	// khởi tạo danhh sách các user trong hệ thống
	public void question1(Scanner sc) {

		while (true) {
			System.out.println("1. Khởi tạo 5 user.");
			System.out.println("2. In thông tin của các user.");
			System.out.println("3. Tìm user theo id.");
			System.out.println("4. Xóa user theo id.");
			System.out.println("5. Đăng nhập.");
			System.out.println("6. Exit.");
			int num = 0;
			boolean isOk = false;
			do {
				System.out.println("Nhập vào chức năng muốn sử dụng, từ 1 - 6");
				num = sc.nextInt();
				if (num > 6 || num <= 0) {
					System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại!");
				} else {
					isOk = true;
				}
			} while (isOk == false);

			switch (num) {
			case 1:
				khoiTaoUser();
				break;
			case 2:
				inThongTin(userArr);
				break;
			case 3:
				timThongTinTheoID(sc);
				break;
			case 4:
				xoaTheoID(sc);
				break;
			case 5:
				dangNhap(sc);
				break;
			case 6:
				return;
			default:
				System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại");
			}
		}

	}

	public void khoiTaoUser() {
		User user1 = new Employee(1, "Nguyễn Văn A", "a_nguyenvan", "nguyenvana@gmail.com", "Password1", 1);
		User user2 = new Employee(2, "Nguyễn Văn B", "b_nguyenvan", "nguyenvanb@gmail.com", "Password2", 1);
		User user3 = new Employee(3, "Nguyễn Văn C", "c_nguyenvan", "nguyenvanc@gmail.com", "Password3", 2);
		User user4 = new Admin(4, "Nguyễn Văn D", "d_nguyenvan", "nguyenvand@gmail.com", "Password4", "Java");
		User user5 = new Admin(5, "Nguyễn Văn E", "e_nguyenvan", "nguyenvane@gmail.com", "Password5", "SQL");
		userArr[0] = user1;
		userArr[1] = user2;
		userArr[2] = user3;
		userArr[3] = user4;
		userArr[4] = user5;
		System.out.println("Khởi tạo thành công 5 user");
		System.out.println();
	}

	public void inThongTin(User[] arr) {
		System.out.printf("%-5s%-20s%-20s%-30s%n", "ID", "FullName", "UserName", "Email");
		for (User user : arr) {
			System.out.printf("%-5d%-20s%-20s%-30s%n", user.getId(), user.getFullName(), user.getUserName(),
					user.getEmail());
		}
		System.out.println();
	}

	public void timThongTinTheoID(Scanner sc) {
		System.out.println("Nhập vào id của nhân viên cần tìm");
		int inputID = sc.nextInt();
		sc.nextLine();

		for (User user : userArr) {
			if (user.getId() == inputID) {
				System.out.println(user.toString());
			}
		}
		System.out.println();
	}

	private void xoaTheoID(Scanner sc) {
//		sc.nextLine();
		System.out.println("Nhập id của nhân viên cần xóa");
		int inputNum = sc.nextInt();
		sc.nextLine();
		int[] indexArr = new int[] {};
		if (userArr.length > 0) {
			for (int i = 0; i < userArr.length; ++i) {
				if (userArr[i].getId() == inputNum) {
					indexArr = ArrayUtils.add(indexArr, i);
				}
			}
			if (userArr.length > 0) {
				userArr = ArrayUtils.removeAll(userArr, indexArr);
			}
			System.out.println("Đã xóa nhân viên có số id là " + inputNum);
		}
		System.out.println();
	}

	public void dangNhap(Scanner sc) {
		sc.nextLine();
		boolean isUserNameOk = false;

		while (isUserNameOk == false) {
			System.out.println("Nhập vào UserName:");
			String inputUserName = sc.nextLine();
			if (inputUserName.matches(".*[A-Z].*") || inputUserName.length() < 8) {
				System.out.println("UserName không thỏa mãn, vui lòng nhập lại: ");
				isUserNameOk = false;
			} else {
				isUserNameOk = true;
				boolean isPassWordOk = false;
				while (isPassWordOk == false) {
					System.out.println("Nhập vào password:");
					String inputUserPassword = sc.nextLine();
					if (inputUserPassword.matches(".*[A-Z].*") && inputUserPassword.length() >= 6
							&& inputUserPassword.length() <= 12) {
						for (User user : userArr) {
							if (user.getUserName().equals(inputUserName)
									&& user.getPassword().equals(inputUserPassword)) {
								isPassWordOk = true;
								System.out.println("{" + user.getFullName() + "}" + " đã đăng nhập thành công");
								if (user instanceof Admin) {
									System.out.println("*** Danh sách chức năng trong Hệ thống ***");
									System.out.println("=== 1. Quản trị Hệ thống===");
									System.out.println("=== 2. Quản lý Nhân viên===");
									System.out.println("=== 3. Quản lý Dự án===");
								} else if (user instanceof Employee) {
									System.out.println("*** Danh sách chức năng trong Hệ thống ***");
									System.out.println("=== 1. Xem danh sách Nhân viên===");
									System.out.println("=== 2. Cập nhật Thông tin cá nhân===");
								}
							}
						}
					} else {
						isPassWordOk = false;
						System.out.println("Password không thỏa mãn, vui lòng nhập lại:");
					}

				}
			}

		}
		System.out.println();

	}
}
