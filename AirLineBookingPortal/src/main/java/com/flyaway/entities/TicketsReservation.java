package com.flyaway.entities;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;

@Entity
@Table (name = "ticketsreservation")
public class TicketsReservation {
	public static final String STATUSRESERVED = "RESERVED";
	public static final String STATUSPAID = "PAID";
	public static final String STATUSCANCELLED = "CANCELLED";
	
	@Column (name = "ID")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id ;
	
	@Column (name = "MONTH")
	Integer month;
	
	@Column (name = "DAY")
	Integer day;
	
	@Column (name = "BOOKING_ID")
	String bookingID;
	
	@Column (name = "FLIGHT_ID")
	Long flightID;
	
	@Column (name = "FIRST_NAME")
	String firstName;
	
	@Column (name = "LAST_NAME")
	String lastName;
	
	@Column (name = "DATE_OF_BIRTH", nullable = true)
	String birthDate;
	
	@Column (name = "ID_EXPIRY_DATE", nullable = true)
	String idDate;
	
	@Column (name = "PHONE_NUMBER", nullable = true)
	String phoneNumber;
	
	@Column (name = "ID_NUMBER")
	String idNumber;
	
	@Column (name = "CITIZERNSHIP", nullable = true)
	String citizenship;
	
	@Column (name = "FLIGHT_NUMBER")
	String flightNumber;
	
	@Column (name = "TICKET_PRICE")
	BigDecimal ticketPrice;
	
	@Column (name = "TIME")
	Integer time;
	
	@Column (name = "STATUS")
	String status;
	
	

	public TicketsReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketsReservation(Long id, Integer month, Integer day, String bookingID, Long flightID, String firstName, String lastName,
			String birthDate, String idDate, String phoneNumber, String idNumber, String citizenship, String flightNumber,
			Integer time, String status, BigDecimal ticketPrice) {
		super();
		this.id = id;
		this.month = month;
		this.day = day;
		this.bookingID = bookingID;
		this.flightID = flightID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.idDate = idDate;
		this.phoneNumber = phoneNumber;
		this.idNumber = idNumber;
		this.citizenship = citizenship;
		this.flightNumber = flightNumber;
		this.time = time;
		this.status = status;
		this.ticketPrice = ticketPrice;
	}
	
	public TicketsReservation(Integer month, Integer day, String bookingID, Long flightID, String firstName, String lastName,
			String birthDate, String idDate, String phoneNumber, String idNumber, String citizenship, String flightNumber,
			Integer time, String status, BigDecimal ticketPrice) {
		super();
		//this.id = id;
		this.month = month;
		this.day = day;
		this.bookingID = bookingID;
		this.flightID = flightID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.idDate = idDate;
		this.phoneNumber = phoneNumber;
		this.idNumber = idNumber;
		this.citizenship = citizenship;
		this.flightNumber = flightNumber;
		this.time = time;
		this.status = status;
		this.ticketPrice = ticketPrice;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getFlightID() {
		return flightID;
	}

	public void setFlightID(Long flightID) {
		this.flightID = flightID;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdDate() {
		return idDate;
	}

	public void setIdDate(String idDate) {
		this.idDate = idDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "TicketsReservation [id=" + id + ", month=" + month + ", day=" + day + ", bookingID=" + bookingID + ", flightID=" + flightID
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", idDate="
				+ idDate + ", phoneNumber=" + phoneNumber + ", idNumber=" + idNumber + ", citizenship=" + citizenship
				+ ", flightNumber=" + flightNumber + ", time=" + time + ", status=" + status + ", ticketPrice=" + ticketPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, bookingID, flightID, citizenship, day, firstName, flightNumber, id, idDate, idNumber,
				lastName, month, phoneNumber, status, time, ticketPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketsReservation other = (TicketsReservation) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(bookingID, other.bookingID) && Objects.equals(flightID, other.flightID)
				&& Objects.equals(citizenship, other.citizenship) && Objects.equals(day, other.day)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(flightNumber, other.flightNumber)
				&& Objects.equals(id, other.id) && Objects.equals(idDate, other.idDate)
				&& Objects.equals(idNumber, other.idNumber) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(month, other.month) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(status, other.status) && Objects.equals(time, other.time) && Objects.equals(ticketPrice, other.ticketPrice);
	}
	
	
	
	

}
