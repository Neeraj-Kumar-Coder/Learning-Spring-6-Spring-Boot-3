package com.springDataJPA.springboot.repository;

import com.springDataJPA.springboot.entity.Product;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //    This query method returns the found product entry by taking "name" as the search criteria
    public Product findByName(String name);

    @Override
    Optional<Product> findById(Long id);

    public List<Product> findByIdOrName(Long id, String name);

    public List<Product> findByIdAndName(Long id, String name);

    List<Product> findDistinctByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> names);

    List<Product> findTop2ByPrice(BigDecimal price);
}
