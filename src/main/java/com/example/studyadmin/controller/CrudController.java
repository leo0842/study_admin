package com.example.studyadmin.controller;

import com.example.studyadmin.ifs.CrudInterface;
import com.example.studyadmin.model.network.Header;
import com.example.studyadmin.service.BaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

  @Autowired(required = false)
  protected BaseService<Req, Res, Entity> baseService;

  @GetMapping("")
  public Header<List<Res>> search(@PageableDefault(sort = "id", size = 5, direction = Direction.ASC) Pageable pageable){
    System.out.println(pageable);
    return baseService.search(pageable);
  }

  @Override
  @PostMapping("")
  public Header<Res> create(@RequestBody Header<Req> request) {
    System.out.println("2" + request);
    return baseService.create(request);
  }

  @Override
  @GetMapping("{id}")
  public Header<Res> read(@PathVariable Long id) {
    return baseService.read(id);
  }

  @Override
  @PutMapping("")
  public Header<Res> update(@RequestBody Header<Req> request) {
    return baseService.update(request);
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable Long id) {
    return baseService.delete(id);
  }
}
