package com.nisarg;

import com.nisarg.domain.Role;
import com.nisarg.domain.User;
import com.nisarg.service.UserService;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringAuthApplication {


  public static void main(String[] args) {
    SpringApplication.run(SpringAuthApplication.class, args);
  }

  @Bean
  CommandLineRunner run(UserService userService) {
    return args -> {
      userService.saveRole(new Role(null, "ROLE_USER"));
      userService.saveRole(new Role(null, "ROLE_ADMIN"));
      userService.saveRole(new Role(null, "ROLE_MANAGER"));

      userService.saveUser(new User(null, "Nisarg Panchal", "nisarg", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "John Smith", "john", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Jane Smith", "jane", "1234", new ArrayList<>()));

      userService.addRoleToUser("john", "ROLE_USER");
      userService.addRoleToUser("jane", "ROLE_MANAGER");
      userService.addRoleToUser("jane", "ROLE_USER");
      userService.addRoleToUser("jane", "ROLE_ADMIN");
      userService.addRoleToUser("nisarg", "ROLE_ADMIN");
    };
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
