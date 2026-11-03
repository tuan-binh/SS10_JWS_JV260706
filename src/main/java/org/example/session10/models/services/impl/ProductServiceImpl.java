package org.example.session10.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.session10.models.dto.requests.ProductReq;
import org.example.session10.models.entities.Category;
import org.example.session10.models.entities.Product;
import org.example.session10.models.repositories.ProductRepository;
import org.example.session10.models.services.CategoryService;
import org.example.session10.models.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addNewProduct(ProductReq req) {
        // Kiểm soát được là danh mục có tồn tại hay không
        Category category = categoryService.findById(req.categoryId());

        Product product = Product.builder()
                .name(req.name())
                .price(req.price())
                .stock(req.stock())
                .category(category)
                .build();

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByCategoryId(Long categoryId) {
        // kiểm tra xem danh mục
        Category category = categoryService.findById(categoryId);

        return productRepository.findAllByCategory(category);
    }
}
