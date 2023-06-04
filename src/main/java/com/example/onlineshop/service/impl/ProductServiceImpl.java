package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Cart;
import com.example.onlineshop.entity.Category;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.repository.CartRepository;
import com.example.onlineshop.repository.CategoryRepository;
import com.example.onlineshop.repository.ProductRepository;
import com.example.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private  final CategoryRepository categoryRepository;
    private final CartRepository cartRepository;
    @Value("${upload.image.path}")
    private String imageUploadPath;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product, MultipartFile multipartFile, int categoryId) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            product.setImgPath(fileName);
        }
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            product.setCategory(category);
            productRepository.save(product);

        }
    }

    @Override
    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

    @Override
    public Optional<Cart> findById(int id) {
        return cartRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }
}
