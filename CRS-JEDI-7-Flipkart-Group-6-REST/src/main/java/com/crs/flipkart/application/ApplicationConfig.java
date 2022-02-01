/**
 * 
 */

/**
 * @author LENOVO
 *
 */
package com.crs.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.crs.flipkart.restController.StudentController;

public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

	register(StudentController.class);


	}

}