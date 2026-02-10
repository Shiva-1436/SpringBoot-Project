package com.Shiva.Product.Controller;

import com.Shiva.Product.Dto.CategoryDto;
import com.Shiva.Product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //create categories
    @PostMapping
    public ResponseEntity<CategoryDto> createproduct(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.create(categoryDto), HttpStatus.CREATED);
    }

    //get categories
    @GetMapping
    public List<CategoryDto> getAll(){
        return categoryService.getAll();
    }

    //getCategory by Id
    @GetMapping("/{id}")
    public CategoryDto getcategoryById(@PathVariable Long id){
        return categoryService.getcategoryById(id);
    }

    //DeleteMapping
    @DeleteMapping("/{id}")
    public String Deletecategory(@PathVariable Long id){
        return categoryService.delete(id);
    }
}
