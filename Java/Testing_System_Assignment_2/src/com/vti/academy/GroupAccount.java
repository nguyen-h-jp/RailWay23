package com.vti.academy;
import java.time.LocalDate;

/*Table 5: GroupAccount
 GroupID: định danh của nhóm
 AccountID: định danh của User
 JoinDate: Ngày user tham gia vào nhóm*/

public class GroupAccount {
	Group group;
	Account account;
	LocalDate joinDate;
}
