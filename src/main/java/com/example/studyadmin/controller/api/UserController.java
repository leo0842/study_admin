package com.example.studyadmin.controller.api;

import com.example.studyadmin.controller.CrudController;
import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.entity.User;
import com.example.studyadmin.model.network.Header;
import com.example.studyadmin.model.network.request.UserApiRequest;
import com.example.studyadmin.model.network.response.UserApiResponse;
import com.example.studyadmin.service.UserApiLogicService;
import javax.annotation.PostConstruct;
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
public class UserController extends CrudController<UserApiRequest, UserApiResponse, User> {

}
