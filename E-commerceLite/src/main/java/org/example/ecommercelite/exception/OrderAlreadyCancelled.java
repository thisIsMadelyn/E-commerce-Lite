package org.example.ecommercelite.exception;

public class OrderAlreadyCancelled extends RuntimeException {

    public OrderAlreadyCancelled(Integer orderId) {

        super("Order with ID " + orderId + " has already been cancelled.");
    }
}
