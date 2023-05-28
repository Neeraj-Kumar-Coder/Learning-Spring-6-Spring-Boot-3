package com.springDataJPA.springboot.repository;

import com.springDataJPA.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        Product product = new Product();

        product.setName("Product 1");
        product.setDescription("This is a test product");
        product.setSku("PROD-18DE");
        product.setActive(true);
        product.setPrice(new BigDecimal(1999));
        product.setImageUrl("image/url");

        Product saveResult = productRepository.save(product);
        System.out.println(saveResult.toString());

        if (saveResult.equals(product)) {
            System.out.println("Product matched!");
        } else {
            System.out.println("Product didn't matched!");
        }
    }

    @Test
    void updateMethod() {
        Long id = 1l;
        Product result = productRepository.findById(id).get();
        result.setName("Test Product");
        result.setDescription("Product Description is now changed");
        Product updateResult = productRepository.save(result);
        System.out.println(updateResult.toString());
    }

    @Test
    void findMethod() {
        Long id = 4l;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("This is a test product");
        product1.setSku("PROD-18DE-1");
        product1.setActive(true);
        product1.setPrice(new BigDecimal(1999));
        product1.setImageUrl("image/url");

        Product product2 = new Product();
        product2.setName("Product 1");
        product2.setDescription("This is a test product");
        product2.setSku("PROD-18DE-2");
        product2.setActive(true);
        product2.setPrice(new BigDecimal(1999));
        product2.setImageUrl("image/url");

        List<Product> products = productRepository.saveAll(List.of(product1, product2));
        System.out.println(products.toString());
    }

    @Test
    void findAllMethod() {
        List<Product> it = productRepository.findAll();
        for (Product product : it) {
            System.out.println(product.toString());
        }
    }

    @Test
    void deleteMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void deleteAllWithIdListMethod() {
        productRepository.deleteAll(List.of(productRepository.findById(7l).get(), productRepository.findById(8l).get()));
    }

    @Test
    void countMethod() {
        Long numberOfRecords = productRepository.count();
        System.out.println(numberOfRecords);
    }

    @Test
    void existsByIdMethod() {
        if (productRepository.existsById(9l)) {
            System.out.println("Id 9 exists!");
        } else {
            System.out.println("Id 9 DON'T exits!!");
        }
    }
}