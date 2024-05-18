package com.svalero.SaraShopReactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    private long id;
    private String name;
    private String description;
    private boolean stock;
    private LocalDate creation_date;
    private Section section;

}
