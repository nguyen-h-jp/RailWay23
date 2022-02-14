package com.vti.academy;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

import com.vti.academy.enums.PositionName;

public class Exercise5_InputFromConsole {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Sales";
		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Marketing";
		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "Bảo vệ";

		// Position
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = PositionName.DEV.getPositionName();

		Position position2 = new Position();
		position2.positionID = 2;
		position2.positionName = PositionName.TEST.getPositionName();

		Position position3 = new Position();
		position3.positionID = 3;
		position3.positionName = PositionName.SCRUM_MASTER.getPositionName();

		Position position4 = new Position();
		position4.positionID = 4;
		position4.positionName = PositionName.PM.getPositionName();

		// Tao truoc group
		Group group1 = new Group();
		group1.groupID = 1;
		group1.groupName = "Nhóm 1";

		Group group2 = new Group();
		group2.groupID = 2;
		group2.groupName = "Nhóm 2";

		Group group3 = new Group();
		group3.groupID = 3;
		group3.groupName = "Nhóm 3";

		// Account
		Account account1 = new Account();
		account1.accountID = 1;
		account1.email = "nguyenvana@gmail.com";
		account1.userName = "a_nguyenvan";
		account1.fullName = "Nguyễn Văn A";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDate.now();
		account1.groups = new Group[] { group1, group3 };

		Account account2 = new Account();
		account2.accountID = 2;
		account2.email = "nguyenvanb@gmail.com";
		account2.userName = "b_nguyenvan";
		account2.fullName = "Nguyễn Văn B";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = LocalDate.now();
		account2.groups = new Group[] { group1, group2, group3 };

		Account account3 = new Account();
		account3.accountID = 3;
		account3.email = "nguyenvanc@gmail.com";
		account3.userName = "c_nguyenvan";
		account3.fullName = "Nguyễn Văn C";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = LocalDate.now();
		account3.groups = new Group[] { group1, group2 };

		Account account4 = new Account();
		account4.accountID = 4;
		account4.email = "nguyenvand@gmail.com";
		account4.userName = "d_nguyenvan";
		account4.fullName = "Nguyễn Văn d";
		account4.department = department3;
		account4.position = position3;
		account4.createDate = LocalDate.now();
		account4.groups = new Group[] { group1, group2 };

		Account account5 = new Account();
		account5.accountID = 5;
		account5.email = "nguyenvane@gmail.com";
		account5.userName = "e_nguyenvan";
		account5.fullName = "Nguyễn Văn e";
		account5.department = department3;
		account5.position = position3;
		account5.createDate = LocalDate.now();
		account5.groups = new Group[] { group1, group2 };

		// add account to group
		group1.accounts = new Account[] { account1, account2, account3 };
		group2.accounts = new Account[] { account2, account3 };
		group3.accounts = new Account[] { account1, account2 };

		// create list of all accounts
		Account[] accountArray = { account1, account2, account3, account4, account5 };

		// create list of all department
		Department[] departmentList = { department1, department2, department3 };
		// create lis of all groups
		Group[] groupArray = { group1, group2, group3 };

//		Question1();
//		Question2();
//		Question3();
//		Question4();
//		Question5();
//		Question6();
//		Question7();
//		Question8(sc);
//		Question9(accountArray, groupArray);
//		Question10(accountArray, groupArray, sc);
		Question11(accountArray, groupArray, sc);
//		test();
		sc.close();

	}

	// Question 1:
	// Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình

	static void Question1(Scanner sc) {
		System.out.println("Question 1: ");
		System.out.println("Nhập vào số nguyên thứ 1: ");
		int a = sc.nextInt();
		System.out.println("Nhập vào số nguyên thứ 2: ");
		int b = sc.nextInt();
		System.out.println("Nhập vào số nguyên thứ 3: ");
		int c = sc.nextInt();
		System.out.println("Các số vừa nhập: " + a + ", " + b + ", " + c);
		System.out.println();
	}

	// Question 2:
	// Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình

	static void Question2(Scanner sc) {
		System.out.println("Question 2: ");
		System.out.println("Nhập vào số thực thứ 1: ");
		float a = sc.nextFloat();
		System.out.println("Nhập vào số thực thứ 2: ");
		float b = sc.nextFloat();
		System.out.println("Nhập vào số thực thứ 3: ");
		float c = sc.nextFloat();
		System.out.println("Các số vừa nhập: " + a + ", " + b + ", " + c);
		System.out.println();
	}

	// Question 3:
	// Viết lệnh cho phép người dùng nhập họ và tên

	static void Question3(Scanner sc) {
		System.out.println("Question 3: ");
		System.out.println("Nhập vào họ và tên: ");
		String a = sc.nextLine();
		System.out.println("Họ và tên vừa nhập: " + a);
		System.out.println();
	}

	// Question 4:
	// Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ

	static void Question4(Scanner sc) {
		System.out.println("Question 4: ");
		System.out.println("Nhập vào ngày sinh: ");
		int day = sc.nextInt();
		System.out.println("Nhập vào tháng sinh: ");
		int month = sc.nextInt();
		System.out.println("Nhập vào năm sinh: ");
		int year = sc.nextInt();
		LocalDate birthDay = LocalDate.of(year, month, day);
		System.out.println("Ngày sinh của bạn là: " + birthDay);
		System.out.println();
	}

	// Question 5:
	// Viết lệnh cho phép người dùng tạo account (viết thành method)
	// Đối với property Position,
	// Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ chuyển thành
	// Position.Dev, Position.Test, Position.ScrumMaster, Position.PM

	static void Question5(Scanner sc) {
		System.out.println("Question 5: ");
		System.out.println("Nhập vào thông tin cho account cần tạo: ");
		Account ac = new Account();

		System.out.println("Nhập vào id: ");
		ac.accountID = sc.nextInt();

		System.out.println("Nhập vào email: ");
		ac.email = sc.next();

		System.out.println("Nhập vào userName: ");
		ac.userName = sc.next();

		System.out.println("Nhập vào department: ");
		String department = sc.next();

		System.out.println("Nhập vào số 1, 2, 3, 4, với 1: Dev, 2: Test, 3: ScrumMaster, 4: PM: ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			Position position1 = new Position();
			position1.positionID = 1;
			position1.positionName = PositionName.DEV.getPositionName();
			ac.position = position1;
			break;
		case 2:
			Position position2 = new Position();
			position2.positionID = 2;
			position2.positionName = PositionName.TEST.getPositionName();
			ac.position = position2;
			break;
		case 3:
			Position position3 = new Position();
			position3.positionID = 3;
			position3.positionName = PositionName.SCRUM_MASTER.getPositionName();
			ac.position = position3;
			break;
		case 4:
			Position position4 = new Position();
			position4.positionID = 4;
			position4.positionName = PositionName.PM.getPositionName();
			ac.position = position4;
			break;
		}
		System.out.println("Thông tin account đã tạo: ");
		System.out.println("ID: " + ac.accountID + ", Email: " + ac.email + ", UserName: " + ac.userName
				+ ", Department: " + department + ", Position: " + ac.position.positionName);

		System.out.println();
	}

	// Question 6:
	// Viết lệnh cho phép người dùng tạo department (viết thành method)

	static void Question6(Scanner sc) {
		System.out.println("Question 6: ");
		System.out.println();
		Department dp = new Department();
		System.out.println("Nhập vào thông tin department cần tạo: ");
		System.out.println("Nhập vào id");
		dp.departmentID = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập vào tên department: ");
		dp.departmentName = sc.nextLine();
		System.out.println("Đã tạo department thành công:");
		System.out.println("Department đã tạo: " + "ID: " + dp.departmentID + ", Tên phòng ban: " + dp.departmentName);
		System.out.println();
	}

	// Question 7:
	// Nhập số chẵn từ console

	static void Question7(Scanner sc) {
		System.out.println("Question 7: ");
		System.out.println();
		System.out.println("Nhập vào 1 số chẵn: ");
		int so = sc.nextInt();
		if (so % 2 == 0) {
			System.out.println("Số nhập vào là sỗ chẵn: " + so);
		} else {
			System.out.println("Số nhập vào không phải số chẵn");
		}
	}

	// Question 8:
	// Viết chương trình thực hiện theo flow sau:
	// Bước 1:
	// Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
	// Bước 2:
	// Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
	// Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
	// Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở
	// lại bước 1

	static void Question8(Scanner sc) {
		System.out.println("Question 8: ");
		System.out.println();
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
		int input = sc.nextInt();
		if (input == 1) {
			Question5(sc); // tạo tài khoản
		} else if (input == 2) {
			Question6(sc); // tạo department
		} else
			System.out.println("Mời bạn nhập lại");
		Question8(sc); // chạy lại
		sc.close();
	}

	// Question 9:
	// Viết method cho phép người dùng thêm group vào account theo flow sau:
	// Bước 1:
	// In ra tên các usernames của user cho người dùng xem
	// Bước 2:
	// Yêu cầu người dùng nhập vào username của account
	// Bước 3:
	// In ra tên các group cho người dùng xem
	// Bước 4:
	// Yêu cầu người dùng nhập vào tên của group
	// Bước 5:
	// Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào
	// group đó .

	static void Question9(Account[] arr, Group[] gr, Scanner sc) {
		System.out.println("Question 9: ");
		System.out.println();

		System.out.println("Tên các username: ");
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i].userName);
		}

		System.out.println("Nhập vào username: ");
		String inputUserName = sc.nextLine();

		System.out.println("Tên các nhóm: ");
		for (int i = 0; i < gr.length; ++i) {
			System.out.println(gr[i].groupName);
		}

		System.out.println("Nhập vào tên nhóm: ");
		String inputGroupName = sc.nextLine();

		int indexAccount = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].userName.equals(inputUserName)) {
				indexAccount = i;
			}
		}

		int indexGroup = -1;
		for (int i = 0; i < gr.length; i++) {
			if (gr[i].groupName.equals(inputGroupName)) {
				indexGroup = i;
			}
		}
		if (indexAccount < 0 || indexGroup < 0) {
			System.out.println("Thông tin tên nhóm hoặc tên người dùng không tồn tại trong hệ thống");
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].userName.equals(inputUserName)) {
					Group[] groupAdd = { gr[indexGroup] };
					arr[i].groups = groupAdd;
					System.out.println("Bạn vừa thêm account: " + arr[indexAccount].userName + " vào group: "
							+ arr[indexAccount].groups[0].groupName);
				}
			}
		}
	}

	/*
	 * Question 10: Tiếp tục Question 8 và Question 9 Bổ sung thêm vào bước 2 của
	 * Question 8 như sau: Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm
	 * group vào account Bổ sung thêm Bước 3 của Question 8 như sau: Sau khi người
	 * dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng
	 * "Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn "Có" thì
	 * quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử
	 * dụng lệnh return để kết thúc chương trình)
	 */

	static void Question10(Account[] arr, Group[] gr, Scanner sc) {
		System.out.println("Question 10: ");
		System.out.println();
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
		int input = sc.nextInt();
		boolean isDoneFlag = false;
		while (!isDoneFlag) {
			if (input == 1) {
				Question5(sc); // tạo tài khoản
				isDoneFlag = true;
			} else if (input == 2) {
				Question6(sc); // tạo department
			} else if (input == 3) {
				Question9(arr, gr, sc); // thêm group vào account
				isDoneFlag = true;
			} else {
				System.out.println("Mời bạn nhập lại");
				isDoneFlag = false;
			}
		}
		if (isDoneFlag) {
			System.out.println("Bạn có muốn thực hiện chức năng khác không? 1: Có, 2: Không");
			int yesNo = sc.nextInt();
			if (yesNo == 1) {
				Question10(arr, gr, sc);
			} else {
				System.out.println("Thank you");
				return;
			}
		}
	}

	// Question 11: Tiếp tục Question 10
	// Bổ sung thêm vào bước 2 của Question 8 như sau:
	// Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm
	// ngẫu nhiên, chức năng sẽ được cài đặt như sau:
	// Bước 1:
	// In ra tên các usernames của user cho người dùng xem
	// 6
	// Bước 2:
	// Yêu cầu người dùng nhập vào username của account
	// Bước 3:
	// Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
	// Bước 4:
	// Thêm account vào group chương trình vừa chọn ngẫu nhiên

	static void Question11(Account[] arr, Group[] gr, Scanner sc) {
		System.out.println("Question 11: ");
		System.out.println();
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
		int input = sc.nextInt();
		boolean isDoneFlag = false;
		while (!isDoneFlag) {
			if (input == 1) {
				Question5(sc); // tạo tài khoản
				isDoneFlag = true;
			} else if (input == 2) {
				Question6(sc); // tạo department
			} else if (input == 3) {
				Question9(arr, gr, sc);
				isDoneFlag = true;
			} else if (input == 4) {
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i].userName);
				}
				Random random = new Random();
				String userName = sc.next();
				int i = random.nextInt(gr.length);
				Group groupAdd = gr[i];
				System.out.println("Nhập vào username: ");
				boolean isCheckAcc = false;
				for (Account account : arr) {
					if(userName.equals(account.userName)) {
						groupAdd.accounts = Arrays.copyOf(groupAdd.accounts, groupAdd.accounts.length + 1);
						groupAdd.accounts[groupAdd.accounts.length - 1] = account;
						System.out.println("account " + account.userName + " đã thêm vào group " + groupAdd.groupName);
						System.out.println("kết quả: group " + groupAdd.groupName + "có những account: ");
						for (Account acc1 : groupAdd.accounts) {
							System.out.println("\t" + acc1.userName);
						}
						isCheckAcc = true;
					}
				}
				if(isCheckAcc == false) {
					System.out.println("không có account trong hệ thống");
				}
				isDoneFlag = true;
			} else {
				System.out.println("Mời bạn nhập lại");
				isDoneFlag = false;
			}
		}
		if (isDoneFlag) {
			System.out.println("Bạn có muốn thực hiện chức năng khác không? 1: Có, 2: Không");
			int yesNo = sc.nextInt();
			if (yesNo == 1) {
				Question10(arr, gr, sc);
			} else {
				System.out.println("Thank you");
				return;
			}
		}
	}

}
