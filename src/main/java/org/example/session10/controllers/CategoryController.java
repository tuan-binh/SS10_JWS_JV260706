package org.example.session10.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session10.models.dto.requests.CategoryReq;
import org.example.session10.models.dto.wrapper.ApiResponse;
import org.example.session10.models.entities.Category;
import org.example.session10.models.entities.Product;
import org.example.session10.models.services.CategoryService;
import org.example.session10.models.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Lấy danh sách danh mục thành công",
                        categoryService.findAll())
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> addNewCategory(@Valid @RequestBody CategoryReq req) {
        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        201,
                        "Thêm danh mục thành công",
                        categoryService.addNewCategory(req)
                )
        );
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<ApiResponse<List<Product>>> getAllProductByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Lấy danh sách sản phẩm theo danh mục thành công",
                        productService.findAllByCategoryId(categoryId)
                )
        );
    }

}
