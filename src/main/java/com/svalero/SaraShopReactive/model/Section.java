package com.svalero.SaraShopReactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    private long id;
    private String name;
    private String description;
    private LocalDate creation_date;
    private boolean available;

}
