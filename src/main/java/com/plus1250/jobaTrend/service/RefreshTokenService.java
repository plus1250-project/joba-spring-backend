package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    public boolean isExpiredToken(String token) {
        return refreshTokenRepository.existsByToken(token);
    }

//    public RefreshToken addExpiredToken(String token) {
//        RefreshToken saveToken = RefreshToken.builder()
//                .token(token)
//                .build();
//        return refreshTokenRepository.save(saveToken);
   // }
}

