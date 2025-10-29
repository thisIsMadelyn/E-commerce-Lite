package org.example.ecommercelite.repository;

import org.example.ecommercelite.enity.Order;
import org.example.ecommercelite.enity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

//    find all orders by a specific user
    List<Order> findByUser(User user);

//    find all orders with a specific status
    List<Order> findByStatus(String status);

//    find orders by id
    List<Order> findByUserId(Integer userId);
}
