/**
 * 
 */
package com.crs.flipkart.business;

/**
 * @author iamshambhavi
 *
 */
public interface StudentInterface {

	/**
	 * @param userName
	 * @param userEmailId
	 * @param userPassword
	 * @param userId
	 * @param phoneNo
	 * @param gender
	 * @param address
	 * @param branchName
	 * @param studentId
	 * @param batch
	 */
	public String register(String userName, String userEmailId, String userPassword, int userId, String phoneNo,
			String gender, String address, String branchName, int batch);
	
	/**
     * @param userId
     * @return Student ID
     */
    public String getStudentId(String userId);
    
    /**
     * @param userId
     * @return true/false indicating if student registration approved by admin
     */
    public Boolean isApproved(String studentId);
    
}
