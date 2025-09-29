package org.example.demo_session_and_cookie_int_spring.practice.p3.repository;

import org.example.demo_session_and_cookie_int_spring.practice.p3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
