package com.vti.entity.enums;

public enum PositionName {
	DEV("Dev"), TEST("Test"), SCRUM_MASTER("Scrum Master"), PM("PM");

	private String positionName;

	PositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionName() {
		return positionName;
	}

	public static PositionName fromString(String positionName) {
		for (PositionName key : PositionName.values()) {
			if (key.positionName.equalsIgnoreCase(positionName)) {
				return key;
			}
		}
		return null;
	}
}
