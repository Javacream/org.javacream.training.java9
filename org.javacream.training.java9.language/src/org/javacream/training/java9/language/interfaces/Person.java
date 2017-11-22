package org.javacream.training.java9.language.interfaces;

public class Person implements Addressable{
	private String name;
	private Address address;
	public Person(String name) {
		super();
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	
	

}
