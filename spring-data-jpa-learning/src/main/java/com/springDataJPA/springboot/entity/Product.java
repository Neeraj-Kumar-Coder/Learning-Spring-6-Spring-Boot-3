package com.springDataJPA.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = @UniqueConstraint(name = "sku_unique", columnNames = "stock_keeping_unit")
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;

    private BigDecimal price;

    private boolean active;

    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}

/**
 * GenerationType.AUTO -> it lets persistence provider choose the strategy (in most cases it chooses GenerationType.SEQUENCE)
 * GenerationType.IDENTITY -> it lets database generate auto-incremented values and is very efficient
 * GenerationType.SEQUENCE -> it generates primary key values based on a specific sequence as provided by @SequenceGenerator annotation
 * */