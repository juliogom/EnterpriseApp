package co.com.enterprise.enterpriseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.enterprise.enterpriseapp.domain.*;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
