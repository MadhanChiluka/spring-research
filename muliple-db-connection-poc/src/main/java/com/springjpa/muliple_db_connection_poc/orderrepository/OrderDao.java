package com.springjpa.muliple_db_connection_poc.orderrepository;

import com.springjpa.muliple_db_connection_poc.orderentity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {


}
