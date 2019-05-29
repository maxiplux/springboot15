package com.simple.crud15.services;

import com.simple.crud15.model.Product;
import com.simple.crud15.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("productService")
public class ProductServiceImpl implements IService<Product> {

    @Autowired
    Productrepository productRepository;


    @Override
    public List<Product> findAll() {


        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(this.productRepository.findAll().iterator(), Spliterator.ORDERED),
                false).collect(Collectors.toList());
    }


    @Override
    public Product save(Product object) {
        return this.productRepository.save(object);
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return Optional.of(this.productRepository.findOne(id));
    }

    @Override
    public void delete(Long id) {
        this.productRepository.delete(id);

    }
}

