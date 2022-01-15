package com.example.ewatch.controller;


import com.example.ewatch.model.dto.CreateReceiptDto;
import com.example.ewatch.model.dto.ReceiptDto;
import com.example.ewatch.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {
    private final ReceiptService receiptService;

    @PostMapping("")
    public void add(){
        // TODO: obsługa zalogowanego uzytkownika
        receiptService.add(1L);
    }

    @GetMapping("")
    public List<ReceiptDto> getAll() {
        return receiptService.findAll();
    }
}
