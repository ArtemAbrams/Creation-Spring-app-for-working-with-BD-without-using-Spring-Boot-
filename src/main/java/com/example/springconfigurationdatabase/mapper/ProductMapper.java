package com.example.springconfigurationdatabase.mapper;


import com.example.springconfigurationdatabase.dto.ProductDTO;
import com.example.springconfigurationdatabase.entity.Product;

public class ProductMapper {
    public static ProductDTO mapToProductDto(Product product){
        return new ProductDTO(product.getName(), product.getPrice(), product.getStatus());
    }
}
