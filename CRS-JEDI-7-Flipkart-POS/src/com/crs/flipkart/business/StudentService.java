/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.StudentDaoOperation;

/**
 * @author devanshugarg, iamshambhavi
 *
 */
public class StudentService implements StudentInterface {
	
	StudentDaoOperation studentDaoOperation = new StudentDaoOperation();

	@Override
	public String register(String userName, String userEmailId, String userPassword, int userId, String phoneNo,
			String gender, String address, String branch, int batch) {

		Student student = new Student(userName, userEmailId, userPassword, "STUDENT", 
				userId, phoneNo, gender, address, branch, userId, batch, false);
		
		String studentId = "";
		
		System.out.println("Your account has been created and pending for Approval by the Admin.\n");
		studentId = studentDaoOperation.addStudent(student);

		return studentId;
	}
	
	@Override
	public String getStudentId(String userId) {
		
		return studentDaoOperation.getStudentId(userId);
	}
	
	@Override
	public Boolean isApproved(String studentId) {
		
		return studentDaoOperation.isApproved(studentId);
	}
}
