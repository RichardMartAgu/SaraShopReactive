package com.svalero.SaraShopReactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    private long id;
    private String name;
    private String address;
    private String phone;
    private String open_date;
    private boolean open;
}
