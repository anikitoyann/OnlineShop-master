package com.example.onlineshop.service;

import com.example.onlineshop.entity.Orders;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.security.CurrentUser;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {
    List<Orders> findAllOrder();

    void remove(int id);

    @Transactional
    void save(Orders orders);

    boolean save(CurrentUser currentUser, Product productId);
}
