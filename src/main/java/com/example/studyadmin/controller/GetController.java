package com.example.studyadmin.controller;

import com.example.studyadmin.model.SearchParam;
import com.example.studyadmin.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //Localhost:8080/api
public class GetController {

  @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //Localhost:8080/api/getMethod
  public String getRequest(){
    return "HI GetMethod";
  }

  @GetMapping(path="/getParameter")
  public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
    String password = null;
    System.out.println("id: " + id);
    System.out.println("pw: " + pwd);
    return id+", "+pwd;
  }

  @GetMapping(path="/getMultiParams") //Localhost:8080/api/getMultiParams?account=sungsan&email=tjdtks@gmail.com&page=1
  public SearchParam getMultiParams(SearchParam searchParam){
    System.out.println(searchParam.getAccount());
    System.out.println(searchParam.getEmail());
    System.out.println(searchParam.getPage());

    return searchParam;


  }

  @GetMapping(path = "/header")
  public Header getHeader(){

    return Header.builder().resultCode("OK").description("Good").build();
  }
}
