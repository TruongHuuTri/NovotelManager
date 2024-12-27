package com.nvt.dpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nvt.dpm.entity.Staff;
import com.nvt.dpm.repository.StaffRepository;
import com.nvt.dpm.repository.StaffSpecification;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}

	@Override
	public Staff addStaff(Staff staff) {
		// TODO Auto-generated method stub
		if (staffRepository.existsByPhone(staff.getPhone())) {
			throw new RuntimeException("Phone đã tồn tại");
		}
		if (staff.getCodeTax() != null && staffRepository.existsByCodeTax(staff.getCodeTax())) {
			throw new RuntimeException("CodeTax đã tồn tại");
		}
		return staffRepository.save(staff);
	}

	@Override
	public Staff updateStaff(int id, Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.findById(id).map(s -> {
			s.setFullName(staff.getFullName());
			s.setPosition(staff.getPosition());
			s.setDepartment(staff.getDepartment());
			s.setBirthday(staff.getBirthday());
			s.setAddress(staff.getAddress());
			s.setPhone(staff.getPhone());
			s.setCodeTax(staff.getCodeTax());
			s.setStartDate(staff.getStartDate());
			s.setStatus(staff.getStatus());
			return staffRepository.save(s);
		}).orElseThrow(() -> new RuntimeException("Staff không tồn tại"));
	}

	@Override
	public Staff updateStatusStaff(int id, String status) {
		// TODO Auto-generated method stub
		return staffRepository.findById(id).map(s -> {
            s.setStatus(status);
            return staffRepository.save(s);
        }).orElseThrow(() -> new RuntimeException("Staff không tồn tại "));
	}

	@Override
	public List<Staff> searchStaff(String keyword) {
		// TODO Auto-generated method stub
		Specification<Staff> spec = StaffSpecification.containsKeyword(keyword);		
		return staffRepository.findAll(spec);
	}

}
