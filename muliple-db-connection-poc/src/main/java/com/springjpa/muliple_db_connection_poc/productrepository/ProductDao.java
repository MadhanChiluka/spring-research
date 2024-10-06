package com.springjpa.muliple_db_connection_poc.productrepository;

import com.springjpa.muliple_db_connection_poc.productentity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
