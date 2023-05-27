package com.flyaway.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "airports_details")
public class AirportsDetails {
	@Column (name = "ID")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id ;
	
	@Column (name = "iata_code")
	String iataCode;
	
	@Column (name = "City")
	String city;
	
	@Column (name = "airport_name")
	String airportName;
	
	@Column (name = "country_code")
	String countryCode;

	public AirportsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirportsDetails(Long id, String iataCode, String city, String airportName, String countryCode) {
		super();
		this.id = id;
		this.iataCode = iataCode;
		this.city = city;
		this.airportName = airportName;
		this.countryCode = countryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "AiportsDetails [id=" + id + ", iataCode=" + iataCode + ", city=" + city + ", airportName=" + airportName
				+ ", countryCode=" + countryCode + ", getId()=" + getId() + ", getIataCode()=" + getIataCode()
				+ ", getCity()=" + getCity() + ", getAirportName()=" + getAirportName() + ", getCountryCode()="
				+ getCountryCode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(airportName, city, countryCode, iataCode, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirportsDetails other = (AirportsDetails) obj;
		return Objects.equals(airportName, other.airportName) && Objects.equals(city, other.city)
				&& Objects.equals(countryCode, other.countryCode) && Objects.equals(iataCode, other.iataCode)
				&& Objects.equals(id, other.id);
	}


	
	
	
	
	
}
