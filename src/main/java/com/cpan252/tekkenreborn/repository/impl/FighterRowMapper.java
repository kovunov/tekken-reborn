package com.cpan252.tekkenreborn.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpan252.tekkenreborn.model.Fighter;

//This is the bridge between the database (row representation) and the Fighter object
public class FighterRowMapper implements RowMapper<Fighter> {

    @Override
    public Fighter mapRow(ResultSet rs, int row) throws SQLException {
        return Fighter.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .damagePerHit(rs.getInt("damage_per_hit"))
                    .health(rs.getInt("health"))
                    .resistance(rs.getBigDecimal("resistance"))
                    .animeFrom(Fighter.Anime.valueOf(rs.getString("anime_from")))
                    .build();
    }
    
}
