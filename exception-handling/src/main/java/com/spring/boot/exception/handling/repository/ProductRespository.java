package com.spring.boot.exception.handling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.exception.handling.entity.Product;

//public interface ProductRespository extends JpaRepository<Products, Long> {
public interface ProductRespository extends JpaRepository<Product, Long>{
	
	/*
	public List<Products> findByAllProducts();
	public Products findByProductName(String productName);
	public void deleteProduct(Long productId);*/
	public Optional<Product> findByProductId(Long id);
	public Product save(Product product);

}
