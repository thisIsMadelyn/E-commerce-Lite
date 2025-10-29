package org.example.ecommercelite.dto;

public class OrderItemRequest {

    private Integer productId;
    private Integer quantity;

//    constructors
    public OrderItemRequest() {}

    public OrderItemRequest(Integer productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

//    getters and setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
