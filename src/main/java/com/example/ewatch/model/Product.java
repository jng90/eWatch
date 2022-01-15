package com.example.ewatch.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double currentPrice;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private ProductCategory category;
}
