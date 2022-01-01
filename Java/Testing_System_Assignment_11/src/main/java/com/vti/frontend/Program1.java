package com.vti.frontend;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.backend.datalayer.interfaces.IDepartmentRepository;
import com.vti.backend.datalayer.interfaces.IPositionRepository;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.backend.presentationlayer.GroupController;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.utils.JDBCUtils;
import com.vti.utils.ScannerUtils;

public class Program1 {

	public static void main(String[] args) throws ParseException {

		boolean isOk = false;
		while (!isOk) {
			System.out.println("Nhập vào chức năng muốn sử dụng: 1. Account, 2. Group");
			int inputNumber = ScannerUtils.inputInt();
			switch (inputNumber) {
			case 1:
				withAccount();
				isOk = true;
				break;
			case 2:
				withGroup();
				isOk = true;
				break;
			default:
				isOk = false;
				break;
			}

		}

		JDBCUtils.close();
		ScannerUtils.close();
	}

	/**
	 * Description: thao tác với account
	 * 
	 * @throws SQLException
	 */
	List<Account> accountList = new ArrayList<Account>();

	public static void withAccount() {
		AccountController accountController = new AccountController();
		IDepartmentRepository departmentRepository = new DepartmentRepository();
		IPositionRepository positionRepository = new PositionRepository();
		boolean isOk = false;
		try {

			while (!isOk) {
				System.out.println("Nhập vào chức năng muốn sử dụng: \n" + "1. Lấy danh sách account \n"
						+ "2. Tạo mới account \n" + "3. Tìm accout theo account id \n"
						+ "4. Kiểm tra account có tồn tại không(theo id) \n"
						+ "5. Kiểm tra account có tồn tại không(theo username) \n"
						+ "6. Cập nhật thông tin account theo account id \n" + "7. Xóa account \n" + "8. Kết thúc");
				int inputNumber = ScannerUtils.inputInt();
				switch (inputNumber) {
				case 1:
					List<Account> accountList = new ArrayList<Account>();
					accountList = accountController.getAccountList();
					for (Account account : accountList) {
						System.out.println(account);
					}
					isOk = true;
					break;
				case 2:
					System.out.println("Nhập vào email");
					String email = ScannerUtils.inputString();
					System.out.println("Nhập vào user name");
					String username = ScannerUtils.inputString();
					System.out.println("Nhập vào full name");
					String fullName = ScannerUtils.inputString();
					System.out.println("Nhập vào department id");
					int departmentID = ScannerUtils.inputInt();
					System.out.println("Nhập vào positionID");
					int positionID = ScannerUtils.inputInt();

					Account account = new Account(0, email, username, fullName,
							departmentRepository.getDepartmentByID(departmentID),
							positionRepository.getPositionByID(positionID), new Date());
					accountController.createAccount(account);
					System.out.println("Tạo thành công account");
					isOk = true;
					break;

				case 3:
					System.out.println("Nhập vào id của account cần tìm");
					int inputID1 = ScannerUtils.inputInt();
					System.out.println(accountController.getAccountByID(inputID1));
					isOk = true;
					break;
				case 4:
					System.out.println("Nhập vào id của account cần kiểm tra");
					int inputID2 = ScannerUtils.inputInt();
					System.out.println(accountController.isAccountExists(inputID2));
					isOk = true;
					break;
				case 5:
					System.out.println("Nhập vào username của account cần kiểm tra");
					String userName = ScannerUtils.inputString();
					System.out.println(accountController.isAccountExists(userName));
					isOk = true;
					break;

				case 6:
					System.out.println("Nhập vài id của account cần update");
					int inputID3 = ScannerUtils.inputInt();
					System.out.println("Nhập vào email");
					String email2 = ScannerUtils.inputString();
					System.out.println("Nhập vào user name");
					String username2 = ScannerUtils.inputString();
					System.out.println("Nhập vào full name");
					String fullName2 = ScannerUtils.inputString();
					System.out.println("Nhập vào department id");
					int departmentID2 = ScannerUtils.inputInt();
					System.out.println("Nhập vào positionID");
					int positionID2 = ScannerUtils.inputInt();

					Account account2 = new Account(0, email2, username2, fullName2,
							departmentRepository.getDepartmentByID(departmentID2),
							positionRepository.getPositionByID(positionID2), new Date());
					accountController.updateAccountByID(inputID3, account2);
					System.out.println("Update thành công");
					isOk = true;
					break;

				case 7:
					System.out.println("Nhập vào id của account cần xóa");
					int inputID4 = ScannerUtils.inputInt();
					accountController.deleteAccountByID(inputID4);

					System.out.println("Xóa thành công");

					isOk = true;
					break;

				case 8:
					isOk = false;
					return;
				default:
					isOk = false;
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}

	/**
	 * Description: thao tác với group
	 */
	private static void withGroup() {
		GroupController groupController = new GroupController();

		boolean isOk = false;
		while (!isOk) {
			System.out.println("Nhập vào chức năng muốn sử dụng:\n" + "1. Tìm những group của account theo account id\n"
					+ "2. Exit ");
			int inputNumber = ScannerUtils.inputInt();
			switch (inputNumber) {
			case 1:
				System.out.println("Nhập vào id của account");
				int accountID = ScannerUtils.inputInt();
				List<Group> groups = null;
				groups = groupController.getGroupListByAccountID(accountID);
				for (Group group : groups) {
					System.out.println(group);
				}
				break;
			case 2:
				return;

			default:
				break;
			}
		}

	}

}
