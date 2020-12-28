package com.cagemini.addressbookappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cagemini.addressbookappspring.model.AddressBookData;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
