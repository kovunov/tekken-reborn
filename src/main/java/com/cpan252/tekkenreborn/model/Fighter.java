package com.cpan252.tekkenreborn.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fighter {
    private String name;
    private int damagePerHit;
    private int health;
    private double resistance;
    private Anime animeFrom;

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
}
