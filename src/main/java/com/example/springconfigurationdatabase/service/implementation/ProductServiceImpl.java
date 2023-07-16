package com.example.springconfigurationdatabase.service.implementation;

import com.example.springconfigurationdatabase.dto.ProductDTO;
import com.example.springconfigurationdatabase.enums.Status;
import com.example.springconfigurationdatabase.exception.NotFoundProductException;
import com.example.springconfigurationdatabase.mapper.ProductMapper;
import com.example.springconfigurationdatabase.repository.ProductRepository;
import com.example.springconfigurationdatabase.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<ProductDTO> getProductsByStatus(Status status) {
        return productRepository.findAll()
                .stream()
                .filter(e->e.getStatus()==status)
                .map(e -> new ProductDTO(e.getName(), e.getPrice(), e.getStatus()))
                .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public ProductDTO updateProductByStatus(Long id, Status status) {
        var product = productRepository.findById(id)
                .orElseThrow(()-> new NotFoundProductException());
        product.setStatus(status);
        return ProductMapper.mapToProductDto(product);
    }
}
