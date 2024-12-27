package com.nvt.dpm.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "dishs")
public class Dish {

	//id, name, description, source
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	@NotBlank(message = "Name không được để trống")
	@Size(max = 50, message = "Name không được vượt quá 50 ký tự")
	private String name;
	
	@Column(name = "description")
	@Size(max = 255, message = "Description không được vượt quá 255 ký tự")
	private String description;
	
	@Column(name = "source")
	@Size(max = 255, message = "Source không được vượt quá 255 ký tự")
	private String source;
	

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	
	
}
