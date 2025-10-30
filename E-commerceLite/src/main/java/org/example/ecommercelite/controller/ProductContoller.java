package org.example.ecommercelite.controller;

import jakarta.persistence.GeneratedValue;
import org.example.ecommercelite.enity.Product;
import org.example.ecommercelite.repository.ProductRepository;
import org.example.ecommercelite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductContoller {


    @Autowired
    private ProductService productService;

    //    get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

//    get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    create new product
    @PostMapping
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }

//    search products by name
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name){
        return productService.searchProduct(name);
    }

//    Get available products
    @GetMapping("/available")
    public List<Product> getAvailableProducts(){
        return productService.getAvailableProduct();
    }

//    Update product stock
    public ResponseEntity<Product> updateProductStock(
        @PathVariable Integer id, @RequestParam Integer stock) {
    Product product = productService.updateProductStock(id, stock);
    return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

//    Delete product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        if(productService.existsProduct(id)){
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Product not found");
        }
    }

//    Delete product by name
    @DeleteMapping("/name/{name}")
    public ResponseEntity<String> deleteProductByName(@PathVariable String name){
        List<Product> products = productService.searchProduct(name);
        if(!products.isEmpty()){
            for(Product product : products){
                productService.deleteProduct(Math.toIntExact(products.get(0).getId()));
            }
            return ResponseEntity.ok("Products with name '" + name + "' deleted successfully");
        } else {
            return ResponseEntity.status(404).body("No products found with name '" + name + "'");
        }
    }
}
