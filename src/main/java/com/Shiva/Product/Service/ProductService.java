package com.Shiva.Product.Service;


import com.Shiva.Product.Dto.ProductDto;
import com.Shiva.Product.Entity.Category;
import com.Shiva.Product.Entity.Product;
import com.Shiva.Product.Exception.CategoryNotFoundException;
import com.Shiva.Product.Mapper.ProductMapper;
import com.Shiva.Product.Repository.CategoryRepository;
import com.Shiva.Product.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    //create
    public ProductDto create(ProductDto productDto){
        Category category=categoryRepository.findById(productDto.getCategoryId()).
                orElseThrow(() -> new CategoryNotFoundException("category "
                        +productDto.getCategoryId()+" not found"));

        Product product= ProductMapper.toproductEntity(productDto,category);
        product=productRepository.save(product);
        return ProductMapper.toproductDto(product);
    }

    //get all product

    public List<ProductDto> getAllProducts(){
       return  productRepository.findAll().stream().map(ProductMapper::toproductDto).toList();
    }

    //get product by id
    public ProductDto getproductById(Long id){
        Product product=productRepository.findById(id).
                orElseThrow(()->new RuntimeException("product not found"));
        ProductDto productDto=ProductMapper.toproductDto(product);
        return productDto;

    }

    //Delete product by id
    public String deleteproduct(Long id){
        productRepository.deleteById(id);
        return "product "+id+ "deleted";
    }

    //update
    public ProductDto updateproduct(Long id,ProductDto productDto){
        Product product=productRepository.findById(id).
                orElseThrow(()->new RuntimeException("product not found"));
        Category category=categoryRepository.findById(productDto.getCategoryId()).
                orElseThrow(()->new RuntimeException("category not found"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        
        return ProductMapper.toproductDto(product);
    }


}
