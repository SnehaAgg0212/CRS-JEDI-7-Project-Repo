/**
 * 
 */
package com.crs.flipkart.bean;
import java.util.Date;
/**
 * @author LENOVO
 *
 */

enum CardType{
	DEBIT, CREDIT;
}
public class CardPayment extends Payment {
	private CardType cardType;
	private int cardNumber;
	private int cvvNumber;
	private String bankName; 
	private Date expiryDate;
	
	public CardType getCardType() {
		return cardType;
	}
	
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getCvvNumber() {
		return cvvNumber;
	}
	
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}
