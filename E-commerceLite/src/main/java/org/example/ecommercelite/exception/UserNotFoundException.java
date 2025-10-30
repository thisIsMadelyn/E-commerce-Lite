package org.example.ecommercelite.exception;

//  κανω ξεχωριστες κλασεις επειδη
//  οι εξεραισεις ειναι πολυ γενικευμενες

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer userId) {

        super("User with ID " + userId + " not found.");
    }
}
