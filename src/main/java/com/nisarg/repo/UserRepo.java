package com.nisarg.repo;

import com.nisarg.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
