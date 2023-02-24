package com.cpan252.tekkenreborn.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpan252.tekkenreborn.model.dto.FighterSearchByDateDto;
import com.cpan252.tekkenreborn.repository.FighterRepository;
import com.cpan252.tekkenreborn.repository.FighterRepositoryPaginated;

@Controller
@RequestMapping("/fighterlist")
public class FighterListController {
    private static final int PAGE_SIZE = 5;
    private FighterRepository fighterRepository;

    private FighterRepositoryPaginated fighterRepositoryPaginated;

    public FighterListController(FighterRepository fighterRepository,
            FighterRepositoryPaginated fighterRepositoryPaginated) {
        this.fighterRepository = fighterRepository;
        this.fighterRepositoryPaginated = fighterRepositoryPaginated;
    }

    @GetMapping
    public String showFighters(Model model) {
        return "fighterlist";
    }

    /**
     * This method will allow us to populate the model with initial fighter details
     * 1. We will use the fighterRepositoryPaginated to retrieve the first page of
     * fighters (we set the page size to 5)
     * 
     * @param model
     */
    @ModelAttribute
    public void fighters(Model model) {
        var fighterPage = fighterRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("fighters", fighterPage);
        model.addAttribute("currentPage", fighterPage.getNumber());
        model.addAttribute("totalPages", fighterPage.getTotalPages());
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

    @GetMapping("/switchPage")
    public String switchPage(Model model,
            @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "fighterlist";
        }
        var fighterPage = fighterRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("fighters", fighterPage.getContent());
        model.addAttribute("currentPage", fighterPage.getNumber());
        return "fighterlist";
    }
}
