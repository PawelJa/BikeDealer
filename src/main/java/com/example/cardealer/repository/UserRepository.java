package com.example.cardealer.repository;

import com.example.cardealer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>{

    User getActiveUser(String username);
}
