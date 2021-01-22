package com.example.studyadmin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {

  UNREGISTERED(0, "Unregistered", "User Unregistered"),
  REGISTERED(1, "Registered", "User Registered");

  private final int id;
  private final String title;
  private final String desc;




}
