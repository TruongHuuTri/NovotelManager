package com.nvt.dpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nvt.dpm.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff> {

	// Tìm nhân viên theo tên không phân biệt hoa thường
	List<Staff> findByFullNameContainingIgnoreCase(String fullName);

	// Tìm nhân viên theo phòng ban
	List<Staff> findByDepartment(String department);

	// Tìm nhân viên theo trạng thái (ACTIVE/INACTIVE)
	List<Staff> findByStatus(String status);

	// Kiểm tra nhân viên theo số điện thoại (tránh trùng lặp)
	boolean existsByPhone(String phone);

	// Kiểm tra nhân viên theo mã số thuế (tránh trùng lặp)
	boolean existsByCodeTax(String codeTax);
	
	 Staff findByPhone(String phone);

}
