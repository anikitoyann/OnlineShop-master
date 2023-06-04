package com.example.onlineshop.service;


import com.example.onlineshop.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {


    List<Category> findAll();

    List<Category> findAllCategory();

    Optional<Category> findById(int id);
}
