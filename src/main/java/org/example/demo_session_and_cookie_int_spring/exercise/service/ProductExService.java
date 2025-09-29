package org.example.demo_session_and_cookie_int_spring.exercise.service;

import org.example.demo_session_and_cookie_int_spring.exercise.model.ProductEx;
import org.example.demo_session_and_cookie_int_spring.exercise.repository.IProductExRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductExService implements IProductExService {
    @Autowired
    private IProductExRepository productRepository;


    @Override
    public Iterable<ProductEx> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEx> findById(Long id) {
        return productRepository.findById(id);
    }
}
