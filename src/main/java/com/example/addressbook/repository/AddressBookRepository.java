package com.example.addressbook.repository;

import com.example.addressbook.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {

    @Query(value = "select * from address_book_model where first_name = :firstName",nativeQuery = true)
    List<AddressBookModel> findByFirstName(String firstName);

    @Query(value = "select * from address_book_model where city = :city",nativeQuery = true)
    List<AddressBookModel> findByCity(String city);

}
