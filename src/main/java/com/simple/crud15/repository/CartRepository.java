package com.simple.crud15.repository;


import com.simple.crud15.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CartRepository")
public interface CartRepository extends CrudRepository<Cart, Long>  {
}