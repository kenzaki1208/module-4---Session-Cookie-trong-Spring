package org.example.demo_session_and_cookie_int_spring.practice.p3.service;

import org.example.demo_session_and_cookie_int_spring.practice.p3.model.Product;
import org.example.demo_session_and_cookie_int_spring.practice.p3.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
