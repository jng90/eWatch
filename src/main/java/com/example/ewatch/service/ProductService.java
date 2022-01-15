package com.example.ewatch.service;

import com.example.ewatch.model.Product;
import com.example.ewatch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        // tutaj później znajdzie się ewentualna logika która weryfikuje warunki przed dodaniem (np. czy mogą istnieć 2 produkty o tej samej nazwie)
        log.info("Add: " + product);
        productRepository.save(product);
    }
}
