package com.vti.entity;

public class StudentGeneric<T> {
	T id;
	String name;

	public StudentGeneric(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentGeneric [id=" + id + ", name=" + name + "]";
	}
}
