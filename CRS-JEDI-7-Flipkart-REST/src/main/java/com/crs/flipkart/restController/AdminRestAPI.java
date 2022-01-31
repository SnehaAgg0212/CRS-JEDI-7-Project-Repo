/**
 * 
 */
package com.crs.flipkart.restController;

import java.sql.SQLException;
import java.util.Vector;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminInterface;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.NotificationInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.constants.NotificationTypeConstant;
import com.crs.flipkart.exceptions.CourseAlreadyExistsException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.ProfessorNotAddedException;
import com.crs.flipkart.exceptions.ProfessorNotDeletedException;
import com.crs.flipkart.exceptions.ProfessorNotFoundException;
import com.crs.flipkart.exceptions.StudentNotFoundForApprovalException;
import com.crs.flipkart.exceptions.UserIdAlreadyInUseException;

/**
 * @author devanshugarg
 *
 */
@Path("/admin")
public class AdminRestAPI {
	
	AdminInterface adminServices = AdminService.getInstance();
	NotificationInterface notificationService = NotificationService.getInstance();
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/viewPendingAdmissions")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector<Student> viewPendingAdmissions() {
		
		return adminServices.viewPendingAdmissions();
	}

	/**
	 * 
	 * @param professor
	 * @return
	 * @throws ValidationException
	 */
	@POST
	@Path("/addProfessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(@Valid Professor professor) throws ValidationException {
		
		try {
	    	adminServices.addProfessor(professor);
	    	return Response.status(201).entity("Professor with Professor Id: " + professor.getUserId() + " added.").build();
	    } catch (ProfessorNotAddedException e) {
	    	return Response.status(409).entity(e.getMessage()).build();
	    } catch (UserIdAlreadyInUseException e) {
	    	return Response.status(409).entity(e.getMessage()).build();
	    }
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws ValidationException
	 */
	@PUT
	@Path("/approveStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveStudent(
			@Min(value = 1, message = "Student Id should not be less than 1.")
			@Max(value = 4999, message = "Student Id should be less than 5000.")
			@NotNull
			@QueryParam("studentId") int studentId) throws ValidationException {
		
		Vector<Student> pendingStudents = adminServices.viewPendingAdmissions();
		
		try {
			adminServices.approveStudentRegistration(studentId, pendingStudents);
			try {
				int notificationId = notificationService.sendApprovalNotification(NotificationTypeConstant.APPROVAL, studentId);
				return Response.status(201).entity("Notification Id: " + notificationId + "\nStudent with Student Id: " + studentId + " approved.").build();
			} catch (SQLException e) {
				return Response.status(409).entity(e.getMessage()).build();
			}
		} catch (StudentNotFoundForApprovalException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/viewProfessor")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector<Professor> viewProfessor() {
		
		return adminServices.viewProfessor();
	}
	
	/**
	 * 
	 * @param course
	 * @return
	 * @throws ValidationException
	 */
	@POST
	@Path("/addCourseToCatalog")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourseToCatalog(@Valid Course course) throws ValidationException {
		Vector<Course> courseList = adminServices.viewCourse();
		
		try {
			adminServices.addCourse(course, courseList);
			return Response.status(201).entity("Course with Course Code: " + course.getCourseId() + " added to catalog.").build();
		} catch (CourseAlreadyExistsException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}	
	}
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/viewCoursesInCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector<Course> viewCoursesInCatalog() {
		
		return adminServices.viewCourse();
	}
	
	/**
	 * 
	 * @param courseId
	 * @return
	 * @throws ValidationException
	 */
	@PUT
	@Path("/deleteCourseFromCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCourseFromCatalog(
			@Size(min = 4 , max = 10 , message = "Course Code length should be between 4 and 10 characters.")
			@NotNull
			@QueryParam("courseId") int courseId) throws ValidationException {
		Vector<Course> courseList = adminServices.viewCourse();
		
		try {
			adminServices.deleteCourse(courseId, courseList);
			return Response.status(201).entity("Course with Course Code: " + courseId + " deleted from catalog.").build();
		} catch (CourseNotFoundException e) {
			return Response.status(409).entity(e.getMessage()).build();
		} catch (CourseNotDeletedException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}	
	}
	
	/**
	 * 
	 * @param professorId
	 * @return
	 * @throws ValidationException
	 */
	@PUT
	@Path("/deleteProfessor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProfessor(
			@Min(value = 1, message = "Professor Id should not be less than 1.")
			@Max(value = 1999, message = "Professor Id should be less than 2000.")
			@NotNull
			@QueryParam("profesorId") int professorId) throws ValidationException {
		
		try {
	    	adminServices.deleteProfessor(professorId);
	    	return Response.status(201).entity("Professor with Professor Id: " + professorId + " deleted.").build();
	    } catch (ProfessorNotDeletedException e) {
	    	return Response.status(409).entity(e.getMessage()).build();
	    } catch (ProfessorNotFoundException e) {
	    	return Response.status(409).entity(e.getMessage()).build();
	    }
	}
	
	/**
	 * 
	 * @param studentId
	 * @param semester
	 * @return
	 * @throws ValidationException
	 */
	@PUT
	@Path("/generateGradeCard")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response generateGradeCard(
			@Min(value = 1, message = "Student Id should not be less than 1.")
			@Max(value = 4999, message = "Student Id should be less than 5000.")
			@NotNull
			@QueryParam("studentId") int studentId,
			@Min(value = 1, message = "Semester Id should not be less than 1.")
			@Max(value = 10, message = "Student Id should be less than or equal to 10.")
			@NotNull
			@QueryParam("semester") int semester) throws ValidationException {
		
		try {
			adminServices.generateGradeCard(studentId, semester);
			adminServices.setIsGenerateGrade(studentId);
			return Response.status(201).entity("Grade Card generated of Semester: " + semester + " for Student with Student Id: " + studentId + ".").build();
		} catch (Exception e) {
			return Response.status(409).entity(e.getMessage()).build();
		}
	}
}
