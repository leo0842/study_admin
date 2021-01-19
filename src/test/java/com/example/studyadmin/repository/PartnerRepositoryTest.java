package com.example.studyadmin.repository;

import com.example.studyadmin.StudyadminApplication;
import com.example.studyadmin.model.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PartnerRepositoryTest extends StudyadminApplication {

  @Autowired
  private PartnerRepository partnerRepository;

}
