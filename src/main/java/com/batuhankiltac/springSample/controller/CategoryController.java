package com.batuhankiltac.springSample.controller;

import com.batuhankiltac.springSample.model.Category;
import com.batuhankiltac.springSample.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Category category) {
        categoryService.delete(category);
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/getAllByPage")
    public List<Category> getAllByPage(Integer pageNumber, Integer pageSize) {
        return categoryService.getAllByPage(pageNumber, pageSize);
    }

    @GetMapping("/getAllSortedByID")
    public List<Category> getAllSortedByID() {
        return categoryService.getAllSortedByID();
    }

    @GetMapping("/getAllSortedByName")
    public List<Category> getAllSortedByName() {
        return categoryService.getAllSortedByName();
    }

    @GetMapping("/getByCategoryId")
    public Category getByCategoryId(@RequestParam Integer categoryId) {
        return categoryService.getByCategoryId(categoryId);
    }
}