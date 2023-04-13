package com.nisarg.repo;

import com.nisarg.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

  Role findByName(String name);
}
