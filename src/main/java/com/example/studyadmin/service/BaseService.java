package com.example.studyadmin.service;

import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.network.Header;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res> {

  @Autowired(required = false)
  protected JpaRepository<Entity, Long> baseRepository;

  public Header<List<Res>> search(Pageable pageable){
    return null;
  }
  @Override
  public Header<Res> create(Header<Req> request) {
    return null;
  }

  @Override
  public Header<Res> read(Long id) {
    System.out.println(1);
    return null;
  }

  @Override
  public Header<Res> update(Header<Req> request) {
    return null;
  }

  @Override
  public Header delete(Long id) {
    return null;
  }
}
