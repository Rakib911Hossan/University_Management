package com.penta.uni_db.Dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType="Bearer ";

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
