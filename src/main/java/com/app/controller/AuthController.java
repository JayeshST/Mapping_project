package com.app.controller;

import com.app.dto.LoginRequestDTO;
import com.app.response.ApiResponse;
import com.app.services.AuthService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/logout/{userId}")
    public ResponseEntity<ApiResponse> logout(@PathVariable Long userId) {
        return ResponseEntity.ok(authService.logout(userId));
    }
}
