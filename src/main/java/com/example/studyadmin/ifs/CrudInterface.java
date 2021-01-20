package com.example.studyadmin.ifs;

import com.example.studyadmin.model.network.Header;

public interface CrudInterface {

  Header create();

  Header read(Long id);

  Header update();

  Header delete(Long id);

}
