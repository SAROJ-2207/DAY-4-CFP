package com.example.employeepayroll.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private Object data;
    private String message;

    public ResponseDto(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}