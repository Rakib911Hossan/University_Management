package com.penta.uni_db.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RegisterDto {
    private String username;
    private String password;
}
