package com.example.ewatch.service;

import com.example.ewatch.model.Product;
import com.example.ewatch.model.ProductCategory;
import com.example.ewatch.model.Receipt;
import com.example.ewatch.model.ReceiptEntry;
import com.example.ewatch.model.dto.CreateReceiptEntryDto;
import com.example.ewatch.model.dto.ReceiptEntryDto;
import com.example.ewatch.repository.ProductRepository;
import com.example.ewatch.repository.ReceiptEntryRepository;
import com.example.ewatch.repository.ReceiptRepository;
import com.sun.java.accessibility.util.SwingEventMonitor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptEntryService {
    private final ReceiptEntryRepository receiptEntryRepository;
    private final ReceiptRepository receiptRepository;
    private final ProductRepository productRepository;

    public List<ReceiptEntryDto> findAll(){
        return receiptEntryRepository.findAll().stream()
                .map(receiptEntry -> {
                    return ReceiptEntryDto.builder()
                            .id(receiptEntry.getId())
                            .quantity(receiptEntry.getQuantity())
                            .price(receiptEntry.getPrice())
                            .productName(receiptEntry.getProduct().getName())
                            .build();
                }).collect(Collectors.toList());
    }


    public Long add(CreateReceiptEntryDto dto) {
        Product product = null;

        Optional<Product> productOptional = productRepository.findById(dto.getProductId());
        if(productOptional.isPresent()) {
            product = productOptional.get();
        }else{
            throw new EntityNotFoundException("Product with id: "+ dto.getProductId() + " was not found.");
        }

        Receipt receipt = null;

        Optional<Receipt> receiptOptional = receiptRepository.findById(dto.getReceiptId());
        if(receiptOptional.isPresent()) {
            receipt = receiptOptional.get();
        }else{
            throw new EntityNotFoundException("Receipt with id: "+ dto.getReceiptId() + " was not found.");
        }

        ReceiptEntry receiptEntry = ReceiptEntry.builder()
                .product(product)
                .quantity(dto.getQuantity())
                .receipt(receipt)
                .price(dto.getQuantity() * product.getCurrentPrice())
                .build();

        receiptEntry = receiptEntryRepository.save(receiptEntry);
        return receiptEntry.getId();
    }
}
