/**
 * Description: 
 */
package com.vti.backend.presentationlayer;

import java.util.List;

import com.vti.backend.businesslayer.GroupService;
import com.vti.backend.businesslayer.interfaces.IGroupService;
import com.vti.entity.Group;

/**
 * Description:
 */
public class GroupController {
	IGroupService groupService = new GroupService();

	public List<Group> getGroupListByAccountID(int accountID)  {
		try {
			return groupService.getGroupListByAccountID(accountID);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
}
