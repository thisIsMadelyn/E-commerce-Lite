package org.example.ecommercelite.repository;

import org.example.ecommercelite.enity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
