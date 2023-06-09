package com.example.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> productList;
    public void addProduct(Product product){
        if(productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
    }
}
