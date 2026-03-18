package com.github.benimarushiimon.rest_ex.model;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    private List<Authorities> authorities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
