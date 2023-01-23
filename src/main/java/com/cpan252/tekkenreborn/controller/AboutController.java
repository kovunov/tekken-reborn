package com.cpan252.tekkenreborn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * This request mapping annotation shows that all requests to the /about
 * endpoint will be mapped to
 * this controller
 */
@RequestMapping("/about")
/**
 * Devtools in Spring help us with 3 most important things
 * 1. Auto reload the application when there are changes to the application code
 * 2. It includes LiveReload server, so we can reload the html pages when changed
 * 3. It also includes H2 console for debugging
 * 4. It disables caching of the templates so we don't need to empty cache on reload
 * 5. Devtools are autodisabled in production so we don't need to disable them manually
 */
public class AboutController {

    @GetMapping
    public String about() {
        return "about";
    }
}
