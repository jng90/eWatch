package com.example.ewatch.service;

import com.example.ewatch.model.Product;
import com.example.ewatch.model.ProductCategory;
import com.example.ewatch.model.dto.CreateProductDto;
import com.example.ewatch.model.dto.ProductDto;
import com.example.ewatch.repository.ProductCategoryRepository;
import com.example.ewatch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(product -> {
                    return ProductDto.builder()
                            .categoryName(product.getCategory().getCategoryName())
                            .currentPrice(product.getCurrentPrice())
                            .name(product.getName())
                            .build();
                }).collect(Collectors.toList());
    }

    public void add(CreateProductDto product) {
        // tutaj później znajdzie się ewentualna logika która weryfikuje warunki przed dodaniem (np. czy mogą istnieć 2 produkty o tej samej nazwie)
        log.info("Add: " + product);

        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(product.getCategoryId());
        if(productCategoryOptional.isPresent()) {

            Product productToCreate = Product.builder()
                    .currentPrice(product.getCurrentPrice())
                    .name(product.getName())
                    .category(productCategoryOptional.get())
                    .build();

            productRepository.save(productToCreate);
        }
    }
}
