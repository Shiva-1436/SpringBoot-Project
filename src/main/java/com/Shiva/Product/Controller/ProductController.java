package com.Shiva.Product.Controller;

import com.Shiva.Product.Dto.ProductDto;
import com.Shiva.Product.Service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Tag(
        name = "Product RestAPI CRUD Operations",
        description = "create delete get update operations perform here for product"
)


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createproduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.create(productDto), HttpStatus.CREATED);
    }
//    public ProductDto createproduct(@RequestBody ProductDto productDto){
//        return productService.create(productDto);
//    }

    //GET ALL products
    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    //get product by id
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getproductById(id);
    }

    //delete product
    @DeleteMapping("/{id}")
    public String deleteproduct(@PathVariable Long id){
        return productService.deleteproduct(id);
    }

    //update product
    @PutMapping("/{id}")
    public ProductDto updateproduct(@PathVariable Long id , @RequestBody ProductDto productDto){
        return productService.updateproduct(id,productDto);
    }
}
