package com.example.ewatch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptEntryDto {
    private Long id;
    private int quantity;
    private double price;
    private String productName;
}
