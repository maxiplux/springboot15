package com.simple.crud15.services;

import com.simple.crud15.model.Product;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> findAll();

    T save(T object);

    Product save(Product object);

    Optional<T> findOne(Long id);

    void delete(Long id);
}
