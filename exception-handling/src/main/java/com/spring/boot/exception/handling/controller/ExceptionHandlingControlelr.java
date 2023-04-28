package com.spring.boot.exception.handling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.exception.handling.entity.Products;
import com.spring.boot.exception.handling.entity.response.ProductResponse;
import com.spring.boot.exception.handling.repository.ProductRespository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/product")
public class ExceptionHandlingControlelr {
	
	final static Logger log = LoggerFactory.getLogger(ExceptionHandlingControlelr.class);
	
	@Autowired
	ProductRespository repository;
	
	@GetMapping("/")
	public Products fetchAllProduct() {
		repository.findByAllProducts();
		return null;
	}
	
	@GetMapping("/{id}")
	public Products fetchProductById(@Valid @PathVariable @NotBlank Long id) {
		repository.findByProductId(id);
		return null;
	}
	
	@GetMapping("/{name}")
	public Products fetchProductByName(@Valid @PathVariable @NotBlank String name) {
		repository.findByProductName(name);
		return null;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse addProduct(@RequestBody Products product) {
		log.info("Request to add product {}",product);
		try {
			repository.addProduct(product);
			return  new ProductResponse("500",null , ProductResponse.ResponseResult.CREATED);
			
		}catch(Throwable t) {
			log.error("Error While Adding Product {}", product);
			return new ProductResponse("500",t.getLocalizedMessage(), ProductResponse.ResponseResult.FAILED);
		}
	}
	
	@GetMapping("/")
	public Products deleteProduct(@Valid @PathVariable @NotBlank Long id) {
		repository.deleteProduct(id);
		return null;
	}
	
	

}
