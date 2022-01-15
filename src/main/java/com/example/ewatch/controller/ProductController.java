package com.example.ewatch.controller;

import com.example.ewatch.model.Product;
import com.example.ewatch.model.dto.CreateProductCategoryDto;
import com.example.ewatch.model.dto.CreateProductDto;
import com.example.ewatch.model.dto.ProductDto;
import com.example.ewatch.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Controller -> używa -> Service -> Repository

    @GetMapping("")
    public List<ProductDto> getAll(){
        return productService.findAll();
    }

    @PostMapping("")
    public void add(@RequestBody CreateProductDto product){
        productService.add(product);
    }
}
