package com.example.examenyoussefchanane.Repository;

import com.example.examenyoussefchanane.Entity.Product;
import com.example.examenyoussefchanane.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
