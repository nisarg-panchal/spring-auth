package com.nisarg.api;

import com.nisarg.domain.User;
import com.nisarg.service.UserService;
import java.net.URI;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Slf4j
public class UserResource {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    log.info("Controller fetching all users");
    return ResponseEntity.ok().body(userService.getUsers());
  }

  @PostMapping("/save")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    URI uri = URI.create(
        ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/save").toUriString());
    return ResponseEntity.created(uri).body(userService.saveUser(user));
  }

  @PostMapping("/addroletouser")
  public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser) {
    userService.addRoleToUser(roleToUser.getUserName(), roleToUser.getRoleName());
    return ResponseEntity.ok().build();
  }

  @Data
  static
  class RoleToUser {

    private String userName;
    private String roleName;
  }
}
