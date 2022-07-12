package com.plus1250.jobaTrend.repository;
import com.plus1250.jobaTrend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(String email);

//    Optional<User> findByInfo(String email);

    User save(User saveUser);
    User findByUserId(String email);
//    Optional<User> updateUserPassword(String password);


}
