package com.example.studyadmin.controller.api;

import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.network.Header;
import com.example.studyadmin.model.network.request.UserApiRequest;
import com.example.studyadmin.model.network.response.UserApiResponse;
import com.example.studyadmin.service.UserApiLogicService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
@Builder
public class UserController implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Autowired
  private UserApiLogicService userApiLogicService;

  @Override
  @PostMapping("")
  public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {

    log.info("{}", userApiRequest);
    return userApiLogicService.create(userApiRequest);
  }

  @Override
  @GetMapping("{id}")
  public Header<UserApiResponse> read(@PathVariable Long id) {
    log.info("read id: {}", id);
    return userApiLogicService.read(id);
  }

  @Override
  @PutMapping("")
  public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
    log.info("read id: {}", userApiRequest.getData().getId());

    return userApiLogicService.update(userApiRequest);
  }

  @Override
  @DeleteMapping("{id}")
  public Header<Object> delete(@PathVariable Long id) {
    log.info("read id: {}", id);

    return userApiLogicService.delete(id);
  }
}
