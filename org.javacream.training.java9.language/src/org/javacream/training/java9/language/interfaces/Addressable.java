package org.javacream.training.java9.language.interfaces;

public interface Addressable {

	Address getAddress();
	
	default String getCity() {
		return getAddress().getCity();
	}
	default String getStreet() {
		return getAddress().getStreet();
	}
	
	default boolean compare(Address toCompare) {
		return compareCityNormalized(toCompare.getCity()) && compareStreetNormalized(toCompare.getStreet());
	}
	
	private boolean compareCityNormalized(String city) {
		return city.toUpperCase().compareTo(getCity().toUpperCase()) == 0;
	}
	private boolean compareStreetNormalized(String street) {
		return street.toUpperCase().compareTo(getStreet().toUpperCase()) == 0;
	}
}
