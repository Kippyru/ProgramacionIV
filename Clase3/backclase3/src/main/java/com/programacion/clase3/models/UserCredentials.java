package com.programacion.clase3.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserCredentials {
    private String username;
    private String password;
}
