package com.cagemini.addressbookappspring.service;

import java.util.List;

import com.cagemini.addressbookappspring.dto.AddressBookDTO;
import com.cagemini.addressbookappspring.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookContactData();

	AddressBookData getAddressBookContactDataById(int id);

	AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO);

	void deleteAddressBookContactData(int id);
}
