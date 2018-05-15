package co.com.enterprise.enterpriseapp.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import co.com.enterprise.enterpriseapp.domain.Product;
import co.com.enterprise.enterpriseapp.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductResource{

	private final Logger log=LoggerFactory.getLogger(ProductResource.class);
	
	private final String ENTITY_NAME="product";

	private final ProductService productService;
	
	public ProductResource(ProductService productService) {
		this.productService=productService;	
	}
	
	@PostMapping("/products")
	@Timed
	public String createProduct(){
		
		Product result = new Product();
		
		return "Creado Con exito";
	}
	
	@GetMapping("/products")
	@Timed
	public List<Product> getAll(){
		log.debug("Getting all Products");
		
		return productService.findAll();
	}
	
}
