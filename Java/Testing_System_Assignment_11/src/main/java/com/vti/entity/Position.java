package com.vti.entity;

import com.vti.entity.enums.PositionName;

/*Table 2: Position
 PositionID: định danh của chức vụ (auto increment)
 PositionName: tên chức vụ (Dev, Test, Scrum Master, PM)*/

public class Position {
	int positionID;
	PositionName positionName;

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public Position(int positionID, PositionName positionName) {
		super();
		this.positionID = positionID;
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [positionID=" + positionID + ", positionName=" + positionName + "]";
	}
}
