package com.practice.sunday.response;

import com.practice.sunday.mysql.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ProductResponse {
    private List<Product> products;
    private String message;
    private HttpStatus httpStatus;

    public ProductResponse(List<Product> products, String message, HttpStatus httpStatus) {
        this.products = products;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
