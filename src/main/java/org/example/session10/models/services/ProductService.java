package org.example.session10.models.services;

import org.example.session10.models.dto.requests.ProductReq;
import org.example.session10.models.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product addNewProduct(ProductReq req);

    List<Product> findAllByCategoryId(Long categoryId);
}
