/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author LENOVO
 *
 */
public class Cheque {
	private String bankName;
	private String ifscCode;
	private String bandAccountHolderName;
	private int bandAccountNumber;
	private String bankBranchName;
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getIfscCode() {
		return ifscCode;
	}
	
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	public String getBandAccountHolderName() {
		return bandAccountHolderName;
	}
	
	public void setBandAccountHolderName(String bandAccountHolderName) {
		this.bandAccountHolderName = bandAccountHolderName;
	}
	
	public int getBandAccountNumber() {
		return bandAccountNumber;
	}
	
	public void setBandAccountNumber(int bandAccountNumber) {
		this.bandAccountNumber = bandAccountNumber;
	}
	
	public String getBankBranchName() {
		return bankBranchName;
	}
	
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
}
