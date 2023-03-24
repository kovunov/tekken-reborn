package com.cpan252.tekkenreborn.model.dto;

import java.math.BigDecimal;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFighter {
    @NotBlank
    private String name;

    @Min(10)
    @Max(100)
    private int damagePerHit;
    
    @Min(1000)
    private int health;

    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    @NotNull
    private BigDecimal resistance;

    @NotNull
    private Anime animeFrom;

    public Fighter toFighter() {
        return Fighter.builder()
                .name(this.getName())
                .damagePerHit(this.getDamagePerHit())
                .health(this.getHealth())
                .resistance(this.getResistance())
                .animeFrom(this.getAnimeFrom())
                .build();
    }
}
