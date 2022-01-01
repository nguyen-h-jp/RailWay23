package com.vti.backend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.utils.DateUtils;
import com.vti.utils.ScannerUtils;

public class Exercise2_CRUD {
	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println(DepartmentDao.getDepartments());
	}

	public void question2_3(Scanner sc) throws ClassNotFoundException, SQLException {

		System.out.println("Nhập vào id của department cần tìm");
		int inputNumber = sc.nextInt();
		sc.nextLine();
		if (DepartmentDao.getDepartmentByID(inputNumber).size() == 0) {
			System.out.println("Không tồn tại department có id là: " + inputNumber);
		} else {
			System.out.println(DepartmentDao.getDepartmentByID(inputNumber));
		}
	}

	public void question4(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên của department cần tìm");
		String inputString = sc.nextLine();
		System.out.println(DepartmentDao.isDepartmentNameExists(inputString));
	}

	public void question5(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên của department cần thêm");
		String inputString = sc.nextLine();
		DepartmentDao.createDepartment(inputString);
		System.out.println("Danh sách các department sau khi thêm: " + DepartmentDao.getDepartments());

	}

	public void question6(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Update department name theo id");
		System.out.println("Nhập vào id của department cần update");
		int inputNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập vào tên mới");
		String inputString = sc.nextLine();
		DepartmentDao.updateDepartmentName(inputNumber, inputString);
		System.out.println("Danh sách các department sau khi update: " + DepartmentDao.getDepartments());
	}

	public void question7(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Xóa department theo id");
		System.out.println("Nhập vào id của department cần xóa");
		int inputNumber = sc.nextInt();
		sc.nextLine();
		DepartmentDao.deleteDepartment(inputNumber);
		System.out.println("Danh sách các department còn lại sau khi xóa: " + DepartmentDao.getDepartments());
	}

	public void question8() throws SQLException {
		AccountRepository accountRepository = new AccountRepository();
		DepartmentRepository departmentRepository = new DepartmentRepository();
		PositionRepository positionRepository = new PositionRepository();
//		GroupRepository groupRepository = new GroupRepository();
		boolean isOk = false;
		while (!isOk) {
			System.out.println("Nhập vào chức năng muốn sử dụng: \n" + "1. Lấy danh sách account \n"
					+ "2. Tạo mới account \n" + "3. Tìm accout theo account id \n"
					+ "4. Kiểm tra account có tồn tại không(theo id) \n"
					+ "5. Kiểm tra account có tồn tại không(theo username) \n" + "6. Xóa account \n" + "7. Kết thúc");
			int inputNumber = ScannerUtils.inputInt();
			switch (inputNumber) {
			case 1:
				List<Account> accountList = new ArrayList<Account>();
				accountList = accountRepository.getAccountList();
				for (Account account : accountList) {
					System.out.println(account);
				}
				isOk = true;
				break;
			case 2:

//				int accountID;
//				String email;
//				String userName;
//				String fullName;
//				Department department;
//				Position position;
//				Date createDate;
//				List<Group> groups;
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
//				System.out.println("Bạn muốn thêm account vào mấy group");
//				int groupCount = ScannerUtils.inputInt();
//				List<Integer> groupIDList = null;
//				for (int i = 0; i < groupCount; i++) {
//					System.out.println("Nhập vào id của group thứ :" + (i + 1));
//					int groupID = ScannerUtils.inputInt();
//					groupIDList.add((Integer)groupID);
//				}

//				public Account(int accountID, String email, String userName, String fullName, Department department,
//						Position position, Date createDate, List<Group> groups)

				Account account = new Account(0, email, username, fullName,
						departmentRepository.getDepartmentByID(departmentID),
						positionRepository.getPositionByID(positionID), new Date());

				accountRepository.createAccount(account);
				System.out.println("Thêm thành công account");
				isOk = true;
				break;
			case 3:
				System.out.println("Nhập vào id của account cần tìm");
				int inputID = ScannerUtils.inputInt();
				Account account2 = null;
				account2 = accountRepository.getAccountByID(inputID);
				System.out.println(account2);
				isOk = true;
				break;

			case 4:
				System.out.println("Nhập vào id của account cần tìm");
				int inputID2 = ScannerUtils.inputInt();
				System.out.println(accountRepository.isAccountExists(inputID2));
				isOk = true;
				break;
			case 5:
				System.out.println("Nhập vào username của account cần tìm");
				String inputString = ScannerUtils.inputString();
				System.out.println(accountRepository.isAccountExists(inputString));
				isOk = true;
				break;
			case 6:
				System.out.println("Xóa account theo account id");
				int inputID3 = ScannerUtils.inputInt();
				accountRepository.deleteAccountByID(inputID3);
				System.out.println("Đã xóa thành công");
				isOk = true;
				break;
			default:
				isOk = false;
				break;
			}

		}
	}

}
