package com.BE.controller;

import com.BE.model.entity.Category;
import com.BE.model.entity.Category;
import com.BE.model.request.CategoryRequest;
import com.BE.model.request.CategoryRequest;
import com.BE.service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody CategoryRequest category) {
        Category newCategory= categoryService.create(category);
        return ResponseEntity.ok(newCategory);
    }
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);

    }

    //update
    @PutMapping("/udate/{id}")
    public ResponseEntity update(@PathVariable long id,@Valid @RequestBody CategoryRequest category) {
        Category updateCategory = categoryService.update(id, category);
        return ResponseEntity.ok(updateCategory);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Category deleteCategory = categoryService.delete(id);
        return ResponseEntity.ok(deleteCategory);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCategoryById(@PathVariable long id) {
        Category getCategoryId = categoryService.getCategoryById(id);
        return ResponseEntity.ok(getCategoryId);
    }

}
