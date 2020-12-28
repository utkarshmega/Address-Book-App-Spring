package com.cagemini.addressbookappspring.dto;

import lombok.Data;

public @Data class AddressBookDTO {

	private String fullName;

	private String address;

	private String city;

	private String state;

	private String zip;

	private String phoneNumber;

	public AddressBookDTO(String fullName, String address, String city, String state, String zip, String phoneNumber) {
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public AddressBookDTO() {

	}

}
