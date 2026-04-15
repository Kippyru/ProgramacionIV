package com.kevin.tp6.controller;

import com.kevin.tp6.dto.UserDto;
import com.kevin.tp6.model.User;
import com.kevin.tp6.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody UserDto dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(userService.getAll());
    }
}
