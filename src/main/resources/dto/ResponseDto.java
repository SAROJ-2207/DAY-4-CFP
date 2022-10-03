package com.example.employeepayroll.dto;

public class ResponseDto {

    private Object data;
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public ResponseDto(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}