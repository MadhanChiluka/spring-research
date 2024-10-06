package com.springjpa.muliple_db_connection_poc;

import com.springjpa.muliple_db_connection_poc.orderentity.Order;
import com.springjpa.muliple_db_connection_poc.orderrepository.OrderDao;
import com.springjpa.muliple_db_connection_poc.productentity.Product;
import com.springjpa.muliple_db_connection_poc.productrepository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.time.LocalDate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MulipleDbConnectionPocApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    public static void main(String[] args) {
        SpringApplication.run(MulipleDbConnectionPocApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product(2, "Iphone", 80000.00);
        productDao.save(product);

        Order order = new Order(1, "Amazon", LocalDate.now());
        orderDao.save(order);
    }
}
