package com.plus1250.jobaTrend.repository;
import com.plus1250.jobaTrend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    User save(User saveUser);

    User findByUserId(String email);
}
