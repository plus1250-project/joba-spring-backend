package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
