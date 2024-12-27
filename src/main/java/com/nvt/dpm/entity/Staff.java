package com.nvt.dpm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "staffs")
public class Staff {

	/*
	 * Staff (nhân sự): id, fullName, position,department(FO,F&B, HR, HK, KT, TECH, SALE), birthday, address, phone, codeTax,
	 * startDate, status
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "full_name", nullable = false)
	@NotBlank(message = "Full name không được để trống")
	@Size(max = 50, message = "Full name không được vượt quá 50 ký tự")
	private String fullName;

	@Column(name = "position", nullable = false)
	@NotBlank(message = "Position không được để trống")
	private String position;
	
	@Column(name = "department", nullable = false)
	@NotBlank(message = "Department không được để trống")
	@Pattern(regexp = "FO|F&B|HR|HK|KT|TECH|SALE", message = "Department chỉ có thể là FO, F&B, HR, HK, KT, TECH, SALE")
	private String department;

	@Column(name = "birthday")
	@Past(message = "Birthday phải là ngày trong quá khứ")
	private LocalDate birthday;

	@Column(name = "address")
	@Size(max = 100, message = "Address không được vượt quá 100 ký tự")
	private String address;

	@Column(name = "phone", nullable = false, unique = true)
	@NotBlank(message = "Phone không được để trống")
	@Pattern(regexp = "\\d{10}", message = "Phone phải là số có  10  chữ số")
	private String phone;

	@Column(name = "code_tax", unique = true)
	@Size(max = 20, message = "CodeTax không được vượt quá 20 ký tự")
	private String codeTax;

	@Column(name = "start_date", nullable = false)
	@NotNull(message = "Start date không được để trống")
	@PastOrPresent(message = "Start date phải là ngày hiện tại hoặc trong quá khứ")
	private LocalDate startDate;

	@Column(name = "status", nullable = false)
	@NotBlank(message = "Status không được để trống")
	@Pattern(regexp = "ACTIVE|INACTIVE", message = "Status chỉ có thể là ACTIVE hoặc INACTIVE")
	private String status;

	// 1 staff chỉ thuộc về 1 user
	@OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
	private Users user;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCodeTax() {
		return codeTax;
	}

	public void setCodeTax(String codeTax) {
		this.codeTax = codeTax;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
