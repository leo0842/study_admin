//package com.example.studyadmin.repository;
//
//import com.example.studyadmin.StudyadminApplication;
//import com.example.studyadmin.model.entity.OrderDetail;
//import java.time.LocalDateTime;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class OrderDetailRepositoryTest extends StudyadminApplication {
//
//  @Autowired
//  private OrderDetailRepository orderDetailRepository;
//
//  @Test
//  public void create() {
//    OrderDetail orderDetail = new OrderDetail();
//
//    //orderDetail.setOrderAt(LocalDateTime.now());
//    //orderDetail.setItemId(1L);
//    //orderDetail.setUserId(3L);
//
//    OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
//
//    Assertions.assertNotNull(orderDetail1);
//  }
//
//}
