package com.spring.boot.exception.handling.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Products> fetchAllProduct() {
		return repository.findByAllProducts();
	}
	
	public Optional<Products> fetchProductById(@Valid @PathVariable @NotBlank Long id) {
		
		return repository.findByProductId(id);
	}
	
	public Products fetchProductByName(@Valid @PathVariable @NotBlank String name) {
		return repository.findByProductName(name);
	}
	
	public void addProduct(@RequestBody Products product) {
		repository.addProduct(product);
	}
	
	public Products deleteProduct(@Valid @PathVariable @NotBlank Long id) {
		repository.deleteProduct(id);
		return null;
	}
	
	
	

}
