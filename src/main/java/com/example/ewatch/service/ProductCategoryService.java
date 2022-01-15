package com.example.ewatch.service;

import com.example.ewatch.model.ProductCategory;
import com.example.ewatch.model.dto.CreateProductCategoryDto;
import com.example.ewatch.model.dto.ProductCategoryDto;
import com.example.ewatch.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategoryDto> findAll() {
        return productCategoryRepository.findAll().stream()
                .map(productCategory-> {
                    return ProductCategoryDto.builder()
                            .categoryName(productCategory.getCategoryName())
                            .build();
                }).collect(Collectors.toList());
    }


    public void add(CreateProductCategoryDto productCategory) {
        log.info("Add: " + productCategory);

//        ProductCategory productCategoryToCreate = new ProductCategory(null, productCategory.getCategoryName(), new HashSet<>());
        ProductCategory productCategoryToCreate = ProductCategory.builder()
                        .categoryName(productCategory.getCategoryName())
                        .build();


        productCategoryRepository.save(productCategoryToCreate);
    }
}
