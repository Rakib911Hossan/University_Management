package com.penta.uni_db.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class LoginDto {
    private String username;
    private String password;
}
