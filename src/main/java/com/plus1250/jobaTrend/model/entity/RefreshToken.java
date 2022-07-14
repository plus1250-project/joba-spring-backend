package com.plus1250.jobaTrend.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Builder
@Entity
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "refresh_token")
public class RefreshToken {

    @Id
    @Column(name = "rt_key")
    private String key;

    @Column(name = "rt_value")
    private String value;

    @Column(name = "token")
    private String token;

    @Builder
    public RefreshToken(String key, String value, String token) {
        this.key = key;
        this.value = value;
        this.token = token;
    }

    public RefreshToken updateValue(String token) {
        this.value = token;
        return this;
    }
}