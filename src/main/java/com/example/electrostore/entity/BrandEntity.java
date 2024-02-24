package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brandEntity")
    private List<ProductdetailEntity> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductdetailEntity> getList() {
        return list;
    }

    public void setList(List<ProductdetailEntity> list) {
        this.list = list;
    }
}
