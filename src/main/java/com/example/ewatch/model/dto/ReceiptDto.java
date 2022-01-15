package com.example.ewatch.model.dto;

import com.example.ewatch.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDto {
    private Long id;
    private LocalDateTime dateOfPurchase;
    private String userName;
    private String userSurname;


}
