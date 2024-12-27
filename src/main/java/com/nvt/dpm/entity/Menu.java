package com.nvt.dpm.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;


@Entity
@Table(name = "menus")
public class Menu {

	//id, name_menu, description, image, price, tên món ăn(1 menu có nhiều món ăn)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "name_menu")
	private String nameMenu;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String image;
	
	@NotNull
	private double price;
	
	//lấy tên món ăn lấy từ bảng dish, 1 menu có nhiều món ăn
	@ManyToOne
	@JoinColumn(name = "dish_id")
	private Dish dish;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameMenu() {
		return nameMenu;
	}

	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	
	
	
	
}
