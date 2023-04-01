package com.cpan252.tekkenreborn.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TekkenUserDto {
    private String name;
    private int wins;
    private int losses;
    private int draws;

}
