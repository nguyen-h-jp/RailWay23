package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.TypeQuestion.TypeQuestionName;



@Converter(autoApply = true)
public class TypeQuestionNameConverter implements AttributeConverter<TypeQuestion.TypeQuestionName, String> {

	public String convertToDatabaseColumn(TypeQuestionName typeQuestionName) {
		if (typeQuestionName == null) {
			return null;
		}
		return typeQuestionName.getTypeQuestionName();
	}

	public TypeQuestionName convertToEntityAttribute(String sqlTypeQuestionName) {
		if (sqlTypeQuestionName == null) {
			return null;
		}
		return TypeQuestion.TypeQuestionName.toEnum(sqlTypeQuestionName);
	}

}