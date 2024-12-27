package com.nvt.dpm.service;

import com.nvt.dpm.entity.Users;

public interface UserService {

	Users registerUser(Users user);

	Users findUserByUsername(String username);
	
	boolean isStaffRegistered(int staffId);
	
	boolean isPhoneRegistered(String phoneNumber);

}
