/**
 * 
 */
package com.crs.flipkart.bean;
import java.util.Date;
/**
 * @author devanshugarg
 *
 */

enum CardType{
	DEBIT, CREDIT;
}

public class CardPayment extends Payment {
	
	private CardType cardType;
	private int cardNumber;
	private String cardHolderName;
	private Date expiryDate;
	private int cvv;
	private String bankName; 
	
	/**
	 * Default Constructor
	 */
	public CardPayment() {
		
	}

	/**
	 * @param studentId
	 * @param invoiceId
	 * @param status
	 * @param amount
	 * @param cardType
	 * @param cardNumber
	 * @param cardHolderName
	 * @param expiryDate
	 * @param cvv
	 * @param bankName
	 */
	public CardPayment(int studentId, int invoiceId, boolean status, double amount, CardType cardType, int cardNumber,
			String cardHolderName, Date expiryDate, int cvv, String bankName) {
		super(studentId, invoiceId, status, amount);
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.bankName = bankName;
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the cvv
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
