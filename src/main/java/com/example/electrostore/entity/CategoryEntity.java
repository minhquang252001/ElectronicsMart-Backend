package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productEntity;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(List<ProductEntity> productEntity) {
        this.productEntity = productEntity;
    }
}
