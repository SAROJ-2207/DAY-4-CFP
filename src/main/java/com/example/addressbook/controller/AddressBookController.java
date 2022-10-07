package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.service.IAddressBookService;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private  IAddressBookService iAddressBookService;

    @GetMapping("/welcome")
    public String message(String message){
        return "******** Welcome To Address Book *********";
    }


    @PostMapping("/addAddressbook")
    public AddressBookModel addAddressBookData(@RequestBody AddressBookDto addressBookDto){
        return iAddressBookService.addContact(addressBookDto);
    }

    @PutMapping("/updateEmployee/{id}")
    public AddressBookModel updateData(@PathVariable long id,@RequestBody AddressBookDto addressBookDto){
        return iAddressBookService.editContact(id,addressBookDto);
    }

    @DeleteMapping("/delete/{id}")
    public AddressBookModel deleteData(@PathVariable long id){
        return iAddressBookService.deletContact(id);
    }

    @GetMapping("/getalldata")
    public List<AddressBookModel> getData(){
        return iAddressBookService.getAllData();
    }

    @GetMapping("/getByFirstName/{firstName}")
    public ResponseEntity<ResponseDto> getDataByUsingFirstName(@PathVariable String firstName)  {
        List<AddressBookModel> newAddress = iAddressBookService.getDataByFirstName(firstName);
        ResponseDto data =  new ResponseDto("Data retrive for given firstname",newAddress);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getByCityName/{cityname}")
    public ResponseEntity<ResponseDto> getDataByUsingCityName(@PathVariable String cityname) {
        List<AddressBookModel> cityName = iAddressBookService.getDataByCity(cityname);
        ResponseDto cityData = new ResponseDto("Data Retrive By using City Name",cityName);
        return new ResponseEntity<>(cityData,HttpStatus.OK);
    }

}
