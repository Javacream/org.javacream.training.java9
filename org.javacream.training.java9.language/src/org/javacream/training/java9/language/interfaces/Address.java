package org.javacream.training.java9.language.interfaces;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	private String city;
	private String street;
	public String getCity() {
		return city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}
	public String getStreet() {
		return street;
	}
}
