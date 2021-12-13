package com.vti.entity;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	public <T> T getPhoneNumber() {
		return (T) super.getValue();
	}

	public <K> K getKey2() {
		return (K) super.getKey();
	}
}
