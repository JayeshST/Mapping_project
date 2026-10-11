package com.app.services;

import com.app.dto.LoginRequestDTO;
import com.app.response.ApiResponse;

public interface AuthService {
    ApiResponse login(LoginRequestDTO dto);
    ApiResponse logout(Long userId);
}
