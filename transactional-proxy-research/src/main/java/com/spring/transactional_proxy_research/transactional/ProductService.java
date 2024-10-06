package com.spring.transactional_proxy_research.transactional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public void saveProductInfo() {
        for(int i = 0; i<10; i++) {
            Product product = new Product();
            product.setName("Random Product " + i);
            product.setPrice(10.11);
            repository.save(product);
        }
    }
}
