package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    boolean existsByToken(String token);
    Optional<RefreshToken> findByKey(String key);

}
