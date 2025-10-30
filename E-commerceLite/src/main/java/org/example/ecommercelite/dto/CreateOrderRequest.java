package org.example.ecommercelite.dto;

// βοηθητικη κλαση για τη δημιουργια παραγγελιας

import java.util.List;

public class CreateOrderRequest {

    private Integer userId;
    private List<OrderItemRequest> items;

//    constructors
    public CreateOrderRequest() {}

    public CreateOrderRequest(Integer userId, List<OrderItemRequest> items) {
        this.userId = userId;
        this.items = items;
    }

    //        getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}