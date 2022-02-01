/**
 * 
 */
package com.crs.flipkart.restController;

import java.sql.SQLException;
import java.util.Vector;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.business.RegistrationInterface;
import com.crs.flipkart.business.RegistrationService;

/**
 * @author LENOVO
 *
 */

@Path("/student")
public class StudentController {
	
	RegistrationInterface registrationInterface = RegistrationService.getInstance();
	
	
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
