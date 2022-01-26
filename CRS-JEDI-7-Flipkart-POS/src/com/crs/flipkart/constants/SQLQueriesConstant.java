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
	public static final String VIEW_COURSES_GRADE = "select courseId, gpa from gradecard where studentId = ? and semesterId = ?";
	
	
	/**
	 * StudentDaoQueries
	 */
	public static final String VIEW_AVAILABLE_COURSES = "select * from Course where courseSeats > 0 and courseId not in (select courseId from registeredCourse where studentId = ?)";
	public static final String TOTAL_REGISTERED_COURSES = "select courseId from registeredCourse where studentId = ?";
	public static final String AVAILABLE_SEATS = "select courseSeats from Course where courseId = ?";
	public static final String ADD_COURSE = "insert into registeredcourse (studentId,courseId) values ( ? , ?)";
	public static final String DECREMENT_SEAT = "update Course set courseSeats = courseSeats-1 where courseId = ? ";
	public static final String DROP_COURSE = "delete from registeredcourse where studentId = ? AND courseId = ?";
	public static final String INCREMENT_SEAT = "update Course set courseSeats = courseSeats+1 where courseId = ? ";
	public static final String VIEW_REGISTERED_COURSES = "select * from Course inner join registeredCourse on Course.courseId = registeredCourse.courseId where registeredCourse.studentId = ?";
	public static final String CHECK_STUDENT_AND_SEM = "select studentId from semesterRegistration where studentId = ? and semester = ?";
	public static final String ADD_SEMESTER = "insert into semesterRegistration(semesterId, studentId, semester, date) values (?,?,?,curdate())";



}
