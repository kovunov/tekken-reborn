package com.cpan252.tekkenreborn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(TekkenrebornApplication.class, args);
	}

}
