package com.Shiva.Product.Mapper;

import com.Shiva.Product.Dto.CategoryDto;
import com.Shiva.Product.Entity.Category;

public class CategoryMapper {
    public  static Category toCategoryEntity(CategoryDto categoryDto){
        Category category=new Category();
        category.setName(categoryDto.getName());
        return category;
    }

    public  static CategoryDto tocategoryDto(Category category){
        if(category==null){
            return  null;
        }
        CategoryDto categoryDto=new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProducts(category.getProducts().stream().
                map(ProductMapper::toproductDto).toList());
        return  categoryDto;
    }

}
