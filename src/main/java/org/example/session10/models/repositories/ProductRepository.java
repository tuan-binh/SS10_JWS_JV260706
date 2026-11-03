package org.example.session10.models.repositories;

import org.example.session10.models.entities.Category;
import org.example.session10.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);
}
