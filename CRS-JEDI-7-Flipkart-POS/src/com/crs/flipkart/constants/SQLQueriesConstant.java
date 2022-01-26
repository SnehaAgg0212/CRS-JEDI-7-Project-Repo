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
	/*
	/ professorDao queries
	*/
	public static final String GET_COURSES="select professor.professorId, course.courseId, course.courseName, course.courseSeats from course INNER JOIN professor where course.courseId=professor.courseId and professorId = ?";
	public static final String GET_ENROLLED_STUDENTS=
			"select professor.professorId, course.courseId as CId,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseId = registeredcourse.courseId INNER JOIN professor on course.courseId = professor.courseId where professor.professorId = ? order by course.courseId";
	public static final String ADD_GRADE="update gradecard set gpa=? where courseId=? and studentId=? and semesterId = ?";
	public static final String GET_PROF_NAME = "SELECT professor.professorId, user.userName FROM user INNER JOIN professor WHERE professorId = ?";
	public static final String ADD_COURSE_TO_PROFESSOR = "update Professor set courseId = ? where professorId = ?";
	public static final String GET_AVAILABLE_COURSES = "select course.courseId, course.courseName, course.courseDescription, course.courseFee, course.courseSeats from course where courseId not in (select courseId from Professor)";
	public static final String CHECK_SELECTED_COURSE = "select courseId from professor where professorId = ?";
}
