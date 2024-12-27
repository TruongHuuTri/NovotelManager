package com.nvt.dpm.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "shifts")
public class Shift {

	//ShiftRegistration: id, AccountId, WeekStartDate, WeekDay, ShiftCode, RegistrationDate, Notes.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//accountId là id của staff
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Staff staff;
	
	//ngày từ hiện tại đến tưongw lai
	@Column(name = "week_start_date", nullable = false)
	@NotNull(message = "Week start date không được để trống")
	@Future(message = "Week start date phải là ngày trong tương"
			+ " lai")
	private LocalDate weekStartDate;
	
	//Thứ trong tuần
	@Column(name = "week_day", nullable = false)
	@NotBlank(message = "Week day không được để trống")
	@Pattern(regexp = "MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY", message = "Week day chỉ có thể là MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY hoặc SUNDAY")
	private String weekDay;
	
	//Mã ca làm việc
	@Column(name = "shift_code", nullable = false)
	@NotBlank(message = "Shift code không được để trống")
	@Pattern(regexp = "AM|PM|FULLDATE|OFF", message = "Shift code chỉ có thể là AM|PM|FULLDATE|OFF")
	private String shiftCode;
	
	//Ngày đăng ký
	@Column(name = "registration_date", nullable = false)
	@NotNull(message = "Registration date không được để trống")
	@PastOrPresent(message = "Registration date phải là ngày hiện tại hoặc trong quá khứ")
	private LocalDate registrationDate;
	
	//Ghi chú
	@Column(name = "notes")
	@Size(max = 255, message = "Notes không được vượt quá 255 ký tự")
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public LocalDate getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(LocalDate weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getShiftCode() {
		return shiftCode;
	}

	public void setShiftCode(String shiftCode) {
		this.shiftCode = shiftCode;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
		
}
