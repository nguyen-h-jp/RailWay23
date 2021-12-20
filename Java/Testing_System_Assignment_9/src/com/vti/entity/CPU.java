package com.vti.entity;

public class CPU {
	private int price;
	public Processor processor;
	public Ram ram;

	public CPU(int price) {
		super();
		this.price = price;
	}

	@Override
	public String toString() {
		return "CPU [price=" + price + ", processor=" + processor + ", ram=" + ram + "]";
	}

	public class Processor {
		private int coreAmount;
		private String manufacturer;

		public Processor(int coreAmount, String manufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.manufacturer = manufacturer;
		}

		public Double getCache() {
			return 4.3;
		}

		@Override
		public String toString() {
			return "Processor [coreAmount=" + coreAmount + ", manufacturer=" + manufacturer + "]";
		}
	}

	public class Ram {
		private int memory;
		private String manufacturer;

		public Ram(int memory, String manufacturer) {
			super();
			this.memory = memory;
			this.manufacturer = manufacturer;
		}

		public Double getClockSpeed() {
			return 5.5;
		}

		@Override
		public String toString() {
			return "Ram [memory=" + memory + ", manufacturer=" + manufacturer + "]";
		}
	}
}
