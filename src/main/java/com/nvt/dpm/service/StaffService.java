package com.nvt.dpm.service;

import java.util.List;

import com.nvt.dpm.entity.Staff;

public interface StaffService {
	
	List<Staff> getAllStaffs();
	Staff addStaff(Staff staff);
	Staff updateStaff(int id,Staff staff);
	Staff updateStatusStaff(int id, String status);
	List<Staff> searchStaff(String keyword);

}
