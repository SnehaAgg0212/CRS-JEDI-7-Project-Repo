/**
 * 
 */

/**
 * @author LENOVO
 *
 */
package com.crs.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.crs.flipkart.restController.AdminRestAPI;
import com.crs.flipkart.restController.ProfessorRestAPI;
import com.crs.flipkart.restController.StudentRestAPI;
import com.crs.flipkart.restController.UserRestAPI;

public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

		register(StudentRestAPI.class);
		register(ProfessorRestAPI.class);
		register(AdminRestAPI.class);
		register(UserRestAPI.class);

	}

}