package com.plus1250.jobaTrend.model.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;

import javax.persistence.*;

@Getter
@Setter
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

//    public User(String nickName) {
//        this.nickName = nickName;
//    }

    public User(String email) {
        this.email = email;
    }

    // 의심스러움..
    public Authentication getUsername() {
        return null;
    }

}
