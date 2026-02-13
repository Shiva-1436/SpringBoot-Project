package com.Shiva.Product.Service;

import com.Shiva.Product.Dto.CategoryDto;
import com.Shiva.Product.Entity.Category;
import com.Shiva.Product.Exception.CategoryAlreadyExistsException;
import com.Shiva.Product.Mapper.CategoryMapper;
import com.Shiva.Product.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    //create category
    public CategoryDto create(CategoryDto categoryDto){
        Optional<Category> optionalCategory=categoryRepository.findByName(categoryDto.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistsException("Category "+ categoryDto.getName()+" already exists");
        }
        Category category= CategoryMapper.toCategoryEntity(categoryDto);
        category=categoryRepository.save(category);
        return CategoryMapper.tocategoryDto(category);

    }

    //get categories
    public List<CategoryDto> getAll(){
        return categoryRepository.findAll().stream().map(CategoryMapper::tocategoryDto).toList();
    }

    //get by id
    public CategoryDto getcategoryById(Long id){
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("no category found"));
        CategoryDto categoryDto=CategoryMapper.tocategoryDto(category);
        return categoryDto;
    }

    //DeleteById
    public  String delete(Long id){
//        Category category=categoryRepository.findById(id).
//                orElseThrow(()->new RuntimeException("no category found"));
//        categoryRepository.delete(category);
        categoryRepository.deleteById(id);
        return "Category "+id+" Succesfully deleted";
    }
}
