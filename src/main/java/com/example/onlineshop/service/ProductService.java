package com.example.onlineshop.service;

import com.example.onlineshop.entity.Cart;
import com.example.onlineshop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    void save(Product product, MultipartFile multipartFile,int categoryId) throws IOException;

    List<Product> findAllByCategoryId(int id);


    Optional<Cart> findById(int id1);

    void deleteById(int productId);
}
