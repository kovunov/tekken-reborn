package com.cpan252.tekkenreborn.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FighterPool {
    private List<Fighter> fighters;

    public FighterPool() {
        this.fighters = new ArrayList<>();
    }

    public void add(Fighter fighter) {
        this.fighters.add(fighter);
    }
}
