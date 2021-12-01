package com.vti.backend;

import java.util.Arrays;
import java.util.Scanner;

import com.vti.entity.News;

public class Exercise1_Abstraction {

	private News[] newsArr;

	public Exercise1_Abstraction() {
		newsArr = new News[] {};
	}

	public void question1(Scanner sc) {
		while (true) {
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			int num = 0;
			boolean isOk = false;
			do {
				System.out.println("Nhập vào chức năng muốn sử dụng, từ 1 - 4");
				num = sc.nextInt();
				if (num >= 5 || num == 0) {
					System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại!");
				} else {
					isOk = true;
				}
			} while (isOk == false);

			switch (num) {
			case 1:
				insertNews(sc);
				break;
			case 2:
				for (News news : newsArr) {
					news.display();
				}
				break;
			case 3:
				for (News news : newsArr) {
					news.calculate();
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Số nhập vào không hợp lệ, vui lòng nhập lại");
			}
		}
	}

	private void insertNews(Scanner sc) {
		sc.nextLine();
		System.out.println("Nhập vào title");
		String title = sc.nextLine();
		System.out.println("Nhập vào publish date theo dạng dd-MM-yyyy");
		String publishDate = sc.nextLine();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		String publishDate = formatter.format(pattern);
		System.out.println("Nhập vào author");
		String author = sc.nextLine();
		System.out.println("Nhập vào content");
		String content = sc.nextLine();
		boolean isOk = false;
		float arr[] = { 0, 0, 0 };
		do {
			System.out.println("Nhập vào 3 điểm đánh giá rate1, rate2, rate3 cách nhau bởi dấu cách");
			float rate1 = sc.nextFloat();
			float rate2 = sc.nextFloat();
			float rate3 = sc.nextFloat();
			arr[0] = rate1;
			arr[1] = rate2;
			arr[2] = rate3;
			if (arr.length != 3) {
				System.out.println("Số đánh giá nhập vào không đủ, vui lòng nhập lại");
			} else {
				isOk = true;
			}
		} while (isOk == false);
		News new1 = new News(title, publishDate, author, content, arr);
		newsArr = Arrays.copyOf(newsArr, newsArr.length + 1);
		newsArr[newsArr.length - 1] = new1;
		new1.display();
	}

}
