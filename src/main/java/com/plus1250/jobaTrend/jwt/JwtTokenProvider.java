package com.plus1250.jobaTrend.jwt;

import com.plus1250.jobaTrend.model.dto.TokenDTO;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class JwtTokenProvider {
    @Autowired
    private final UserDetailsService userDetailsService;

    // secret key
    @Value("${jwt.secret-key}")
    private String secretKey;

    private static final String AUTHORITIES_KEY = "auth";

    private static final String BEARER_TYPE = "bearer";

    // access token 1시간
    private final long accessTokenValidTime = 60 * 60 * 1000L;

    // refresh token 2주
    private final long refreshTokenValidTime = 60 * 60 * 24 * 14 * 1000L;

    @PostConstruct
    private void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //토큰 Claims 정보 추출
    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(token).getBody();
    }

    // 토큰 인증 subject 추출
    private String getSubject(String token) {
        return getClaims(token).getSubject();
    }

    // 토큰 인증 정보 추출
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // Jwt 토큰 생성
    public TokenDTO createToken(Authentication authentication) {
        // 권한들 가져오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();

        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now + accessTokenValidTime);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        // Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + refreshTokenValidTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return TokenDTO.builder()
                .tokenType(BEARER_TYPE)
                .accessToken(accessToken)
                .accessTokenExpireDate(accessTokenExpiresIn.getTime())
                .refreshToken(refreshToken)
                .build();
    }

    public String resolveAccessToken(HttpServletRequest request) {
        String token = request.getHeader("access-token");
        return token;
    }

    // 토큰 유효성, 만료일자 검증
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

}