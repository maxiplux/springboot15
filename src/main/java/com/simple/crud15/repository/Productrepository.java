package com.simple.crud15.repository;




import com.simple.crud15.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface Productrepository extends CrudRepository<Product, Long> {
}