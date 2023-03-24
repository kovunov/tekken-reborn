package com.cpan252.tekkenreborn.controller.rest;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.dto.CreateFighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;
import com.cpan252.tekkenreborn.repository.FighterRepositoryPaginated;

import jakarta.validation.Valid;

@RestController
// essentially the full path is http://localhost:8080/api/fighters
@RequestMapping(path = "/api/fighters", produces = "application/json")
public class FighterController {

    private final FighterRepositoryPaginated fighterRepositoryPaginated;

    private final FighterRepository fighterRepository;

    public FighterController(FighterRepositoryPaginated fighterRepositoryPaginated,
            FighterRepository fighterRepository) {
        this.fighterRepositoryPaginated = fighterRepositoryPaginated;
        this.fighterRepository = fighterRepository;
    }

    @GetMapping
    public Iterable<Fighter> allFighters(@RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        if (!page.isPresent() || !size.isPresent()) {
            return fighterRepository.findAll();
        } else {
            return fighterRepositoryPaginated.findAll(PageRequest.of(page.get(), size.get()));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFighter(@PathVariable("id") Long id) {
        fighterRepository.deleteById(id);
    }

    @PostMapping
    public Fighter createFighter(@Valid @RequestBody CreateFighter fighter) {
        return fighterRepository.save(fighter.toFighter());
    }

    @PutMapping("/{id}")
    public Fighter updateFighter(@PathVariable("id") Long id,
            @Valid @RequestBody CreateFighter fighter) {
        var fighterToUpdate = fighterRepository.findById(id).orElseThrow();
        fighterToUpdate.setName(fighter.getName());
        fighterToUpdate.setAnimeFrom(fighter.getAnimeFrom());
        fighterToUpdate.setDamagePerHit(fighter.getDamagePerHit());
        fighterToUpdate.setHealth(fighter.getHealth());
        fighterToUpdate.setResistance(fighter.getResistance());
        return fighterRepository.save(fighterToUpdate);
    }

}
