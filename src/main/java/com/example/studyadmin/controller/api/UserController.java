package com.example.studyadmin.controller.api;

import com.example.studyadmin.controller.CrudController;
import com.example.studyadmin.model.entity.User;
import com.example.studyadmin.model.network.request.UserApiRequest;
import com.example.studyadmin.model.network.response.UserApiResponse;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
@Builder
public class UserController extends CrudController<UserApiRequest, UserApiResponse, User> {

}
