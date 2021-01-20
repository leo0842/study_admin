package com.example.studyadmin.controller.api;

import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.network.Header;
import lombok.Builder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Builder
public class UserController implements CrudInterface {


  @Override
  @PostMapping("")
  public Header create() {
    return null;
  }

  @Override
  @GetMapping("{id}")
  public Header read(@PathVariable Long id) {
    return null;
  }

  @Override
  @PutMapping("")
  public Header update() {
    return null;
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable Long id) {
    return null;
  }
}
