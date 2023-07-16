package com.example.springconfigurationdatabase;

import com.example.springconfigurationdatabase.config.RootConfig;
import com.example.springconfigurationdatabase.repository.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationDatabaseApplication {
    public static void main(String[] args) {
      var context = new AnnotationConfigApplicationContext(RootConfig.class);
      var repository = context.getBean(ProductRepository.class);
      repository.findAll()
              .forEach(System.out::println);
    }
}
