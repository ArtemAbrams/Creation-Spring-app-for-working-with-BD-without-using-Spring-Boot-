package com.example.springconfigurationdatabase.dto;

import com.example.springconfigurationdatabase.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO{
    private String name;
    private Long price;
    private Status status;
}
