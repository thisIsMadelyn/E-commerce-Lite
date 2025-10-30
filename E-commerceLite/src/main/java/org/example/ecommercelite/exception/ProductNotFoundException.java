package org.example.ecommercelite.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Integer productId) {

        super("Product with ID " + productId + " not found.");
    }
}
