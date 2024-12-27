package com.nvt.dpm.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "utensils")
public class Utensil {

	//id, name, type(enum)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	@NotBlank(message = "Name không được để trống")
	@Size(max = 50, message = "Name không được vượt quá 50 ký tự")
	private String name;
	
	@Column(name = "type", nullable = false)
	@NotBlank(message = "Type không được để trống")
	@Pattern(regexp = "Individual|Share", message = "Type chỉ có thể là Individual or Share")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
