package com.redis.controller;

import com.redis.entity.Product;
import com.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")

public class ProductController {
    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product){
        return dao.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id){
        return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Integer id){
        return dao.deleteProduct(id);
    }




}
