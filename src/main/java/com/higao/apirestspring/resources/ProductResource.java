package com.higao.apirestspring.resources;

import com.higao.apirestspring.entities.Product;
import com.higao.apirestspring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductResource {

    @Autowired(required = true)
    private ProductService productService;

    @GetMapping(value="/products")
    public ResponseEntity<List<Product>> findAllUsers(){
        List<Product> productList = this.productService.findAll();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping(value="/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = this.productService.findById(id);

        return ResponseEntity.ok().body(product);
    }
}
