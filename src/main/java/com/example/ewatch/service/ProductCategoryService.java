package com.example.ewatch.service;

import com.example.ewatch.model.ProductCategory;
import com.example.ewatch.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }


    public void add(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }
}
