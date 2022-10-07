package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.model.AddressBookModel;

import java.util.List;

public interface IAddressBookService {

    AddressBookModel addContact(AddressBookDto addressBookDto);
    AddressBookModel editContact(long id,AddressBookDto addressBookDto);
    AddressBookModel deletContact(long id);

    List<AddressBookModel> getDataByFirstName(String firstName);
    public List<AddressBookModel> getDataByCity(String city);
    List<AddressBookModel> getAllData();
}
