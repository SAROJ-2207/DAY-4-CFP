package com.example.addressbook.dto;

import lombok.Data;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class AddressBookDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}",message = "First Letter Should Be Capital")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}",message = "First Letter Should Be Capital")
    private String lastName;
    @Pattern(regexp = "male|female",message = "Gender need to be a provided")
    private String gender;

    @NotNull(message = " Address/City/State/ZipCode Should Not be Empty!!!")
    private String address;
    private String city;
    private String state;
    private long zipcode;

    @NotNull(message = "Note should not be empty!!!")
    private String note;

    @Min(value = 10,message = "Minimum 10 digit number required!!!")
    @Max(value = 10,message = "Maximum 10 digit number required!!! ")
    private long mobileNumber;
    private Date regDate;

}
