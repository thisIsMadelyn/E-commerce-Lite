package org.example.ecommercelite.service;

import org.example.ecommercelite.enity.Product;
import org.example.ecommercelite.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> searchProduct(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getAvailableProduct(){
        return productRepository.findByStockQuantityGreaterThan(0);
    }

    public Product updateProductStock(int productId, int stockQuantity){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setStockQuantity(stockQuantity);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }

    public boolean existsProduct(Integer productId){
        return productRepository.existsById(productId);
    }
}
