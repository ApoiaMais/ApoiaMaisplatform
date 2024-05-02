package com.apoiamais.platform.entities;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_telephone")
public class Telephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddd;
	private String number;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Telephone() {
	
	}
	
	public Telephone(Long id, String ddd, String number) {
		
		this.id = id;
		this.ddd = ddd;
		this.number = number;
	}
	
	
	public Telephone(Long id, String ddd, String number, User user) {
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String string) {
		this.ddd = string;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telephone other = (Telephone) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
