package com.Shiva.Product.Dto;


import lombok.*;

//@Data
@Getter @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;

//    public ProductDto(Long id, String name, String description, Double price, Long id1) {
//        this.id=id;
//        this.name=name;
//        this.description=description;
//        this.price=price;
//        this.categoryId=id1;
//    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
