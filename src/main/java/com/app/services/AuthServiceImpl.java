package com.app.services;

import com.app.dto.LoginRequestDTO;
import com.app.entities.TokenEntity;
import com.app.entities.UserEntity;
import com.app.repository.TokenRepository;
import com.app.repository.UserRepository;
import com.app.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse login(LoginRequestDTO dto) {
        UserEntity user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = UUID.randomUUID().toString();
        tokenRepository.save(TokenEntity.builder()
                .userId(user.getId())
                .token(token)
                .role(user.getRole())
                .active(true)
                .build());

        return new ApiResponse(200, "Login successful. Use X-CSRF-Token in header: " + token);
    }

    @Override
    public ApiResponse logout(Long userId) {
        tokenRepository.deleteByUserId(userId);
        return new ApiResponse(200, "Logout successful. Token cleared.");
    }
}
