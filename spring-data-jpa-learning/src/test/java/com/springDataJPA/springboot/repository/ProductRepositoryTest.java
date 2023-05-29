package com.springDataJPA.springboot.repository;

import com.springDataJPA.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Long id = 1L;
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
        product1.setName("Product 2");
        product1.setDescription("This is a test product");
        product1.setSku("PROD-18DE-1");
        product1.setActive(true);
        product1.setPrice(new BigDecimal(1999));
        product1.setImageUrl("image/url");

        Product product2 = new Product();
        product2.setName("Product 3");
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
        productRepository
                .deleteAll(List.of(productRepository.findById(7l).get(), productRepository.findById(8l).get()));
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

    @Test
    void findByNameQuery() {
        Product product = productRepository.findByName("Product 1");
        System.out.println(product.toString());
    }

    @Test
    void findByIdQuery() {
        Optional<Product> result = productRepository.findById(1l);
        if (result.isPresent())
            System.out.println(result.get().toString());
        else
            System.out.println("No such entry exists!");
    }

    @Test
    void findByIdOrNameQuery() {
        List<Product> products = productRepository.findByIdOrName(2l, "Product 1");
        products.forEach((product -> System.out.println(product.toString())));
    }

    @Test
    void findByIdAndNameQuery() {
        List<Product> products = productRepository.findByIdAndName(1l, "Product 1");
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findDistinctByPriceQuery() {
        List<Product> products = productRepository.findDistinctByPrice(new BigDecimal(1999));
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByPriceGreaterThanQuery() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(1998));
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByPriceLessThanQuery() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(5000));
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByNameContainingQuery() {
        List<Product> products = productRepository.findByNameContaining("Product 1");
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByNameLikeQuery() {
        List<Product> products = productRepository.findByNameLike("Product 1");
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByPriceBetweenQuery() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(1000), new BigDecimal(1999));
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByCreationDateBetweenQuery() {
        LocalDateTime start = LocalDateTime.of(2023, 05, 29, 13, 06, 35);
        LocalDateTime end = LocalDateTime.of(2024, 05, 29, 13, 06, 35);
        List<Product> products = productRepository.findByCreationDateBetween(start, end);
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findByNameInQuery() {
        List<String> names = List.of("Product 1", "Product 3", "Impossible");
        List<Product> products = productRepository.findByNameIn(names);
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void findTop2ByPriceQuery() {
        List<Product> products = productRepository.findTop2ByPrice(new BigDecimal(1999));
        products.forEach(product -> System.out.println(product.toString()));
    }
}