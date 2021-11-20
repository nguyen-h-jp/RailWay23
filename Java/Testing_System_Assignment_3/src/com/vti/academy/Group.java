package com.vti.academy;
import java.time.LocalDate;

/*Table 4: Group
 GroupID: định danh của nhóm (auto increment)
 GroupName: tên nhóm
 CreatorID: id của người tạo group
 CreateDate: ngày tạo group*/

public class Group {
	int groupID;
	String groupName;
	Account creator;
	LocalDate createDate;
	Account[] accounts;
	
	// account1, 2 ,3
}
