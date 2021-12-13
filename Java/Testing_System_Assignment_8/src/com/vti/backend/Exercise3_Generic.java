package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Phone;
import com.vti.entity.Staff;
import com.vti.entity.StudentGeneric;

public class Exercise3_Generic {
	public void question1_2() {
		StudentGeneric std1 = new StudentGeneric<Integer>(1, "Nguyễn Văn A");
		StudentGeneric std2 = new StudentGeneric<Float>((float) 2, "Nguyễn Văn B");
		StudentGeneric std3 = new StudentGeneric<Double>((double) 3, "Nguyễn Văn C");
		List<StudentGeneric> studentList = new ArrayList<>();
		studentList.add(std1);
		studentList.add(std2);
		studentList.add(std3);
		System.out.println(studentList);
		print(std1);
		print(4);
		print(4.0);
	}

	public void question4() {
		Integer[] intArr = { 1, 2, 3 };
		Float[] floatArr = { 1f, 2f, 3f };
		Double[] doubleArr = { 1d, 2d, 3d };
		printArr(intArr);
		printArr(floatArr);
		printArr(doubleArr);
	}

	public void question5() {
		Integer[] salaryInt = { 1000, 2000, 3000 };
		Float[] salaryFloat = { (float) 1000, (float) 2000, (float) 3000 };
		Double[] salaryDouble = { (double) 1000, (double) 2000, (double) 3000 };
		Employee epl1 = new Employee<Integer>(1, "Nguyễn Văn A", salaryInt);
		Employee epl2 = new Employee<Float>(2, "Nguyễn Văn B", salaryFloat);
		Employee epl3 = new Employee<Double>(3, "Nguyễn Văn C", salaryDouble);
		System.out.println(epl1);
		System.out.println(epl2);
		System.out.println(epl3);
		System.out.println(epl1.getLastSalary());
		System.out.println(epl2.getLastSalary());
		System.out.println(epl3.getLastSalary());
	}

	public void question6() {
		MyMap<Integer, String> student = new MyMap<Integer, String>(1, "Nguyễn Văn A");
		System.out.println(student);
	}

	public void question7a() {
		Phone<String, Integer> phone = new Phone<String, Integer>("nguyenvana@gmail.com", 123456789);
		System.out.println(phone.getKey2() + " " + phone.getPhoneNumber());
	}

	public void question7b() {
		Phone<Integer, Integer> phone = new Phone<Integer, Integer>(1, 123456789);
		System.out.println(phone.getKey2() + " " + phone.getPhoneNumber());
	}

	public void question7c() {
		Phone<String, Integer> phone = new Phone<String, Integer>("Nguyễn Văn A", 123456789);
		System.out.println(phone.getKey2() + " " + phone.getPhoneNumber());
	}

	public void question8() {
		Staff<Integer, String> staff = new Staff<Integer, String>(1, "Nguyễn Văn A");
		System.out.println(staff.getID() + " " + staff.getName());
	}

	public <T> void printArr(T[] a) {
		for (T t : a) {
			System.out.println(t);
		}
	}

	public <T> void print(T a) {
		System.out.println(a);
	}
}
