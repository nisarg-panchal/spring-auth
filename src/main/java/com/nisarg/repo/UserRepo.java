package com.nisarg.repo;

import com.nisarg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
