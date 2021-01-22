package com.example.studyadmin.model.network.request;

import com.example.studyadmin.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiRequest {

  private Long id;

  private String account;

  private String password;

  private UserStatus status;

  private String email;

  private String phoneNumber;

}
