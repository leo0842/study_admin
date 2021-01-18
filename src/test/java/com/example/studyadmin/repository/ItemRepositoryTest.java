package com.example.studyadmin.repository;


import com.example.studyadmin.StudyadminApplication;
import com.example.studyadmin.model.entity.Item;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ItemRepositoryTest extends StudyadminApplication {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void create(){
    Item item = new Item();

    item.setName("laptop");

    item.setPrice(1000);

    item.setContent("This is a new laptop");

    Item newItem = itemRepository.save(item);

    Assertions.assertNotNull(newItem);

    System.out.println(newItem);


  }

  @Test
  @Transactional
  public void read(){
    Optional<Item> item = itemRepository.findById(1L);

    Assertions.assertTrue(item.isPresent());

    item.ifPresent(item1 -> {
      item1.getOrderDetails().forEach(orderDetail -> {
        System.out.println(orderDetail.getUser());
      });
    });
  }

}
