package org.example.ecommercelite.exception;

public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(String productName,
                                      Integer requiredStock, Integer availableStock) {

        super("Insufficient stock for product: " + productName +
              ". Required: " + requiredStock +
              ", Available: " + availableStock);
    }
}
