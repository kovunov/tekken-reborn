package com.cpan252.tekkenreborn.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.tekkenreborn.model.dto.FighterSearchByDateDto;
import com.cpan252.tekkenreborn.repository.FighterRepository;

@Controller
@RequestMapping("/fighterlist")
public class FighterListController {
    private FighterRepository fighterRepository;

    public FighterListController(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    @GetMapping
    public String showFighters(Model model) {
        return "fighterlist";
    }

    @ModelAttribute
    public void fighters(Model model) {
        model.addAttribute("fighters", fighterRepository.findAll());
    }

    @ModelAttribute
    public void fightersByDateDto(Model model) {
        model.addAttribute("fightersByDateDto", new FighterSearchByDateDto());
    }

    @PostMapping
    public String searchFightersByDate(@ModelAttribute FighterSearchByDateDto fightersByDateDto,
            Model model) {
        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("fighters", fighterRepository.findByNameStartsWithAndCreatedAtBetween(
                fightersByDateDto.getName(), LocalDate.parse(fightersByDateDto.getStartDate(), dateFormatter),
                LocalDate.parse(fightersByDateDto.getEndDate(), dateFormatter)));
        return "fighterlist";
    }

}
