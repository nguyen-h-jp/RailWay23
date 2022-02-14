package com.vti.entity;

/*Table 6: TypeQuestion
 TypeID: định danh của loại câu hỏi (auto increment)
 TypeName: tên của loại câu hỏi (Essay, Multiple-Choice)*/

public class TypeQuestion {
	private int typeID;
	private String typeName;
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
