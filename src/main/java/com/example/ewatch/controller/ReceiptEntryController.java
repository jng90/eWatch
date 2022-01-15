package com.example.ewatch.controller;

import com.example.ewatch.model.dto.CreateReceiptEntryDto;
import com.example.ewatch.model.dto.ReceiptDto;
import com.example.ewatch.model.dto.ReceiptEntryDto;
import com.example.ewatch.service.ReceiptEntryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt-entry")
public class ReceiptEntryController {
    private final ReceiptEntryService receiptEntryService;

    @GetMapping("")
    public List<ReceiptEntryDto> getAll() {
        return receiptEntryService.findAll();
    }

    @PostMapping("")
    public Long add(@RequestBody CreateReceiptEntryDto dto) {
        return receiptEntryService.add(dto);
    }
}
