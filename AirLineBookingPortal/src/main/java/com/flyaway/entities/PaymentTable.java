package com.flyaway.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "paymenttable")
public class PaymentTable {
	@Column (name = "ID")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id ;	
	
	@Column (name = "BOOKING_ID")
	String bookingID;
	
	@Column (name = "FIRST_NAME")
	String firstName;
	
	@Column (name = "LAST_NAME")
	String lastName;
	
	@Column (name = "TRANSACTION_ID")
	String transactionId;
	
	@Column (name = "CREDIT_CARD_DIGITS")
	String cardDigits;
	
	@Column (name = "STATUS")
	String status;
	
	@Column (name = "PAID_AMOUNT")
	BigDecimal paidAmount;
	
	@Column (name = "TIME_STAMP")
	Timestamp timeStamp;

	public PaymentTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentTable(Long id, String bookingID, String firstName, String lastName, String transactionId,
			String cardDigits, String status, BigDecimal paidAmount, Timestamp timeStamp) {
		super();
		this.id = id;
		this.bookingID = bookingID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.transactionId = transactionId;
		this.cardDigits = cardDigits;
		this.status = status;
		this.paidAmount = paidAmount;
		this.timeStamp = timeStamp;
	}
	
	public PaymentTable(String bookingID, String firstName, String lastName, String transactionId,
			String cardDigits, String status, BigDecimal paidAmount, Timestamp timeStamp) {
		super();		
		this.bookingID = bookingID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.transactionId = transactionId;
		this.cardDigits = cardDigits;
		this.status = status;
		this.paidAmount = paidAmount;
		this.timeStamp = timeStamp;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCardDigits() {
		return cardDigits;
	}

	public void setCardDigits(String cardDigits) {
		this.cardDigits = cardDigits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "PaymentTable [id=" + id + ", bookingID=" + bookingID + ", firstName=" + firstName + ", lastName="
				+ lastName + ", transactionId=" + transactionId + ", cardDigits=" + cardDigits + ", status=" + status
				+ ", paidAmount=" + paidAmount + ", timeStamp=" + timeStamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingID, cardDigits, firstName, id, lastName, status, transactionId, paidAmount, timeStamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentTable other = (PaymentTable) obj;
		return Objects.equals(bookingID, other.bookingID) && Objects.equals(cardDigits, other.cardDigits)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(status, other.status)
				&& Objects.equals(transactionId, other.transactionId) && Objects.equals(paidAmount, other.paidAmount)
				 && Objects.equals(timeStamp, other.timeStamp);
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	

}
