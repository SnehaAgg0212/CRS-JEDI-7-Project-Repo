/**
 * 
 */
package com.crs.flipkart.bean;

import java.util.Date;

/**
 * @author devanshugarg
 *
 */
public class Cheque extends Payment {
	
	private String bandAccountHolderName;
	private int bandAccountNumber;
	private String ifsc;
	private String bankName;
	private String bankBranchName;
	private int chequeNo;
	private Date chequeDate;
	
	/**
	 * Default Constructor
	 */
	public Cheque() {
		
	}

	/**
	 * @param studentId
	 * @param invoiceId
	 * @param status
	 * @param amount
	 * @param bandAccountHolderName
	 * @param bandAccountNumber
	 * @param ifsc
	 * @param bankName
	 * @param bankBranchName
	 * @param chequeNo
	 * @param chequeDate
	 */
	public Cheque(int studentId, int invoiceId, boolean status, double amount, String bandAccountHolderName,
			int bandAccountNumber, String ifsc, String bankName, String bankBranchName, int chequeNo, Date chequeDate) {
		super(studentId, invoiceId, status, amount);
		this.bandAccountHolderName = bandAccountHolderName;
		this.bandAccountNumber = bandAccountNumber;
		this.ifsc = ifsc;
		this.bankName = bankName;
		this.bankBranchName = bankBranchName;
		this.chequeNo = chequeNo;
		this.chequeDate = chequeDate;
	}

	/**
	 * @return the bandAccountHolderName
	 */
	public String getBandAccountHolderName() {
		return bandAccountHolderName;
	}

	/**
	 * @param bandAccountHolderName the bandAccountHolderName to set
	 */
	public void setBandAccountHolderName(String bandAccountHolderName) {
		this.bandAccountHolderName = bandAccountHolderName;
	}

	/**
	 * @return the bandAccountNumber
	 */
	public int getBandAccountNumber() {
		return bandAccountNumber;
	}

	/**
	 * @param bandAccountNumber the bandAccountNumber to set
	 */
	public void setBandAccountNumber(int bandAccountNumber) {
		this.bandAccountNumber = bandAccountNumber;
	}

	/**
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
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

	/**
	 * @return the bankBranchName
	 */
	public String getBankBranchName() {
		return bankBranchName;
	}

	/**
	 * @param bankBranchName the bankBranchName to set
	 */
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	/**
	 * @return the chequeNo
	 */
	public int getChequeNo() {
		return chequeNo;
	}

	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * @return the chequeDate
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * @param chequeDate the chequeDate to set
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}
	
}
