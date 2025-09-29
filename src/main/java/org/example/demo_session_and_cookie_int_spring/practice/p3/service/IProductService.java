package org.example.demo_session_and_cookie_int_spring.practice.p3.service;

import org.example.demo_session_and_cookie_int_spring.practice.p3.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}