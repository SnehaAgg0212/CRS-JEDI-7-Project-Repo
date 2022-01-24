/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author LENOVO
 *
 */
public class NetBanking extends Payment {
	
	private String bankName;
	private String bankAccountNumber;
	private String bankAccountHolderName;
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public String getBankAccountHolderName() {
		return bankAccountHolderName;
	}
	
	public void setBankAccountHolderName(String bankAccountHolderName) {
		this.bankAccountHolderName = bankAccountHolderName;
	}
	
}
