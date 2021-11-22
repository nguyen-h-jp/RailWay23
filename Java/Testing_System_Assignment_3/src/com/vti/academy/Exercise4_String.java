package com.vti.academy;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		question1(sc);
//		question2(sc);
//		question3(sc);
//		question4(sc);
//		question5(sc);
//		question6(sc);
//		question7(sc);
//		question8();
//		question10("hUng", "GnuH");
//		question11("sjdakâasljdkasjkd");
//		question12("Nguyễn Văn A");
//		question13("Nguyễn Văn A2");
		question14("VTI Academy", "e", "*");
		sc.close();
	}

	/*
	 * Question 1: Nhập một xâu kí tự, 
	 * đếm số lượng các từ trong xâu kí tự đó 
	 * (các từ có thể cách nhau bằng nhiều khoảng trắng );
	 */
	
	static void question1(Scanner sc) {

		int countCharacter = 0;
		
		System.out.println("Mời bạn nhập vào 1 sâu kí tự");
		String input = sc.nextLine();
		char[] a = new char[input.length()];
		for(int i = 0; i < input.length(); i++) {
			a[i] = input.charAt(i);
		}

		for(int i = 0; i < input.length(); i++) {
			if(a[i] != ' ') {
				countCharacter++;
			}
		}
		System.out.println(countCharacter);	
	}
	
	/*
	 * Question 2: Nhập hai xâu kí tự s1, s2 
	 * nối xâu kí tự s2 vào sau xâu s1;
	 */
	
	static void question2(Scanner sc) {
		System.out.println("Nhập vào xâu s1: ");
		String s1 = sc.nextLine();
		System.out.println("Nhập vào xâu s2: ");
		String s2 = sc.nextLine();
		String concatResult = s1.concat(s2);
		System.out.println(concatResult);	
	}
	
	/*
	 * Question 3: Viết chương trình để người dùng nhập vào 
	 * tên và kiểm tra, nếu tên chưa viết hoa chữ cái đầu 
	 * thì viết hoa lên
	 */
	
	static void question3(Scanner sc) {
		System.out.println("Nhập vào tên: ");
		String s = sc.nextLine();
		String firstChar = s.substring(0, 1).toUpperCase();
		String fromSecond = s.substring(1);
		String result = firstChar + fromSecond;
		System.out.println(result);	
	}
	
	/*
	 * Question 4: Viết chương trình để người dùng nhập vào tên 
	 * in từng ký tự trong tên của người dùng ra 
	 * VD: Người dùng nhập vào "Nam", hệ thống sẽ in ra
	 * "Ký tự thứ 1 là: N" "Ký tự thứ 1 là: A" "Ký tự thứ 1 là: M"
	 */
	
	static void question4(Scanner sc) {
		System.out.println("Mời bạn nhập vào tên: ");
		String name = sc.nextLine().toUpperCase();
		char[] stringToArray = new char[name.length()];
		for(int i = 0; i < name.length(); i++) {
			stringToArray[i] = name.charAt(i);
			System.out.println("Kí tự thứ " + (i + 1) + " là: " + stringToArray[i]);
		}	
	}
	
	
	/*
	 * Question 5:
	 * Viết chương trình để người dùng nhập vào họ, 
	 * sau đó yêu cầu người dùng nhập vào tên 
	 * và hệ thống sẽ in ra họ và tên đầy đủ
	 */
	
	static void question5(Scanner sc) {
		System.out.println("Mời bạn nhập vào họ: ");
		String ho = sc.nextLine();
		System.out.println("Mời bạn nhập vào tên: ");
		String ten = sc.nextLine();
		String hoTen = ho + " " + ten;
		System.out.println("Họ và tên là: " + hoTen);
	}
	
	/*
	 * Question 6: Viết chương trình yêu cầu người dùng nhập vào 
	 * họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm
	 * VD: Người dùng nhập vào "Nguyễn Văn Nam" Hệ thống sẽ in ra 
	 * "Họ là: Nguyễn" 
	 * "Tên đệm là: Văn"
	 * "Tên là: Nam"
	 */
	
	static void question6(Scanner sc) {
		System.out.println("Mời bạn nhập vào họ và tên: ");
		String fullName = sc.nextLine();
		String[] result = fullName.split("\s+");
		switch(result.length) {
		case 2: 
			System.out.println("Họ là: " + result[0]);
			System.out.println("Tên là: " + result[1]);
			break;
		case 3:
			System.out.println("Họ là: " + result[0]);
			System.out.println("Tên đệm là: " + result[1]);
			System.out.println("Tên là: " + result[2]);
			break;
		case 4: 
			System.out.println("Họ là: " + result[0]);
			System.out.println("Tên đệm là: " + result[1]);
			System.out.println("Tên là: " + result[2] + " " + result[3]);
			break;
		default:
			System.out.println("Có quá nhiều trường hợp tên không theo quy tắt nên không thể liệt kê hết");
		}
	}
	
	/*
	 * Question 7: Viết chương trình yêu cầu người dùng nhập vào 
	 * họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau: 
	 * a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào 
	 * VD: Nếu người dùng nhập vào " nguyễn văn nam "
	 * thì sẽ chuẩn hóa thành "nguyễn văn nam" 
	 * b) Viết hoa chữ cái mỗi từ của người dùng 
	 * VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ 
	 * chuẩn hóa thành "Nguyễn Văn Nam"
	 */
	
	static void question7(Scanner sc) {
		System.out.println("Mời bạn nhập vào họ và tên: ");
		String fullName = sc.nextLine().trim().toLowerCase(); // câu a
		String[] result = fullName.split("\s+"); //câu b
		ArrayList<String> afterUpperCaseFirstChar = new ArrayList<String>();
		for (int i = 0; i < result.length; ++i) {
			String firstChar = result[i].substring(0, 1).toUpperCase();
			String fromSecond = result[i].substring(1).toLowerCase();
			String temp = firstChar + fromSecond;
			afterUpperCaseFirstChar.add(temp);
		}
		for (String string : afterUpperCaseFirstChar) {
			System.out.printf("%s " ,string);
		}
	}
	
	/*
	 * Question 8: In ra tất cả các group có chứa chữ "Java"
	 */
	
	static void question8() {
		String[] groups = {"JAVA", "Java nè", "Java", "Jav", "Japan", "avaj", "java là gì"};
		for(int i = 0; i < groups.length; ++i) {
			if(groups[i].contains("Java")) {
				System.out.println(groups[i]);
			}
		}
	}
	
	/*
	 * Question 9: In ra tất cả các group "Java"
	 */
	
	static void question9() {
		String[] groups = {"JAVA", "Java nè", "Java", "Jav", "Japan", "avaj", "java là gì"};
		for(int i = 0; i < groups.length; ++i) {
			if(groups[i].equals("Java")) {
				System.out.println(groups[i]);
			}
		}
	}
	
	/*
	 * Question 10 (Optional): Kiểm tra 2 chuỗi có là đảo ngược 
	 * của nhau hay không.
	 * Nếu có xuất ra “OK” ngược lại “KO”. 
	 * Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
	 */
	
	static void question10(String s1, String s2) {
		String a = s1.toLowerCase();
		String b = s2.toLowerCase();
		char c;
		String temp = "";
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			temp = c + temp;
		}
		if (temp.equals(b)) {
			System.out.println("OK");
		}else {
			System.out.println("KO");
		}
	}
	
	/*
	 * Question 11 (Optional): Count special Character Tìm số lần xuất hiện ký tự
	 * "a" trong chuỗi
	 */
	
	static void question11(String s) {
		int countChar = 0;
		char[] a = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a') {
				countChar++;
			}
		}
		System.out.println(countChar);
	}
	
	/*
	 * Question 12 (Optional): Reverse String Đảo ngược chuỗi 
	 * sử dụng vòng lặp
	 */
	
	static void question12(String s) {
		char c;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			result = c + result;
		}
		System.out.println(result);
	}
	
	/*
	 * Question 13 (Optional): String not contains digit 
	 * Kiểm tra một chuỗi có chứa chữ số hay không, 
	 * nếu có in ra false ngược lại true. 
	 * Ví dụ: "abc" => true
	 * "1abc", "abc1", "123", "a1bc", null => false
	 */
	
	
	static void question13(String s) {
		System.out.println(s.matches(".*\\d.*"));
	}
	
	/*
	 * Question 14 (Optional): Replace character Cho một chuỗi str, 
	 * chuyển các ký tự được chỉ định sang một ký tự khác cho trước. 
	 * Ví dụ: "VTI Academy" chuyển ký
	 * tự 'e' sang '*' kết quả " VTI Acad*my"
	 */
	
	static void question14(String s, String oldChar, String newChar) {
		System.out.println(s.replace(oldChar, newChar));
	}
}
