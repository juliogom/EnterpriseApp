package co.com.enterprise.enterpriseapp.service;

import java.util.List;

import co.com.enterprise.enterpriseapp.domain.Product;

public interface ProductService {

	Product save(Product product);
	
	List<Product> findAll();
}
