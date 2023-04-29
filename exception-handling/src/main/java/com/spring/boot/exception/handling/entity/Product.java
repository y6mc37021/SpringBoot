package com.spring.boot.exception.handling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@NotBlank(message = "Name value cannot be empty or null")
	private String name;
	@NotBlank(message = "Name value cannot be empty or null")
	private String desc;
	
	public Product() {
		super();
	}

	public Product(Long productId, String name, String desc) {
		super();
		this.productId = productId;
		this.name = name;
		this.desc = desc;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
	
	
	

}
