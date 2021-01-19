package com.example.studyadmin.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  private String orderType;

  private String revAddress;

  private String revName;

  private String paymentType;

  private float totalPrice;

  private int totalQuantity;

  private LocalDateTime orderAt;

  private LocalDateTime arrivalDate;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String createdBy;

  private String updatedBy;

//  @ManyToOne
//  private User user;

}
