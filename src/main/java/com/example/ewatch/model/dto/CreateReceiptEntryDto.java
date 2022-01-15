package com.example.ewatch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReceiptEntryDto {
    private int quantity;
    private Long productId;
    private Long receiptId;
}
