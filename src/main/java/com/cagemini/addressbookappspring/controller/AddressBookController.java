package com.cagemini.addressbookappspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cagemini.addressbookappspring.dto.AddressBookDTO;
import com.cagemini.addressbookappspring.dto.ResponseDTO;
import com.cagemini.addressbookappspring.model.AddressBookData;
import com.cagemini.addressbookappspring.service.IAddressBookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "API for controller class")
@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping(value = "/addressbookservice")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;
	
	@ApiOperation(value = "Api for getting all data from the database")
	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookContactData() {
		List<AddressBookData> contactDataList = addressBookService.getAddressBookContactData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contactDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Api for getting data based on ID")
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookContactData(@PathVariable("id") int id) {
		AddressBookData contactData = null;
		contactData = addressBookService.getAddressBookContactDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull for id: " + id, contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Api for adding new person to the database")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookContactData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = addressBookService.createAddressBookContactData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Address Book Contact Data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Api for updating person based on id")
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookContactData(@PathVariable("id") int id,
			@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = addressBookService.updateAddressBookContactData(id, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Contact Data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Api for deleting person from the database")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookContactData(@PathVariable("id") int id) {
		addressBookService.deleteAddressBookContactData(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Address Book Contact Data Successfully",
				"Deleted id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
