package com.spring.transactional_proxy_research;

import com.spring.transactional_proxy_research.transactional.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalProxyResearchApplication implements CommandLineRunner {

	@Autowired
	private ProductService service;

	public static void main(String[] args) {
		SpringApplication.run(TransactionalProxyResearchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		service.saveProductInfo();
	}
}
