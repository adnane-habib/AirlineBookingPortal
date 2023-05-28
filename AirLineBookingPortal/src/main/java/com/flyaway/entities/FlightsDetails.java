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
@Table (name = "flights_details")
public class FlightsDetails {
	@Column (name = "ID")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id ;
	
	@Column (name = "MONTH")
	Integer month;
	
	@Column (name = "DAY")
	Integer day;
	
	@Column (name = "DAY_OF_WEEK")
	Integer dayOfWeek;

	@Column (name = "AIRLINE")
	String airLine;
	
	@Column (name = "FLIGHT_NUMBER")
	Integer flightNumber;
	
	@Column (name = "ORIGIN_AIRPORT")
	String originAirport;
	
	@Column (name = "DESTINATION_AIRPORT")
	String destinationAirport;

	@Column (name = "SCHEDULED_DEPARTURE")
	Integer scheduledDeparture;
	
	@Column (name = "SCHEDULED_ARRIVAL")
	Integer scheduledArrival;
	
	@Column (name = "SCHEDULED_TIME")
	Integer scheduledTime;
	
	@Column (name = "TICKET_PRICE")
	BigDecimal ticketPrice;
	
	@Column (name = "FREE_SEATS")
	Integer freeSeats;

	public FlightsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightsDetails(Long id, Integer month, Integer day, Integer dayOfWeek, String airLine, Integer flightNumber,
			String originAirport, String destinationAirport, Integer scheduledDeparture, Integer scheduledArrival,
			Integer scheduledTime, BigDecimal ticketPrice, Integer freeSeats) {
		super();
		this.id = id;
		this.month = month;
		this.day = day;
		this.dayOfWeek = dayOfWeek;
		this.airLine = airLine;
		this.flightNumber = flightNumber;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.scheduledDeparture = scheduledDeparture;
		this.scheduledArrival = scheduledArrival;
		this.scheduledTime = scheduledTime;
		this.ticketPrice = ticketPrice;
		this.freeSeats = freeSeats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getAirLine() {
		return airLine;
	}

	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Integer getScheduledDeparture() {
		return scheduledDeparture;
	}

	public void setScheduledDeparture(Integer scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}

	public Integer getScheduledArrival() {
		return scheduledArrival;
	}

	public void setScheduledArrival(Integer scheduledArrival) {
		this.scheduledArrival = scheduledArrival;
	}

	public Integer getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Integer scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getFreeSeats() {
		return freeSeats;
	}

	public void setFreeSeats(Integer freeSeats) {
		this.freeSeats = freeSeats;
	}

	@Override
	public String toString() {
		return "FlightsDetails [id=" + id + ", month=" + month + ", day=" + day + ", dayOfWeek=" + dayOfWeek
				+ ", airLine=" + airLine + ", flightNumber=" + flightNumber + ", originAirport=" + originAirport
				+ ", destinationAirport=" + destinationAirport + ", scheduledDeparture=" + scheduledDeparture
				+ ", scheduledArrival=" + scheduledArrival + ", scheduledTime=" + scheduledTime + ", ticketPrice="
				+ ticketPrice + ", freeSeats=" + freeSeats ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airLine, day, dayOfWeek, destinationAirport, flightNumber, freeSeats, id, month,
				originAirport, scheduledArrival, scheduledDeparture, scheduledTime, ticketPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightsDetails other = (FlightsDetails) obj;
		return Objects.equals(airLine, other.airLine) && day == other.day && dayOfWeek == other.dayOfWeek
				&& Objects.equals(destinationAirport, other.destinationAirport) && flightNumber == other.flightNumber
				&& freeSeats == other.freeSeats && Objects.equals(id, other.id) && month == other.month
				&& Objects.equals(originAirport, other.originAirport) && scheduledArrival == other.scheduledArrival
				&& scheduledDeparture == other.scheduledDeparture && scheduledTime == other.scheduledTime
				&& ticketPrice == other.ticketPrice;
	}
	
	
	
}
