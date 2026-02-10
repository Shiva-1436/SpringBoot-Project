package com.Shiva.Product.Mapper;

import com.Shiva.Product.Dto.ProductDto;
import com.Shiva.Product.Entity.Category;
import com.Shiva.Product.Entity.Product;
import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class ProductMapper {

    //entity to dto
    public  static ProductDto toproductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    //dto to entity
    public static Product toproductEntity(ProductDto productDto, Category category){
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return product;
    }
}
