package com.apoiamais.platform.dtos;

import com.apoiamais.platform.entities.Address;

public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private Long userId;
    
    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String city, Long userId) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.userId = userId;
    }

    public AddressDTO(Address entity) {
        this.id = entity.getId();
        this.street = entity.getStreet();
        this.city = entity.getCity();
        this.userId = entity.getUser().getId();
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    
    
}
