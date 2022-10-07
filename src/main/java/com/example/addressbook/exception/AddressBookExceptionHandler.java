package com.example.addressbook.exception;

import com.example.addressbook.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class AddressBookExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> hanldeMethod(MethodArgumentNotValidException exception){
    return null;
    }

    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDto> handleEmployeeNotFound(AddressBookException idNotFoundException){
   ResponseDto responseDto =new ResponseDto("Invalid id input",idNotFoundException.getMessage());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);

    }

}
