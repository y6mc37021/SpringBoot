package com.spring.boot.exception.handling.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.exception.handling.entity.Products;
import com.spring.boot.exception.handling.repository.ProductRespository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Service
public class ExceptionHandlingService {
	
	ProductRespository repository;
	
	
	public ExceptionHandlingService(ProductRespository repository) {
		this.repository = repository;
	}
	
	public Products fetchAllProduct() {
		repository.findByAllProducts();
		return null;
	}
	
	public Products fetchProductById(@Valid @PathVariable @NotBlank Long id) {
		repository.findByProductId(id);
		return null;
	}
	
	public Products fetchProductByName(@Valid @PathVariable @NotBlank String name) {
		repository.findByProductName(name);
		return null;
	}
	
	public void addProduct(@RequestBody Products product) {
		repository.addProduct(product);
	}
	
	public Products deleteProduct(@Valid @PathVariable @NotBlank Long id) {
		repository.deleteProduct(id);
		return null;
	}
	
	
	

}
