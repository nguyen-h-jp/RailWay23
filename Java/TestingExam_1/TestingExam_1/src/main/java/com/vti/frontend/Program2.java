/**
 * Description: 
 */
package com.vti.frontend;

import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

/**
 * Description:
 */
public class Program2 {

	/**
	 * Description:
	 */
	public static void main(String[] args) {
		UserController userController = new UserController();

		boolean isOk = false;
		while (!isOk) {
			System.out.println(
					"Nhập vào chức năng muốn sử dụng:\n" + "1. In ra thông tin id, full name, email của các user\n"
							+ "2. Lấy thông tin của user theo user id\n" + "3. Xóa user theo user id\n" + "4. Login\n"
							+ "5. Admin tạo user\n" + "6. Kết thúc\n");
			int inputNumber = ScannerUtils.inputInt();
			switch (inputNumber) {
			case 1:
				List<User> users = userController.getUserInformation();
				System.out.println("Thông tin các user là:");
				System.out.println("+----------+---------------+-------------------------+");
				System.out.printf("|%10s|%15s|%25s|%n", "user_id", "full_name", "email");
				System.out.println("+----------+---------------+-------------------------+");
				for (User user : users) {
					System.out.printf("|%10d|%15s|%25s|%n", user.getUserID(), user.getFullName(), user.getEmail());
					System.out.println("+----------+---------------+-------------------------+");
				}
				break;
			case 2:
				User user = null;
				System.out.println("Nhập vào user id");
				int userID = ScannerUtils.inputInt();
				user = userController.getUserByUserID(userID);
				if (user instanceof Admin) {
					Admin admin = (Admin) user;
					System.out.println("Người này là admin, với thông tin là:");
					System.out.println("+----------+---------------+-------------------------+---------------+");
					System.out.printf("|%10s|%15s|%25s|%15d|%n", "user_id", "full_name", "email", "exp_in_year");
					System.out.println("+----------+---------------+-------------------------+---------------+");
					System.out.printf("|%10s|%15s|%25s|%15d|%n", admin.getUserID(), admin.getFullName(),
							admin.getEmail(), admin.getExpInYear());
					System.out.println("+----------+---------------+-------------------------+---------------+");
				} else if (user instanceof Employee) {
					Employee employee = (Employee) user;
					System.out.println("Người này là employee, với thông tin là:");
					System.out.println("+----------+---------------+-------------------------+---------------+");
					System.out.printf("|%10s|%15s|%25s|%15s|%n", "user_id", "full_name", "email", "pro_skill");
					System.out.println("+----------+---------------+-------------------------+---------------+");
					System.out.printf("|%10s|%15s|%25s|%15s|%n", employee.getUserID(), employee.getFullName(),
							employee.getEmail(), employee.getProSkill());
					System.out.println("+----------+---------------+-------------------------+---------------+");
				}
				isOk = false;
				break;
			case 3:
				System.out.println("Nhập vào id của user cần xóa");
				int userID2 = ScannerUtils.inputInt();
				int effectedRecords = 0;
				effectedRecords = userController.deleteUserByUserID(userID2);
				if (effectedRecords != 0) {
					System.out.println("Xóa thành công");
				} else {
					System.out.println("Xóa thất bại");
				}
				isOk = false;
				break;
			case 4:
				System.out.println("Nhập vào email");
				String email = ScannerUtils.inputString();
				System.out.println("Nhập vào password");
				String password = ScannerUtils.inputString();
				int check = 0;
				check = userController.login(email, password);
				if (check == 1 || check == 2) {
					System.out.println("Đăng nhập thành công");
				} else {
					System.out.println("Đăng nhập thất bại");
				}
				isOk = true;
				break;
			case 5:
				System.out.println("Nhập vào email");
				String email1 = ScannerUtils.inputString();
				System.out.println("Nhập vào password");
				String password1 = ScannerUtils.inputString();
				int check1 = 0;
				check1 = userController.login(email1, password1);
				if (check1 == 1) {
					System.out.println("Admin đăng nhập thành công");
					System.out.println("Nhập vào thông tin employee cần thêm");
					System.out.println("Nhập vào full name");
					String fullName = ScannerUtils.inputString();
					System.out.println("Nhập vào email");
					String email2 = ScannerUtils.inputString();
					int createCheck = 0;
					createCheck = userController.createEmployee(fullName, email2);
					if (createCheck != 0) {
						System.out.println("Tạo thành công employee");
					} else {
						System.out.println("Tạo employee thất bại");
					}
				} else {
					System.out.println("Sai email hoặc mật khẩu, hoặc bạn không phải Admin");
				}
				isOk = true;
				break;
			case 6:
				return;
			default:
				isOk = false;
				break;
			}
		}
	}
}
