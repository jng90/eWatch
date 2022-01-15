package com.example.ewatch.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateOfPurchase;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "receipt ")
    private Set<ReceiptEntry> entries;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private User user;

}
