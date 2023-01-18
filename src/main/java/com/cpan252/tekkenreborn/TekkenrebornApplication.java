package com.cpan252.tekkenreborn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cpan252.tekkenreborn.controller.HomeController;

/**
 * mvn spring-boot:run does following steps
 * 1. mvn clean
 * 2. mvn compile
 * 3. mvn package
 * 4. java -jar target/tekkenreborn-0.0.1-SNAPSHOT.jar
 * 5. deploys jar to embedded tomcat
 */
@SpringBootApplication
public class TekkenrebornApplication {

	/**
	 * This is the main method that starts the application
	 * Spring Application Context is created here
	 * You can configure your application properties using @param args
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TekkenrebornApplication.class, args);
		HomeController controller = context.getBean(HomeController.class);
	}

}
