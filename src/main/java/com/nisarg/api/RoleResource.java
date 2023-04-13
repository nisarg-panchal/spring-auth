package com.nisarg.api;

import com.nisarg.domain.Role;
import com.nisarg.service.UserService;
import java.net.URI;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api/roles")
@Slf4j
public class RoleResource {

  private final UserService userService;

  @PostMapping("/save")
  public ResponseEntity<Role> saveRole(@RequestBody Role role) {
    URI uri = URI.create(
        ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles/save").toUriString());
    return ResponseEntity.created(uri).body(userService.saveRole(role));
  }
}
