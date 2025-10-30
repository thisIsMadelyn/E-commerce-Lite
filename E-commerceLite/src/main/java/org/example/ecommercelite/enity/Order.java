package org.example.ecommercelite.enity;
/*
*   KEY RELATIONSHIP POINTS
*   1. Order to User : Many to One (Many orders can belong to one user)
*   2. Order -> OrderItem : One to Many (One order can have multiple order items)
*   3. OrderItem -> Product : Many to One (Many order items can refer to one product)
*   4. CascadeType.ALL on orderItems to propagate all operations (persist, remove, etc.) from Order to its OrderItems
*   5. orphanRemoval = true on orderItems to automatically remove OrderItems that are no longer associated with an Order
* */
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total_ammount", nullable = false, precision = 10, scale = 2)
    private BigDecimal total_ammount;

    @Column(nullable = false)
    private String status = "PENDING";  // pending , completed, cancelled

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

//    constructors
    public Order() {}

    public Order(User user, String status, BigDecimal totalAmmount) {
        this.total_ammount = totalAmmount;
        this.user = user;
        this.status = status;

    }

//    Getter and Setter methods
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getStatus() {
        return status;
    }
    public  void setStatus(String status) {
        this.status = status;
    }
    public BigDecimal getTotalAmmount() {
        return total_ammount;
    }
    public void setTotalAmmount(BigDecimal totalAmmount) {
        this.total_ammount = totalAmmount;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
