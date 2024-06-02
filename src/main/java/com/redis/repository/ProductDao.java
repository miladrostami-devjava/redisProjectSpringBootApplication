package com.redis.repository;

import com.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private RedisTemplate template;
    private static final String HASH_KEY = "Product";
    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }
    public List<Product> findAll(){
     return    template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(Integer id){
        return (Product)  template.opsForHash().get(HASH_KEY,id);
    }
    public String deleteProduct(Integer id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product deleted!!!";
    }

}
