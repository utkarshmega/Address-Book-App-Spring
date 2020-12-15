package com.cagemini.addressbookappspring.dto;

public class AddressBookDTO {
	
	public String firstName;
	public String lastName;
	public String address;
	
	
	public AddressBookDTO() {
		
	}
	
	public AddressBookDTO(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "AddressBookDTO [First Name: "+firstName +" Last Name: " + lastName + "Address: " + address + "]";
	}

}
