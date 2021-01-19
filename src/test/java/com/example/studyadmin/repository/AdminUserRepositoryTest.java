package com.example.studyadmin.repository;

import com.example.studyadmin.StudyadminApplication;
import com.example.studyadmin.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminUserRepositoryTest extends StudyadminApplication {

  @Autowired
  private AdminUserRepository adminUserRepository;

  @Test
  public void create(){
    AdminUser adminUser = new AdminUser();
    adminUser.setAccount("sungsan");
    adminUser.setPassword("tjdtks");
    adminUser.setStatus("Active");
    adminUser.setRole("admin");

    AdminUser newAdminUser = adminUserRepository.save(adminUser);
    Assertions.assertNotNull(newAdminUser);

    System.out.println(newAdminUser);
    newAdminUser.setPassword("tjdtks");
    System.out.println(adminUserRepository.save(newAdminUser));
  }




}
