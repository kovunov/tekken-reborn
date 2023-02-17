package com.cpan252.tekkenreborn.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//What is DTO: DTO is a Data Transfer Object. 
// It is a simple object that is used to transfer data between application layers.
// In our case we will need to populate this object with data from the form
public class FighterSearchByDateDto {
    private String name;
    private String startDate;
    private String endDate;
}