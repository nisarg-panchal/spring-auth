package com.nisarg.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationInfo {

  private String firstName;
  private String lastName;
  private String email;
  private String password;

}
