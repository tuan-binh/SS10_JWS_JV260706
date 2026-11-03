package org.example.session10.models.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.session10.exceptions.HttpNotFoundException;
import org.example.session10.models.dto.requests.CategoryReq;
import org.example.session10.models.entities.Category;
import org.example.session10.models.repositories.CategoryRepository;
import org.example.session10.models.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new HttpNotFoundException("Không tìm thấy danh mục với id: " + id));
    }

    @Override
    public Category addNewCategory(CategoryReq req) {
        return categoryRepository.save(
                Category.builder()
                        .name(req.name())
                        .build()
        );
    }
}
