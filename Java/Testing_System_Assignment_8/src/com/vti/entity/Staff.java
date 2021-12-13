package com.vti.entity;

public class Staff<K, V> extends MyMap<K, V> {

	public Staff(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	public <T> K getID() {
		return super.getKey();
	}

	public <T> V getName() {
		return super.getValue();
	}

}
