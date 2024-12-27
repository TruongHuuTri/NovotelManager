package com.nvt.dpm.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "dish_utensil")
public class DishUtensil {

	//id, dish_id, utensil_id, quantity
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "dish_id")
	private int dishId;
	
	@NotNull
	@Column(name = "utensil_id")
	private int utensilId;
	
	//số lượng lớn hơn hoặc bằng 1
	@Min(value = 1)
	@Column(name = "quantity")
	private int quantity;
	
	public DishUtensil() {

	}
	
	public DishUtensil(int dishId, int utensilId, int quantity) {
		this.dishId = dishId;
		this.utensilId = utensilId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getUtensilId() {
		return utensilId;
	}

	public void setUtensilId(int utensilId) {
		this.utensilId = utensilId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
