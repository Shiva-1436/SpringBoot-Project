package com.Shiva.Product.Service;

import com.Shiva.Product.Dto.CategoryDto;
import com.Shiva.Product.Entity.Category;
import com.Shiva.Product.Mapper.CategoryMapper;
import com.Shiva.Product.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    //create category
    public CategoryDto create(CategoryDto categoryDto){

        Category category= CategoryMapper.toCategoryEntity(categoryDto);
        category=categoryRepository.save(category);
        return CategoryMapper.tocategoryDto(category);

    }
}
