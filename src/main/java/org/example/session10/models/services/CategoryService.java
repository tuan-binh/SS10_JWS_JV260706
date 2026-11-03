package org.example.session10.models.services;

import org.example.session10.models.dto.requests.CategoryReq;
import org.example.session10.models.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category addNewCategory(CategoryReq req);

    Category findById(Long id);


}
