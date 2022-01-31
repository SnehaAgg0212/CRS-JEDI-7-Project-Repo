/**
 * 
 */
package com.crs.flipkart.restController;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author devanshugarg
 *
 */
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

		register(StudentRestAPI.class);
		register(UserRestAPI.class);
		register(ProfessorRestAPI.class);
		register(AdminRestAPI.class);

	}
}
