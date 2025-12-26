package org.example.ecommercelite.repositoryTests;

import org.example.ecommercelite.enity.Product;
import org.example.ecommercelite.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @AfterEach
    public void teardown(){
        productRepository.deleteAll();
    }

    @Test
    public void check_If_Product_Exists_By_Name_Ignore_Case(){

        long randomId = (long) (Math.random() * 1000);
        String productName = "iphone";
        Product product = new Product(
                randomId,
                productName,
                "Description for " + randomId,
                new BigDecimal("99.99"),
                10,
                LocalDateTime.now()
        );

        Product savedProduct = (Product) productRepository.findByNameContainingIgnoreCase("iphone");
//        To be continued... εχω κανει μαλακια
    }

}
