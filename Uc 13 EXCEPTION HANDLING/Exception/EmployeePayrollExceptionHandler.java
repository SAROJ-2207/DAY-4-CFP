package com.example.employeepayroll.Exception;

import com.example.employeepayroll.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/** Compile time Exception **/
public class EmployeePayrollExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethod(MethodArgumentNotValidException exception){
        return null;
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseDto> hanldelEmployeeNotFound(EmployeeException notfoundexception){
        ResponseDto responseDto = new ResponseDto("invalid id input", notfoundexception.getMessage());
                return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);

    }
}
