package com.example.studyadmin.repository;

import com.example.studyadmin.StudyadminApplication;
import com.example.studyadmin.model.entity.Category;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryRepositoryTest extends StudyadminApplication {

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void create() {
    Category category = new Category();
    category.setType("electronics");
    category.setTitle("computer");
    category.setCreatedAt(LocalDateTime.now());
    category.setCreatedBy("Admin");

    Category newCategory = categoryRepository.save(category);

    Assertions.assertNotNull(newCategory);
    Assertions.assertEquals(newCategory.getType(), "electronics");

  }

  @Test
  public void read() {
    Optional<Category> category = categoryRepository.findById(1L);
    List<Category> typeCategory = categoryRepository.findAllByType("electronics");

    Assertions.assertTrue(category.isPresent());

    category.stream().forEach(category1 -> System.out.println(category1));
    System.out.println(typeCategory);
    System.out.println("=======================");
    for (Category c: typeCategory){
      System.out.println(c);
    }
  }
}
