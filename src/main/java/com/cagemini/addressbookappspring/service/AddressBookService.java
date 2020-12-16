package com.cagemini.addressbookappspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cagemini.addressbookappspring.dto.AddressBookDTO;
import com.cagemini.addressbookappspring.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> contactData = new ArrayList<>();
		contactData.add(new AddressBookData(1, new AddressBookDTO("Utkarsh", "Agrawal","8 chowk")));
		return contactData;		
	}
	
	@Override
	public AddressBookData getAddressBookDataById(int id) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Utkarsh", "Agrawal","8 chowk"));
		return contactData;
	}
	
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO)
	{
		AddressBookData contactData;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}
	
	@Override
	public AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1,addressBookDTO);
		return contactData;
	}

	@Override
	public void deleteAddressBookData(int id) {

	}

}
