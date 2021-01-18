package com.example.studyadmin.repository;

import com.example.studyadmin.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByAccount(String account);

  Optional<User> findByAccountAndEmail(String account, String email);
}
