package com.example.studyadmin.repository;

import com.example.studyadmin.StudyadminApplication;
import com.example.studyadmin.model.entity.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@SpringBootTest
public class UserRepositoryTest extends StudyadminApplication {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void create() {

    System.out.println(userRepository);
    User user = new User();

    user.setAccount("Test3");

    user.setPassword("test3");

    user.setStatus("Registered");

    user.setEmail("Test3@gmail.com");

    user.setPhoneNumber("01012345679");

    user.setCreatedAt(LocalDateTime.now());

    user.setCreatedBy("admin");

    System.out.println(user);

    User newUser = userRepository.save(user);

    Assertions.assertNotNull(newUser);

    System.out.println(newUser);

  }

  @Test
  @Transactional
  public void read() {

//    User user = userRepository.findByPhoneNumberOrderByCreatedAtDesc("01012345670");
//    Optional<User> user1 = userRepository.findByPhoneNumber("01012345678");
//    System.out.println(user);
//    System.out.println("=============");
//    System.out.println(user1);
//    Assertions.assertNotNull(user1);

    Optional<User> user = userRepository.findById(1L); // findById는 Optional로 받음

    Assertions.assertTrue(user.isPresent());
    user.ifPresent(user1 -> {
      System.out.println(user1.getEmail());
      System.out.println((long) user1.getOrderGroups().size());

    });

//    Optional<User> user2 = userRepository.findByAccount("Test1");
//    Assertions.assertTrue(user2.isPresent());
//    user2.ifPresent(user1 -> {
//      System.out.println(user1.getEmail());
//    });
  }

  @Test
  public void update() {

    Optional<User> user = userRepository.findById(4L); // findById는 Optional로 받음

    user.ifPresent(user1 -> {
      user1.setAccount("sungsan");
      user1.setUpdatedAt(LocalDateTime.now());
      user1.setUpdatedBy("admin");

      //id를 가지고 select를 한번 더 함. 그래서 sql문이 두번 돈다.
      userRepository.save(user1);

    });
  }

  @Test
  @Transactional
  public void delete() {

    Optional<User> user = userRepository.findById(4L);

    Assertions.assertTrue(user.isPresent()); //true 여야 한다.
    user.ifPresent(user1 -> {
      userRepository.delete(user1);
    });

    Optional<User> deletedUser = userRepository.findById(4L);

    Assertions.assertTrue(deletedUser.isEmpty()); //true 여야 한다.
//    System.out.println(deletedUser); //Optional.empty 라는 객체로 들어옴.
  }
}
