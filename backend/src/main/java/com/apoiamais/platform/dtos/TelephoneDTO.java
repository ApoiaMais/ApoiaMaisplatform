package com.apoiamais.platform.dtos;

import com.apoiamais.platform.entities.Telephone;

public class TelephoneDTO {

    private Long id;
    private String ddd;
    private String number;
    private Long userId;
    
    public TelephoneDTO() {
    }

   

    public TelephoneDTO(Long id, String ddd, String number, Long userId) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.userId = userId;
	}



	public TelephoneDTO(Telephone telephone) {
        this.id = telephone.getId();
        this.ddd = telephone.getDdd();
        this.number = telephone.getNumber();
        this.userId = telephone.getUser().getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    

    
}
