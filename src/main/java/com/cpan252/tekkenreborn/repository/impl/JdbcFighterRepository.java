package com.cpan252.tekkenreborn.repository.impl;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;

@Repository
public class JdbcFighterRepository implements FighterRepository {
    private JdbcTemplate jdbcTemplate;

    //JdbcTemplate is a bean provided by Spring
    public JdbcFighterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Fighter> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Fighter> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Fighter save(Fighter fighter) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
