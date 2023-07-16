package com.example.springconfigurationdatabase.entity;

import com.example.springconfigurationdatabase.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class Product extends BasicEntity {
    private String name;
    private Long price;
    @Enumerated(EnumType.STRING)
    private Status status;
}
