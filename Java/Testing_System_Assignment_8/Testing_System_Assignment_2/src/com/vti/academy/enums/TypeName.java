package com.vti.academy.enums;

public enum TypeName {
	ESSAY("Essay"), 
	MULTIPLE_CHOICE("Multiple_Choice");

	private String typeName;

	TypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
}