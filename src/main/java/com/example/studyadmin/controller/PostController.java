package com.example.studyadmin.controller;

import com.example.studyadmin.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class PostController {

  @PostMapping(value = "/postMethod") //127.0.0.1:8080/apis/postMethod
  public SearchParam postMethod(@RequestBody SearchParam searchParam){
    System.out.println(searchParam);
    return searchParam;
  }

}
