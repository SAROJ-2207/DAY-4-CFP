package com.example.addressbook.model;

import com.example.addressbook.dto.AddressBookDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class AddressBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private long zipcode;
    private String note;
    private long mobilenumber;
    private Date regDate;

    public AddressBookModel() {

    }

    public AddressBookModel(AddressBookDto addressBookDto){
        this.firstName = addressBookDto.getFirstName();
        this.lastName = addressBookDto.getLastName();
        this.gender = addressBookDto.getGender();
        this.address = addressBookDto.getAddress();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.zipcode = addressBookDto.getZipcode();
        this.note = addressBookDto.getNote();
        this.mobilenumber = addressBookDto.getMobileNumber();
        this.regDate = addressBookDto.getRegDate();
    }
}
