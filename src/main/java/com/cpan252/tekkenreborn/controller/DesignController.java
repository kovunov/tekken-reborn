package com.cpan252.tekkenreborn.controller;

import java.util.EnumSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.FighterPool;
import com.cpan252.tekkenreborn.model.Fighter.Anime;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequestMapping("/design")
// this indicates that fighterPool has a lifetime of a session
@SessionAttributes("fighterPool")
public class DesignController {

    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void animes(Model model) {
        var animes = EnumSet.allOf(Anime.class);
        model.addAttribute("animes", animes);
        log.info("animes converted to string:  {}", animes);
    }

    /**
     * We are providing fighter pool model, to add
     * fighter to this model and display it on a different page
     * 
     * @return Fighter Pool model that will last a lifetime of a session
     */
    @ModelAttribute(name = "fighterPool")
    public FighterPool fighterPool() {
        return new FighterPool();
    }

    /**
     * 1. We have created a new Fighter object here, to be populated from the form
     * inputs
     * 2. We have to reference the Fighter object properties in the form and bind
     * them to the corresponding inputs
     * 3. We have to submit Form (execute POST request) and make sure fighter
     * details are valid
     * 
     * @return Fighter model that we will need only for request (form) submission
     */
    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Fighter fighter() {
        return Fighter
                .builder()
                .build();
    }

    @PostMapping
    public String processFighterAddition(@Valid Fighter fighter,
            @ModelAttribute FighterPool pool, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        pool.add(fighter);
        return "redirect:/design";
    }

}
