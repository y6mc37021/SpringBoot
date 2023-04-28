package com.spring.boot.exception.handling.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.exception.handling.entity.Products;

public interface ProductRespository extends JpaRepository<Products, Long> {
	
	public Optional<Products> findByProductId(Long productId);
	public List<Products> findByAllProducts();
	public Products findByProductName(String productName);
	public void addProduct(Products product);
	public void deleteProduct(Long productId);

}
