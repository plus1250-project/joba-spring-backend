package com.plus1250.jobaTrend.model.entity;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickName;

    public User() {}


    public void update(String password, String nickName) {
        this.password = password;
        this.nickName = nickName;
    }

    // 의심스러움..
    public Authentication getUsername() {
        return null;
    }
}
