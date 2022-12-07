
package com.app.gestionProjectBackend.Utils;

import java.util.ArrayList;

import com.app.ecommerce.dto.ProductSubCategoryDto;

public class ProductResponseData {

	private Boolean status;
	private ProductSubCategoryDto data;
	private String message;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public ProductSubCategoryDto getData() {
		return data;
	}
	public void setData(ProductSubCategoryDto data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}