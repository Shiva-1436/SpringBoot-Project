package com.Shiva.Product.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {
    private String path;
    private HttpStatus statuscode;
    private  String errorMessage;
    private LocalDateTime errorTime;
}
