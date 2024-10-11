package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Category;
import com.BE.model.entity.Category;
import com.BE.model.entity.ServiceEntity;
import com.BE.model.request.CategoryRequest;
import com.BE.model.request.CategoryRequest;
import com.BE.model.request.ServiceRequest;
import com.BE.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category create(CategoryRequest category) {
        Category category1 = new Category();
        category1.setCategoryName(category.getCategoryName());
        category1.setCategoryDescription(category.getCategoryDescription());

        Category newCategory = categoryRepository.save(category1);
        return newCategory;

    }
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    //update
    public Category update(long id, CategoryRequest category) {
        //b1: Tim ra service can update
        Category oldCategory = getCategoryById(id);

        //co ton tai

        oldCategory.setCategoryName(category.getCategoryName());
        oldCategory.setCategoryDescription(category.getCategoryDescription());



        return categoryRepository.save(oldCategory);

    }
    //Delete
    public Category delete(long id) {
        Category oldCategory = getCategoryById(id);
        oldCategory.setDelete(true);
        return categoryRepository.save(oldCategory);
    }

    public  Category getCategoryId(long id) {
        Category getCategoryId = getCategoryById(id);

        return categoryRepository.save(getCategoryId);
    }
    //ham dung chung
    public Category getCategoryById(long id) {
        Category oldCategory = categoryRepository.findById(id);
        if(oldCategory == null) {
            throw new NotFoundException("Category not found");
        }
        return oldCategory;
    }

}
