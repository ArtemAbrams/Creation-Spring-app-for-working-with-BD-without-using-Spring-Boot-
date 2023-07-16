package com.example.springconfigurationdatabase;

import com.example.springconfigurationdatabase.config.RootConfig;
import com.example.springconfigurationdatabase.enums.Status;
import com.example.springconfigurationdatabase.repository.ProductRepository;
import com.example.springconfigurationdatabase.service.ProductService;
import com.example.springconfigurationdatabase.service.implementation.ProductServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationDatabaseApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RootConfig.class);
        var repository = context.getBean(ProductRepository.class);
        var productService = context.getBean(ProductServiceImpl.class);
        /*productService.getProductsByStatus(Status.NEW)
                .forEach(System.out::println);*/
        System.out.println("---------------------------------");
        var product = repository.findById(1L);
        System.out.println(product);
        System.out.println("---------------------------------");
        var updatedProduct = productService.updateProductByStatus(1L, Status.MODIFIER);
        System.out.println(updatedProduct);
    }
}
