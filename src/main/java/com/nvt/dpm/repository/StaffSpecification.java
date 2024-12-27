package com.nvt.dpm.repository;

import org.springframework.data.jpa.domain.Specification;

import com.nvt.dpm.entity.Staff;

public class StaffSpecification {

	 public static Specification<Staff> containsKeyword(String keyword) {
	        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
	                criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), "%" + keyword.toLowerCase() + "%"),
	                criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), "%" + keyword.toLowerCase() + "%")
	        );
	    }
}
