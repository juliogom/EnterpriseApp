package co.com.enterprise.enterpriseapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.enterprise.enterpriseapp.domain.Product;
import co.com.enterprise.enterpriseapp.repository.ProductRepository;
import co.com.enterprise.enterpriseapp.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	private final Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		
		this.productRepository=productRepository;
		
	}
	
	@Override
	public Product save(Product product) {

		return null;
	}

	@Override
	public List<Product> findAll(){
		
		logger.debug("Getting all products");
		return this.productRepository.findAll();
		
	}
}
