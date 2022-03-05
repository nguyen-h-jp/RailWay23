/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Description: 
 */
@Embeddable
public class GroupAccountKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "group_id", nullable = false)
	private int groupID;
	
	@Column(name = "account_id", nullable = false)
	private int accountID;
}
