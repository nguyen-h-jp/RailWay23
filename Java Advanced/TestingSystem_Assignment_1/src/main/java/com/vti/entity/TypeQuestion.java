package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_question")
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "typeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short typeID;

	@Column(name = "typeName", nullable = false)
	@Convert(converter = TypeQuestionNameConverter.class)
	private TypeQuestionName typeName;

	public TypeQuestion() {
	}



	public short getTypeID() {
		return typeID;
	}



	public void setTypeID(short typeID) {
		this.typeID = typeID;
	}



	public TypeQuestionName getTypeName() {
		return typeName;
	}



	public void setTypeName(TypeQuestionName typeName) {
		this.typeName = typeName;
	}



	public enum TypeQuestionName {
		MULTIPLE_CHOICE("0"), ESSAY("1");

		private String typeQuestionName;

		private TypeQuestionName(String typeQuestionName) {
			this.typeQuestionName = typeQuestionName;
		}

		public String getTypeQuestionName() {
			return typeQuestionName;
		}

		public static TypeQuestionName toEnum(String sqlTypeQuestionName) {
			for (TypeQuestionName item : TypeQuestionName.values()) {
				if (item.getTypeQuestionName().equals(sqlTypeQuestionName)) {
					return item;
				}
			}
			return null;
		}
	}
}
