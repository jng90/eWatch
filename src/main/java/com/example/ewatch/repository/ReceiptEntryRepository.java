package com.example.ewatch.repository;

import com.example.ewatch.model.ReceiptEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptEntryRepository extends JpaRepository<ReceiptEntry, Long> {
}
