/**
 * Description: 
 */
package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountID;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "first_name", length = 50, nullable = false, unique = true)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false, unique = true)
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "position_id", referencedColumnName = "position_id")
	private Position position;

	@ManyToOne
	@JoinColumn(name = "salary_id", referencedColumnName = "salary_id")
	private Salary salary;

	@OneToOne(mappedBy = "account")
	private Manager manager;
//	
	@OneToOne(mappedBy = "account")
	private Employee employee;
//
	@OneToMany(mappedBy = "account")
	private List<Group> groups;
//	
	@OneToMany(mappedBy = "account")
	private List<GroupAccount> groupAccounts;
//	
//	@OneToMany(mappedBy = "account")
//	private List<Exam> exams;

	public Account() {
	}

	public short getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

//
//
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
//
//
	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
//
//
	public List<GroupAccount> getGroupAccounts() {
		return groupAccounts;
	}


	public void setGroupAccounts(List<GroupAccount> groupAccounts) {
		this.groupAccounts = groupAccounts;
	}
//
//
//	public List<Exam> getExams() {
//		return exams;
//	}
//
//
//	public void setExams(List<Exam> exams) {
//		this.exams = exams;
//	}
//

//	@Override
//	public String toString() {
//		return "Account [accountID=" + accountID + ", email=" + email + ", username=" + username + ", firstName="
//				+ firstName + ", lastName=" + lastName + ", createDate=" + createDate + ", department=" + department
//				+ ", position=" + position + ", salary=" + salary + ", manager=" + manager + ", employee=" + employee
//				+ ", groups=" + groups + "]";
//	}

	@Override
	public String toString() {
		String managementNumberOfYear = manager != null ? String.valueOf(manager.getManagementNumberOfYear())
				: "Unknown";

		String workingNumberOfYear = employee != null ? String.valueOf(employee.getWorkingNumberOfYear()) : "Unknown";
		return "Account [accountID=" + accountID + ", email=" + email + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", createDate=" + createDate + ", department="
				+ department.getDepartmentName() + ", position=" + position.getPositionName() + ", salary="
				+ salary.getSalaryName() + ", employeeWorkingNumberOfYear=" + workingNumberOfYear
				+ ",managementNumberOfYear=" + managementNumberOfYear + ", groups=" + groups +  "]";
	}
	
	

}