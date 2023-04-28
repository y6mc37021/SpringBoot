package com.spring.boot.exception.handling.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.spring.boot.exception.handling.service.ExceptionHandlingService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/product")
public class ExceptionHandlingController {
	
	final static Logger log = LoggerFactory.getLogger(ExceptionHandlingController.class);
	
	ExceptionHandlingService service;
	
	public ExceptionHandlingController(ExceptionHandlingService service) {
		this.service = service;
	}
	
	
	@GetMapping("/{id}")
	public Products fetchProductById(@Valid @PathVariable @NotBlank Long id) {
		return service.fetchProductById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse addProduct(@RequestBody Products product) {
		log.info("Request to add product {}",product);
		try {
			service.addProduct(product);
			return  new ProductResponse("500",null , ProductResponse.ResponseResult.CREATED);
			
		}catch(Throwable t) {
			log.error("Error While Adding Product {}", product);
			return new ProductResponse("500",t.getLocalizedMessage(), ProductResponse.ResponseResult.FAILED);
		}
	}
	/*
	@GetMapping("/")
	public List<Products> fetchAllProduct() {
		return service.fetchAllProduct();
	}
	
	@GetMapping("/{name}")
	public Products fetchProductByName(@Valid @PathVariable @NotBlank String name) {
		return service.fetchProductByName(name);
	}
	
	@GetMapping("/{id}")
	public Products deleteProduct(@Valid @PathVariable @NotBlank Long id) {
		service.deleteProduct(id);
		return null;
	}
	
	*/

}
