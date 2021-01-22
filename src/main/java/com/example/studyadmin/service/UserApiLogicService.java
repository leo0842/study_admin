package com.example.studyadmin.service;

import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.entity.User;
import com.example.studyadmin.model.enumclass.UserStatus;
import com.example.studyadmin.model.network.Header;
import com.example.studyadmin.model.network.request.UserApiRequest;
import com.example.studyadmin.model.network.response.UserApiResponse;
import com.example.studyadmin.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

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
        .status(UserStatus.REGISTERED)
        .phoneNumber(userApiRequest.getPhoneNumber())
        .email(userApiRequest.getEmail())
        .registeredAt(LocalDateTime.now())
        .createdAt(LocalDateTime.now())
        .createdBy("Admin")
        .build();

    User newUser = baseRepository.save(user);
    System.out.println("newUser: "+newUser);

    // 3.
    return response(newUser);
  }

  @Override
  public Header<UserApiResponse> read(Long id) {

    Optional<User> user = baseRepository.findById(id);

    return user
        .map(user1 -> response(user1))
        .orElseGet(() -> Header.ERROR("No Data found"));
  }

  @Override
  public Header<UserApiResponse> update(Header<UserApiRequest> request) {

    UserApiRequest userApiRequest = request.getData();

    System.out.println("userApiRequest: " + userApiRequest);
    Optional<User> user = baseRepository.findById(userApiRequest.getId());
    System.out.println("user: "+ user);

    return user
        .map(user1 -> updateResponse(user1, userApiRequest))
        .orElseGet(() -> Header.ERROR("No data to update")); //무조건 orElseGet이 필요. 왜지??
  }

  @Override
  public Header<Object> delete(Long id) {
    Optional<User> user = baseRepository.findById(id);
    return user.map(user1 -> {
      baseRepository.delete(user1);
      return Header.OK();
    }).orElseGet(() -> Header.ERROR("No data to delete"));
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

    System.out.println("userApiResponse in response()"+userApiResponse);

    return Header.OK(userApiResponse);

  }

  private Header<UserApiResponse> updateResponse(User user, UserApiRequest request){
    user.setAccount(request.getAccount());
    user.setEmail(request.getEmail());
    user.setStatus(request.getStatus());
    user.setPassword(request.getPassword());
    user.setPhoneNumber(request.getPhoneNumber());

    User updatedUser = baseRepository.save(user);

    System.out.println("updateResponse: " + updatedUser);
    return response(updatedUser);
  }
}
