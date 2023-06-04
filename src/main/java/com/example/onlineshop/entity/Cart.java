package com.example.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
   private List<Product> productList;
    public void addProduct(Product product){
        if(productList==null){
            productList=new ArrayList<>();
        }
        productList.add(product);
    }
}
