package com.example.studyadmin.repository;

import com.example.studyadmin.StudyadminApplication;
import com.example.studyadmin.model.entity.OrderGroup;
import com.example.studyadmin.model.entity.User;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderGroupRepositoryTest extends StudyadminApplication {

  @Autowired
  private OrderGroupRepository orderGroupRepository;

  @Autowired
  private  UserRepository userRepository;

  @Test
  public void create(){
    OrderGroup orderGroup = new OrderGroup();
    User user = userRepository.findByAccount("Test1");

    orderGroup.setStatus("Waiting");
    orderGroup.setOrderType("All");
    orderGroup.setArrivalDate(LocalDateTime.now().plusDays(2));
    orderGroup.setTotalPrice((float) 90000.5);
    orderGroup.setUser(user);

    OrderGroup newOrderGroup =  orderGroupRepository.save(orderGroup);
    Assertions.assertNotNull(newOrderGroup);
    System.out.println(newOrderGroup);
  }

}
