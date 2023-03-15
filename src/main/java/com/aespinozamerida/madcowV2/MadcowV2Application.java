package com.aespinozamerida.madcowV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//The @SpringBootApplication is a convenience annotation that combines the following annotations:
//
//@Configuration: Indicates that the class is a source of
// bean definitions for the application context.

//@EnableAutoConfiguration: Enables auto-configuration of
// the Spring Application Context, attempting to guess and
// configure beans that you are likely to need.

//@ComponentScan: Tells Spring to look for other components,
// configurations, and services in the default package or
// the package of the annotated class.
@SpringBootApplication
public class MadcowV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MadcowV2Application.class, args);
	}

}
