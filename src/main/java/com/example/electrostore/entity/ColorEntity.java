package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "colorEntity")
    private List<ProductdetailEntity> list;

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

    public List<ProductdetailEntity> getList() {
        return list;
    }

    public void setList(List<ProductdetailEntity> list) {
        this.list = list;
    }
}
