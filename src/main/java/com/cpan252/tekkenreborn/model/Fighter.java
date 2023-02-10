package com.cpan252.tekkenreborn.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
// By using the @Table annotation, we are telling Spring Data to map the table
// name to the table
@Table
public class Fighter {
    public enum Anime {
        NARUTO("Naruto"), BLEACH("Bleach"), ONE_PIECE("One Piece"), TEKKEN("Tekken");

        private String title;

        private Anime(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    @Id
    private Long id;
    @NotBlank
    private String name;
    @Max(100)
    private int damagePerHit;
    @Min(1000)
    private int health;
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal resistance;
    private Anime animeFrom;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
