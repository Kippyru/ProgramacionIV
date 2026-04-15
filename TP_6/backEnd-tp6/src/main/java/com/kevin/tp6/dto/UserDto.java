package com.kevin.tp6.dto;

import com.kevin.tp6.handler.UniqueUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @UniqueUser
    private String username;
    private String password;
}
