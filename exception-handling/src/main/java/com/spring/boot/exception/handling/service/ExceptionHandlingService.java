package com.spring.boot.exception.handling.service;

import org.springframework.stereotype.Service;

import com.spring.boot.exception.handling.entity.Product;
import com.spring.boot.exception.handling.repository.ProductRespository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExceptionHandlingService {
	
	ProductRespository repository;
	
	
	public ExceptionHandlingService(ProductRespository repository) {
		this.repository = repository;
	}
	
	/*public List<Products> fetchAllProduct() {
		return repository.findByAllProducts();
	}
	
	public Products fetchProductByName(@Valid @PathVariable @NotBlank String name) {
		return repository.findByProductName(name);
	}
	
	public Products deleteProduct(@Valid @PathVariable @NotBlank Long id) {
		repository.deleteProduct(id);
		return null;
	}*/
	
	public Product getProductById(Long id) {
	
	//Optional<Products> product = return repository.findByProductId(id);
	//Products product = repository.findById(id).orElse(new product()); -->way-1
	//Products product = repository.findById(id).orElse(null); -->way-2
	return repository.findByProductId(id)
	        .orElseThrow(() -> new EntityNotFoundException());
}
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
	
	

}
