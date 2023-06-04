package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Orders;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.repository.OrdersRepository;
import com.example.onlineshop.security.CurrentUser;
import com.example.onlineshop.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrdersRepository orderRepository;


    @Override
    public List<Orders> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void remove(int id) {
        orderRepository.deleteById(id);
    }


    @Transactional
    @Override
    public void save(Orders order) {
    orderRepository.save(order);

}

    @Override
    public boolean save(CurrentUser currentUser, Product productId) {
        Orders orders = new Orders();
        orders.setUser(currentUser.getUser());
        orders.addProduct(productId);
        orderRepository.save(orders);
        return false;
    }
}