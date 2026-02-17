package com.Shiva.Product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@OpenAPIDefinition(
        info = @Info(
                title = "Product Service Rest API",
                description = "this is product service apis application",
                version = "v1",
                contact = @Contact(
                        name = "shivaaaaaa",
                        email = "22951a1286@iare.ac.in"
                )
        )
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
