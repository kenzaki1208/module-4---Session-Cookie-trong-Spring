package org.example.demo_session_and_cookie_int_spring.exercise.repository;

import org.example.demo_session_and_cookie_int_spring.exercise.model.ProductEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductExRepository extends JpaRepository<ProductEx, Long> {
}
