package com.example.springconfigurationdatabase.service;

import com.example.springconfigurationdatabase.dto.ProductDTO;
import com.example.springconfigurationdatabase.enums.Status;

import java.util.List;

public interface ProductService {
   List<ProductDTO> getProductsByStatus(Status status);
   ProductDTO updateProductByStatus(Long id, Status status);
}
