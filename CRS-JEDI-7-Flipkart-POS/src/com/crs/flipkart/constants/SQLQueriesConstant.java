/**
 * 
 */
package com.crs.flipkart.constants;

/**
 * @author devanshugarg
 *
 */
public class SQLQueriesConstant {

	/**
	 * AdminDaoQueries
	 */
	public static final String ADD_USER_QUERY = "insert into User(userId, userName, userEmailId, userPassword, role, phoneNo, gender, address) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String ADD_PROFESSOR_QUERY = "insert into Professor(userId, professorId, department, designation) values (?, ?, ?, ?)";
	public static final String VIEW_PROFESSOR_QUERY = "select professorId, userName, gender, department, designation from Professor P natural join User U where P.userId = U.userId";
	public static final String DELETE_PROFESSOR_QUERY = "delete from Professor where professorId = ?";
	public static final String ADD_COURSE_QUERY = "insert into Course(courseId, courseName, courseDescription, courseFee, courseSeats) values (?, ?, ?, ?, ?)";
	public static final String VIEW_COURSE_QUERY = "select courseCode, courseName, courseDescription, courseFee, courseSeats from Course";
	public static final String DELETE_COURSE_QUERY = "delete from Course where courseId = ?";
	public static final String APPROVE_STUDENT_QUERY = "update Student set isApproved = 1 where studentId = ?";
	public static final String GET_STUDENT_ID = "select studentId from student where userId = ?";
	public static final String GET_PROFESSOR_ID = "select professorId from professor where userId = ?";
	public static final String IS_APPROVED = "select isApproved from student where studentId = ?";
}
