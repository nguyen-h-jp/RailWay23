package com.vti.entity;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class VietnamesePhone extends Phone {

	private Contact[] contactArr;

	public VietnamesePhone() {
		contactArr = new Contact[] {};
	}

	@Override
	public void insertContact(String name, String phone) {
		// TODO Auto-generated method stub
		Contact contact = new Contact(name, phone);
		contactArr = Arrays.copyOf(contactArr, contactArr.length + 1);
		contactArr[contactArr.length - 1] = contact;
	}

	@Override
	public void removeContact(String name) {
		// TODO Auto-generated method stub
		int index = 0;
		int[] indexArr = new int[] {};
		if (contactArr.length > 0) {
			for (Contact contact : contactArr) {
				if (contact.getName().equals(name)) {
					indexArr = ArrayUtils.add(indexArr, index);
				}
				index++;
			}
			// xoa
			if (indexArr.length > 0) {
				contactArr = ArrayUtils.removeAll(contactArr, indexArr);
			}
		}
	}

	@Override
	public void updateContact(String name, String newPhone) {
		// TODO Auto-generated method stub
		int index = 0;
		int[] indexArr = new int[] {};
		if (contactArr.length > 0) {
			Contact[] contactArr2 = new Contact[] {};
			for (Contact contact : contactArr) {
				if (contact.getName().equals(name)) {
					Contact newContact = new Contact(name, newPhone);
					contactArr2 = ArrayUtils.add(contactArr2, newContact);
					indexArr = ArrayUtils.add(indexArr, index);
				}
				index++;
			}
			// xoa
			if (indexArr.length > 0) {
				contactArr = ArrayUtils.removeAll(contactArr, indexArr);
				contactArr = ArrayUtils.addAll(contactArr, contactArr2);
			}
		}
	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub
		if (contactArr.length > 0) {
			for (Contact contact : contactArr) {
				if (contact.getName().equals(name)) {
					System.out.println(contact);
				}
			}

		}
	}

	public void printContact() {
		for (Contact contact : contactArr) {
			System.out.println(contact);
		}
	}

}
