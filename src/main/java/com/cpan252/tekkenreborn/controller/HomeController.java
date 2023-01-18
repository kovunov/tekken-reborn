package com.cpan252.tekkenreborn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * How applicatiion context and dependency injection works in Spring Boot
 * Bean in Spring Boot is a Java object that is managed by Spring
 * How Spring manages beans:
 * 1. Spring Boot creates an Application Context
 * 2. Spring Boot scans the classpath for beans (annotated with @Component or
 * other Component annotations)
 * 3. Spring Boot creates beans and registers them in the Application Context
 * 
 * Controller annotation is just a specialization of @Component annotation
 * Controller serves as a dispatcher for HTTP requests
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
