package com.Shiva.Product.Controller;

import com.Shiva.Product.Dto.CategoryDto;
import com.Shiva.Product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //create categories
    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.create(categoryDto), HttpStatus.CREATED);
    }
}
