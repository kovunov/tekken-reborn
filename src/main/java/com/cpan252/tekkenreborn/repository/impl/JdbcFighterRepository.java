package com.cpan252.tekkenreborn.repository.impl;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.repository.FighterRepository;

//There's an acronym called CRUD that stands for Create, Read, Update, Delete
//This is a repository that implements the CRUD operations for fighter table

@Repository
public class JdbcFighterRepository implements FighterRepository {
    // We could use @Autowired annotation here but it's not recommended
    // This approach is more testable and more recommended than using @Autowired
    private JdbcTemplate jdbcTemplate;

    // JdbcTemplate is a bean provided by Spring
    // if jdbctemplate.query() is called, you can give me this result set
    public JdbcFighterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Fighter> findAll() {
        /**
         * 1. We query the fighter table for all the fighters
         * 2. We iterate each row returned from the table
         * 3. We create a Fighter object from each row (map row to Fighter object)
         * Optional: we can provide RowMapper that will be responsible for mapping the
         * row to Fighter object
         */
        return jdbcTemplate.query("SELECT * FROM fighter", new FighterRowMapper());
    }

    @Override
    public Optional<Fighter> findById(Long id) {
        Fighter fighter = jdbcTemplate.queryForObject("SELECT * FROM fighter WHERE id = ?", new FighterRowMapper(), id);
        return Optional.ofNullable(fighter);
    }

    @Override
    public void save(Fighter fighter) {
        var insertFighter = "INSERT INTO fighter (name, damage_per_hit, health, resistance, anime_from, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(insertFighter);
            ps.setString(1, fighter.getName());
            ps.setInt(2, fighter.getDamagePerHit());
            ps.setInt(3, fighter.getHealth());
            ps.setBigDecimal(4, fighter.getResistance());
            ps.setString(5, fighter.getAnimeFrom().name());
            ps.setString(6, fighter.getCreatedAt().toString());
            return ps;
        }, keyHolder);
    }

}
