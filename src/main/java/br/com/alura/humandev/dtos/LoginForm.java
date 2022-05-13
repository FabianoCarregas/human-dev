package br.com.alura.humandev.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginForm {

    private String email;
    private String password;

}
