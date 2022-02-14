/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_question")
public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "categoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short categoryID;

	@Column(name = "categoryName", length = 50, nullable = false, unique = true)
	private String categoryName;

	public CategoryQuestion() {
	}

	public short getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(short categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryQuestion [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
	}
}