/**
 * 
 */
package com.crs.flipkart.restController;

import java.sql.SQLException;
import java.util.Vector;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.business.RegistrationInterface;
import com.crs.flipkart.business.RegistrationService;
import com.crs.flipkart.exceptions.CourseLimitExceededException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.SeatNotAvailableException;

/**
 * @author LENOVO
 *
 */

@Path("/student")
public class StudentController {
	
	RegistrationInterface registrationInterface = RegistrationService.getInstance();
	
	
	@POST
	@Path("/registerCourses/{course1}/{course2}/{course3}/{course4}/{course5}/{course6}/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCourses(
			@PathParam("course1") int course1,
			@PathParam("course2") int course2,
			@PathParam("course3") int course3,
			@PathParam("course4") int course4,
			@PathParam("course5") int course5,
			@PathParam("course6") int course6,
			@PathParam("studentId") int studentId)	throws SQLException, CourseLimitExceededException, SeatNotAvailableException, CourseNotFoundException{
						
		try
		{
			Vector<Course> availableCourseList = registrationInterface.viewCourses(studentId);
			Vector<Integer> courseList = new Vector<Integer>();
			
			courseList.add(course1);
			courseList.add(course2);
			courseList.add(course3);
			courseList.add(course4);
			courseList.add(course5);
			courseList.add(course6);

			for(int courseCode:courseList)
				registrationInterface.addCourse(courseCode, studentId, availableCourseList);
			
			registrationInterface.setRegistrationStatus(studentId);
			
		} catch (SQLException e) {
			return Response.status(500).entity("Error : " + e).build();
		} catch (SeatNotAvailableException e) {
			return Response.status(500).entity("Error : " + e).build();
		} catch (CourseLimitExceededException e) {
			return Response.status(500).entity("Error : " + e).build();
		} catch (CourseNotFoundException e) {
			return Response.status(500).entity("Error : " + e).build();
		}
					
		
		return Response.status(201).entity( "Registration Successful").build();
		
	}
	
	
	@PUT
	@Path("/addCourse/{courseId}/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(
			@PathParam("courseId") int courseId,
			@PathParam("studentId") int studentId
		) throws CourseLimitExceededException, SeatNotAvailableException, CourseNotFoundException {
		
		Vector<Course> availableCourses = null;
		try {
			availableCourses = registrationInterface.viewCourses(studentId);
			if(availableCourses.size() == 0) {
				return Response.status(200).entity("There are no courses available.").build();
			}
			registrationInterface.addCourse(courseId, studentId, availableCourses);
		} catch(SQLException se) {
			return Response.status(500).entity( "Error : " + se).build();
		} catch (SeatNotAvailableException e) {
			return Response.status(500).entity("Error : " + e).build();
		} catch (CourseLimitExceededException e) {
			return Response.status(500).entity("Error : " + e).build();
		} catch (CourseNotFoundException e) {
			return Response.status(500).entity("Error : " + e).build();
		}
			return Response.status(201).entity( "You have Successfully added Course : " + courseId).build();
		
	}
	
	@DELETE
	@Path("/dropCourse/{courseId}/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(
			@PathParam("courseId") int courseId,
			@PathParam("studentId") int studentId
		) throws CourseNotFoundException {
		
		Vector<Course> registeredCourses = null;
		try {
			registeredCourses = registrationInterface.viewRegisteredCourses(studentId);
			if(registeredCourses.size() == 0) {
				return Response.status(200).entity("There are no registered courses available.").build();
			}
			registrationInterface.dropCourse(courseId, studentId, registeredCourses);
		} catch(SQLException se) {
			return Response.status(500).entity( "Error : " + se).build();
		} catch (CourseNotFoundException e) {
			return Response.status(500).entity("Error : " + e).build();
		}
			return Response.status(201).entity( "You have Successfully droped Course : " + courseId).build();
		
	}
	
	
	@GET
	@Path("/viewAvailableCourses/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector<Course> viewAvailableCourses(
			@PathParam("studentId") int studentId
		) {
		Vector<Course> availableCourses = null;
		try {
			availableCourses = registrationInterface.viewCourses(studentId);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return availableCourses;
	}
	
	
	@GET
	@Path("/viewRegisteredCourses/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector<Course> viewRegisteredCourses(
			@PathParam("studentId") int studentId
		) {
		Vector<Course> registeredCourses = null;
		try {
			registeredCourses = registrationInterface.viewRegisteredCourses(studentId);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return registeredCourses;
	}

}
