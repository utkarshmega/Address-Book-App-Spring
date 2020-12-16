package com.cagemini.addressbookappspring.service;

import java.util.List;

import com.cagemini.addressbookappspring.dto.AddressBookDTO;
import com.cagemini.addressbookappspring.model.AddressBookData;

public interface IAddressBookService {
	
	List<AddressBookData> getAddressBookData();
	
	AddressBookData getAddressBookDataById(int id);
	
	AddressBookData updateAddressBookData(AddressBookDTO addressBookDto);
	
	AddressBookData createAddressBookData(AddressBookDTO addressBookDto);
	
	void deleteAddressBookData(int id);

}
