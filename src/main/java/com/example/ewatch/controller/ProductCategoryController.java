package com.example.ewatch.controller;

import com.example.ewatch.model.ProductCategory;
import com.example.ewatch.model.dto.CreateProductCategoryDto;
import com.example.ewatch.model.dto.ProductCategoryDto;
import com.example.ewatch.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @GetMapping("")
    public List<ProductCategoryDto> getAll(){
        return productCategoryService.findAll();
    }

    @PostMapping("")
    public void add(@RequestBody CreateProductCategoryDto productCategory){
        productCategoryService.add(productCategory);
    }
}
