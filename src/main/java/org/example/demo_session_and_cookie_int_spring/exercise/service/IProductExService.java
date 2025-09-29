package org.example.demo_session_and_cookie_int_spring.exercise.service;

import org.example.demo_session_and_cookie_int_spring.exercise.model.ProductEx;

import java.util.Optional;

public interface IProductExService {
    Iterable<ProductEx> findAll();
    Optional<ProductEx> findById(Long id);
}