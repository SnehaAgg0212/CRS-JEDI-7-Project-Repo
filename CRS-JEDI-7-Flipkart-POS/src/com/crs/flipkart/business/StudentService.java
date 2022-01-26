/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.GenderConstant;
import com.crs.flipkart.constants.RoleConstant;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;

/**
 * @author devanshugarg, iamshambhavi
 *
 */
public class StudentService implements StudentInterface {
	
	StudentDaoInterface studentDaoOperation = new StudentDaoOperation();

	@Override
	public int register(String userName, String userEmailId, String userPassword, int userId, String phoneNo,
			GenderConstant gender, String address, String branch, int batch) {
				
		Student student = new Student(userName, userEmailId, userPassword, RoleConstant.STUDENT, 
 				userId, phoneNo, gender, address, branch, userId, batch, false);

 		int studentId = 0;

 		System.out.println("Your account has been created and pending for Approval by the Admin.");
 		studentId = studentDaoOperation.addStudent(student);

 		return studentId;
	}
	
	@Override
	public int getStudentId(int userId) {
		
		return studentDaoOperation.getStudentId(userId);
	}
	
	@Override
	public Boolean isApproved(int studentId) {
		
		return studentDaoOperation.isApproved(studentId);
	}
}
