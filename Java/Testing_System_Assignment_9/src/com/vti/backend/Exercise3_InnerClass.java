package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;
import com.vti.entity.NgayThangNam;
import com.vti.entity.NgayThangNam.GioPhutGiay;
import com.vti.entity.OuterClass;
import com.vti.entity.OuterClass.InnerClass;

public class Exercise3_InnerClass {
	public void question1() {
		CPU cpu = new CPU(2000);
		cpu.processor = cpu.new Processor(16, "Intel");
		cpu.ram = cpu.new Ram(16, "Kingston");
		System.out.println(cpu.processor.getCache());
		System.out.println(cpu.ram.getClockSpeed());
		cpu.ram.notify();
	}

	public void question2() {
		Car car = new Car("Mazda", "8WD");
		car.engineType = car.new Engine("Crysler");
		System.out.println(car.engineType.getEngineType());

	}

	public void question3() {
		OuterClass outerClass = new OuterClass();
		outerClass.show();
		// chỗ này sẽ in ra Đây là inner class

		InnerClass innerClass = outerClass.new InnerClass();
		innerClass.show();
		// chỗ này sẽ in ra Đây là inner class

	}

	public void question4() {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;
		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 30;
		time.xuatThongTin();
		// dòng đầu tiên sẽ in ra Ngày: 31/10/2017
		// dòng thứ 2 sẽ in ra Giờ: 10:15:30
	}
}
