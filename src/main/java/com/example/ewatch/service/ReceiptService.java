package com.example.ewatch.service;

import com.example.ewatch.model.Receipt;
import com.example.ewatch.model.dto.CreateProductDto;
import com.example.ewatch.model.dto.CreateReceiptDto;
import com.example.ewatch.model.dto.ReceiptDto;
import com.example.ewatch.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptService {
    private final ReceiptRepository receiptRepository;


    public List<ReceiptDto> findAll() {
        return receiptRepository.findAll().stream()
                .map(receipt -> {
                    return ReceiptDto.builder()
                            .id(receipt.getId())
                            .dateOfPurchase(receipt.getDateOfPurchase())
                            .userName(receipt.getUser()!= null ? receipt.getUser().getName() : "Unknown")
                            .userSurname(receipt.getUser()!= null ? receipt.getUser().getSurname() : "Unknown")
                            .build();
                }).collect(Collectors.toList());
    }

    public void add(Long userId) {
        Receipt receiptToCreate = Receipt.builder()
//                .user(receipt.getUser()) // TODO: jak będzie logowanie, to ID odczytamy z zalogowanego tokenu
                .dateOfCreation(LocalDateTime.now())
                .build();

        receiptRepository.save(receiptToCreate);
    }
}
