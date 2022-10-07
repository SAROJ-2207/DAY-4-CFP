package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    public AddressBookRepository addressBookRepository;

    @Override
    public AddressBookModel addContact(AddressBookDto addressBookDto) {
        AddressBookModel newData = new AddressBookModel(addressBookDto);
        return addressBookRepository.save(newData);
    }

    @Override
    public AddressBookModel editContact(long id,AddressBookDto addressBookDto) {
        Optional<AddressBookModel> addressBookData = addressBookRepository.findById(id);
        if(addressBookData.isPresent()){
            addressBookData.get().setFirstName(addressBookDto.getFirstName());
            addressBookData.get().setLastName(addressBookDto.getLastName());
            addressBookData.get().setGender(addressBookDto.getGender());
            addressBookData.get().setAddress(addressBookDto.getAddress());
            addressBookData.get().setCity(addressBookDto.getCity());
            addressBookData.get().setState(addressBookDto.getState());
            addressBookData.get().setZipcode(addressBookDto.getZipcode());
            addressBookData.get().setNote(addressBookDto.getNote());
            addressBookData.get().setMobilenumber(addressBookDto.getMobileNumber());
            addressBookData.get().setRegDate(addressBookDto.getRegDate());

            return addressBookRepository.save(addressBookData.get());
        }
        return null;
    }

    @Override
    public AddressBookModel deletContact(long id) {
        Optional<AddressBookModel> addressBookId = addressBookRepository.findById(id);
        if (addressBookId.isPresent()) {
            addressBookRepository.delete(addressBookId.get());
            return addressBookId.get();
        } else {
            log.warn("Unable to find employee for given id:-" + id);
            return null;
        }
    }

    @Override
    public List<AddressBookModel> getDataByFirstName(String firstName) {
        List<AddressBookModel> getName = addressBookRepository.findByFirstName(firstName);
        if(getName.isEmpty()){
            throw new AddressBookException("Name not found!!!");
        }
        return getName;
    }

    @Override
    public List<AddressBookModel> getDataByCity(String city) {
        List<AddressBookModel> getCity = addressBookRepository.findByCity(city);
        if(getCity.isEmpty()){
            throw new AddressBookException("City Not Found");
        }
        return getCity;
    }

    @Override
    public List<AddressBookModel> getAllData() {
        List<AddressBookModel> listData = addressBookRepository.findAll();
        return listData;
    }
}
