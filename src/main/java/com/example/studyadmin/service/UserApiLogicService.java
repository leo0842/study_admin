package com.example.studyadmin.service;

import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.entity.User;
import com.example.studyadmin.model.network.Header;
import com.example.studyadmin.model.network.request.UserApiRequest;
import com.example.studyadmin.model.network.response.UserApiResponse;
import com.example.studyadmin.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Autowired
  private UserRepository userRepository;

  //1. request data 받기
  //2. 받은 data로 User 생성
  //3. 생성된 데이터 return

  @Override
  public Header<UserApiResponse> create(Header<UserApiRequest> request) {

    System.out.println("request: "+request);
    // 1.
    UserApiRequest userApiRequest = request.getData();

    System.out.println(userApiRequest);
    // 2.
    User user = User.builder()
        .account(userApiRequest.getAccount())
        .password(userApiRequest.getPassword())
        .status("REGISTERED")
        .phoneNumber(userApiRequest.getPhoneNumber())
        .email(userApiRequest.getEmail())
        .registeredAt(LocalDateTime.now())
        .createdAt(LocalDateTime.now())
        .createdBy("Admin")
        .build();

    User newUser = userRepository.save(user);
    System.out.println("newUser: "+newUser);

    // 3.
    return response(newUser);
  }

  @Override
  public Header<UserApiResponse> read(Long id) {
    return null;
  }

  @Override
  public Header<UserApiResponse> update(Header<UserApiRequest> request) {
    return null;
  }

  @Override
  public Header<UserApiResponse> delete(Long id) {
    return null;
  }

  private Header<UserApiResponse> response(User user){

    UserApiResponse userApiResponse = UserApiResponse.builder()
        .id(user.getId())
        .account(user.getAccount())
        .email(user.getEmail())
        .status(user.getStatus())
        .password(user.getPassword())
        .phoneNumber(user.getPhoneNumber())
        .registeredAt(user.getRegisteredAt())
        .build();

    return Header.OK(userApiResponse);

  }
}
