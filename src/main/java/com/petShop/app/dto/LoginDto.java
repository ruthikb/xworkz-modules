package com.petShop.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoginDto {

    private int id;
    private String email;
    private String phone;
    private String password;
    private LocalDate loginDate;
    private LocalTime loginTime;
}
