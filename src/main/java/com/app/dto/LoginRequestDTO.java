package com.app.dto;


import javax.validation.constraints.NotBlank;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoginRequestDTO {
   @NotBlank
    private String email;

    @NotBlank
    private String password;
}
