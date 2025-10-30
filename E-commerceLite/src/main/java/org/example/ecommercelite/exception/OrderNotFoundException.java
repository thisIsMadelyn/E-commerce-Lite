package org.example.ecommercelite.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Integer orderId) {

        super("Order with ID " + orderId + " not found.");

    }
}
