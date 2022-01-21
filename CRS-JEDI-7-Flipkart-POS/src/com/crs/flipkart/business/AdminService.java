/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;

/**
 * @author LENOVO
 *
 */

public class AdminService {
	
	Student student[] = new Student[] {new Student("ssahay", "shambhavi.sahay@flipkart.com", "ABCD", "student", 1,
			"1234567890", "female", "jaipur", "CS", 101, 123, false), new Student("heroku", "heroku@flipkart.com", "ABCD", "student", 1,
					"1234567890", "female", "jaipur", "CS", 102, 123, false), new Student("mymyaway", "mymyaway@flipkart.com", "ABCD", "student", 1,
							"1234567890", "female", "jaipur", "CS", 103, 123, false)};
	
	public boolean approveStudentRegistration(int studentId) {
		for(int i=0;i<student.length;i++) {
			if(student[i].getStudentId() == studentId) {
				return false;
			}
		}
		return true;
	}
}
