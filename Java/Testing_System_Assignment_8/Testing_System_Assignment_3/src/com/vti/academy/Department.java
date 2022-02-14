package com.vti.academy;

import java.util.Objects;

/*Table 1:Department
 DepartmentID: định danh của phòng ban (auto increment)
 DepartmentName: tên đầy đủ của phòng ban (VD: sale, marketing, …)
*/

public class Department {
	int departmentID;
	String departmentName;

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentID, departmentName);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Department other = (Department) obj;
//		return departmentID == other.departmentID && Objects.equals(departmentName, other.departmentName);
//	}

}
