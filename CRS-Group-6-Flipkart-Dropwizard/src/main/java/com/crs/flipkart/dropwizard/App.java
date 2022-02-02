package com.crs.flipkart.dropwizard;

/**
 * Hello world!
 *
 */

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crs.flipkart.restController.AdminController;
import com.crs.flipkart.restController.ProfessorController;
import com.crs.flipkart.restController.StudentController;
import com.crs.flipkart.restController.UserController;

/*
 * This is the App file which extends the application configuration class
 * which contains both configuration and environment and using environment 
 * we can register each controllers.
 */

public class App extends Application<Configuration> {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
    	logger.info("Registering REST resources");
    	
    	//Student Controller register
        e.jersey().register(new StudentController());
        
        //Admin Controller register
        e.jersey().register(new AdminController());
        
        //User Controller register
        e.jersey().register(new UserController());
        
        //Professor Controller register
        e.jersey().register(new ProfessorController());

    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}