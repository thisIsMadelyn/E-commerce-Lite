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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

        String productName = "iphone";
        Product product = new Product();
        product.setName(productName);
        product.setPrice(new BigDecimal("99.99"));
        product.setStockQuantity(10);
        product.setCreatedDate(LocalDateTime.now());

        productRepository.save(product);

        List<Product> foundProducts = productRepository.findByNameContainingIgnoreCase("iphone");

        assertFalse(foundProducts.isEmpty(), "The list should not be empty");
        assertEquals(productName, foundProducts.get(0).getName().toLowerCase(), "Product was successfully retrieved");
    }

    @Test
    public void it_Should_Return_Empty_When_ProductName_Does_Not_Exist(){

        String productName = "apple";

        List<Product> exists = productRepository.findByNameContainingIgnoreCase(productName);

        assertTrue(exists.isEmpty());

    }

    @Test
    public void ProductRepository_GetAll_Return_More_Than_One(){

        Product product1 = new Product();
        Product product2 = new Product();

        String productName1 = "asus";
        String productName2 = "dell";

        product1.setName(productName1);
        product1.setPrice(new BigDecimal("599.99"));
        product1.setStockQuantity(10);
        product1.setCreatedDate(LocalDateTime.now());

        product2.setName(productName2);
        product2.setPrice(new BigDecimal("499.99"));
        product2.setStockQuantity(10);
        product2.setCreatedDate(LocalDateTime.now());

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList = productRepository.findAll();

        assertNotNull(productList, "the product list shouldn't be null");
        assertEquals(2, productList.size(), "The DB should contain 2 products");

    }

    @Test
    public void check_If_Product_Exists_By_Stock_Quantity_Greater_Than(){

        String productName = "iphone";
        Product product = new Product();
        product.setName(productName);
        product.setPrice(new BigDecimal("99.99"));
        product.setStockQuantity(10);
        product.setCreatedDate(LocalDateTime.now());

        productRepository.save(product);

        List<Product> productList = productRepository.findByStockQuantityGreaterThan(9);

//        to be continued...

    }


}
