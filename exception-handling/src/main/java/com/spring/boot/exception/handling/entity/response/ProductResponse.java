package com.spring.boot.exception.handling.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductResponse {
	
    private String httpsResponseCode;
    private String errorMessage;
    
    @JsonProperty("Response")
    private ResponseResult response;
    
    public static enum ResponseResult {
  	  CREATED,
  	  FAILED
  	}

	public ProductResponse(String statusCode, String errorMessage, ResponseResult response) {
		super();
		this.httpsResponseCode = statusCode;
		this.errorMessage = errorMessage;
		this.response = response;
	}

	public ProductResponse() {
		super();
	}
	
	
    
    
    
}
