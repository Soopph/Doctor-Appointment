package com.example.doctorAppointmentAPI.service;

import com.example.doctorAppointmentAPI.dto.CategoryDto;
import com.example.doctorAppointmentAPI.entity.Category;
import com.example.doctorAppointmentAPI.mapper.CategoryMapper;
import com.example.doctorAppointmentAPI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public  List<CategoryDto> getAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        return (category != null) ? CategoryMapper.toDto(category) : null;
    }

    public CategoryDto saveCategory(CategoryDto dto){
        Category category = CategoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
    }

    public CategoryDto updateCategory(Long id, CategoryDto dto){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with ID:" +id));

        category.setName(dto.getName());
        category.setPicture(dto.getPicture());

        Category updated = categoryRepository.save(category);
        return CategoryMapper.toDto(updated);

    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
