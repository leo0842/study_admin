package com.example.studyadmin.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

  // API 통신 시간
  @JsonProperty("transaction_time")
  private LocalDateTime transactionTime;

  // API 응답 코드
  private String resultCode;

  // API 설명
  private String description;

  private T data;

  public static <T> Header<T> OK() {
    return (Header<T>) Header.builder()
        .transactionTime(LocalDateTime.now())
        .resultCode("OK")
        .description("Good")
        .build();
  }

  public static <T> Header<T> OK(T data) {
    return (Header<T>) Header.builder()
        .transactionTime(LocalDateTime.now())
        .resultCode("OK")
        .description("Good")
        .data(data)
        .build();
  }

  public static <T> Header<T> ERROR(String description) {
    return (Header<T>) Header.builder()
        .transactionTime(LocalDateTime.now())
        .resultCode("ERROR")
        .description(description)
        .build();
  }
}
