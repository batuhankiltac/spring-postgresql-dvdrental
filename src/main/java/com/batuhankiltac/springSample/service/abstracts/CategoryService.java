package com.batuhankiltac.springSample.service.abstracts;

import com.batuhankiltac.springSample.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    Category add(Category category);
    void delete(Category category);
    List<Category> getAll();
    List<Category> getAllByPage(Integer pageNumber, Integer pageSize);
    List<Category> getAllSortedByID();
    List<Category> getAllSortedByName();
    Category getByCategoryId(Integer categoryId);
}