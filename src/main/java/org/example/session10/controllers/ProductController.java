package org.example.session10.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.session10.models.dto.requests.ProductReq;
import org.example.session10.models.dto.wrapper.ApiResponse;
import org.example.session10.models.entities.Product;
import org.example.session10.models.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Lấy danh sách sản phẩm thành công",
                        productService.findAll()
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> addNewProduct(@Valid @RequestBody ProductReq req) {
        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        201,
                        "Thêm sản phẩm thành công",
                        productService.addNewProduct(req)
                )
        );
    }


}
