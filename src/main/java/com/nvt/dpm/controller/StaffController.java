package com.nvt.dpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nvt.dpm.entity.Staff;
import com.nvt.dpm.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public List<Staff> getAllStaffs() {
		return staffService.getAllStaffs();
	}
	
	@PostMapping
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
		return ResponseEntity.ok(staffService.addStaff(staff));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Staff> updateStaff(@PathVariable int id, @RequestBody Staff staff) {
		try {
			return ResponseEntity.ok(staffService.updateStaff(id, staff));		
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}
	}
	
	@PatchMapping("/{id}/status")
	 public ResponseEntity<Staff> updateStatus(@PathVariable int id, @RequestParam String status) {
        try {
            return ResponseEntity.ok(staffService.updateStatusStaff(id, status));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/search")
	public ResponseEntity<List<Staff>> searchStaff(@RequestParam String keyword) {
		return ResponseEntity.ok(staffService.searchStaff(keyword));
	}
}
