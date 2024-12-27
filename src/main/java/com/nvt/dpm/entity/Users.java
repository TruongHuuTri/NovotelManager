package com.nvt.dpm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "users")
public class Users {

    /* User (người dùng): id, username, password, fullName, role */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    @NotBlank(message = "Username không được để trống")
    @Size(min = 5, max = 20, message = "Username phải có độ dài từ 5 đến 20 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username chỉ được chứa chữ cái và số, không có dấu và không có ký tự đặc biệt")
    private String username;


    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password không được để trống")
    @Size(min = 8, message = "Password phải có ít nhất 8 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+=-{}\\[\\]:;\"'|,.<>?/]+$", 
             message = "Password chỉ được chứa chữ cái, số và các ký tự đặc biệt hợp lệ")
    private String password;


    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "Full name không được để trống")
    @Size(max = 50, message = "Full name không được vượt quá 50 ký tự")
    private String fullName;

    @Column(name = "role", nullable = false)
    @NotBlank(message = "Role không được để trống")
    @Pattern(regexp = "ADMIN|STAFF", message = "Role chỉ có thể là ADMIN hoặc STAFF")
    private String role;

    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

    // Getters and Setters
    
    
}
