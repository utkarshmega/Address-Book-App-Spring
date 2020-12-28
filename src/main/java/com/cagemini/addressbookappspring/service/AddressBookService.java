package com.cagemini.addressbookappspring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cagemini.addressbookappspring.dto.AddressBookDTO;
import com.cagemini.addressbookappspring.exceptions.AddressBookException;
import com.cagemini.addressbookappspring.model.AddressBookData;
import com.cagemini.addressbookappspring.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookData> getAddressBookContactData() {
		return (List<AddressBookData>) addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookContactDataById(int id) {
		try {
			AddressBookData contactData = addressBookRepository.findById(id).get();
			return contactData;
		} catch (NoSuchElementException exception) {
			throw new AddressBookException("Address Book Contact Not Found");
		}
	}

	@Override
	public AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressBookDTO);
		return addressBookRepository.save(contactData);
	}

	@Override
	public AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookContactDataById(id);
		if (contactData != null) {
			deleteAddressBookContactData(id);
			BeanUtils.copyProperties(addressBookDTO, contactData);
//			contactData.setFullName(addressBookDTO.getFullName());
//			contactData.setAddress(addressBookDTO.getAddress());
//			contactData.setCity(addressBookDTO.getCity());
//			contactData.setState(addressBookDTO.getState());
//			contactData.setZip(addressBookDTO.getZip());
//			contactData.setPhoneNumber(addressBookDTO.getPhoneNumber());
			contactData = addressBookRepository.save(contactData);
		}
		return contactData;
	}

	@Override
	public void deleteAddressBookContactData(int id) {
		addressBookRepository.deleteById(id);
	}

}
