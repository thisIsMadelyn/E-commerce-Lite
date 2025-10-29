package org.example.ecommercelite.service;

import org.example.ecommercelite.dto.OrderItemRequest;
import org.example.ecommercelite.enity.*;
import org.example.ecommercelite.repository.OrderRepository;
import org.example.ecommercelite.repository.OrderItemRepository;
import org.example.ecommercelite.repository.ProductRepository;
import org.example.ecommercelite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByUser(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

//    The main order creation mehod with buisiness logic
    public Order createOrder(Integer userId, List<OrderItemRequest> ItemRequests) {

//        1. Find user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

//        2. Create order
        Order order = new Order();
        order.setUser(user);
        order.setStatus("PENDING");

//        3. Process order item and calculate total
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItemRequest ItemRequest : ItemRequests) {
            Product product = productRepository.findById(Math.toIntExact(ItemRequest.getProductId()))
                    .orElseThrow(() -> new RuntimeException("Product not found: " + ItemRequest.getProductId()));

//            check stock availability
            if (product.getStockQuantity() < ItemRequest.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

//            calculate item total
            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(ItemRequest.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);

//            create order item
            OrderItem orderItem1 = new OrderItem();
            orderItem1.setProduct(product);
            orderItem1.setQuantity(ItemRequest.getQuantity());
            orderItem1.setPrice(product.getPrice());
            orderItem1.setOrder(order);

            orderItemList.add(orderItem1);

//            Update product stock
            product.setStockQuantity(product.getStockQuantity() - ItemRequest.getQuantity());
        }

//        4.Set total and save order
        order.setTotalAmmount(totalAmount);
        order.setOrderItems(orderItemList);

        Order savedOrder = orderRepository.save(order);

//        5. Save all order items
        orderItemRepository.saveAll(orderItemList);

        return savedOrder;
    }

    public void cancelOrder(Integer orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if("CANCELLED".equals(order.getStatus())) {
            throw new RuntimeException("Order is already cancelled");
        }

//        Restore product stock
        for(OrderItem item : order.getOrderItems()) {
            Product product = item.getProduct();
            product.setStockQuantity(product.getStockQuantity() + item.getQuantity());
        }

        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }
}
