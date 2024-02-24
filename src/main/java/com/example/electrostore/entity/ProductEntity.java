package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "images")
    private String images;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    private List<ProductdetailEntity> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public List<ProductdetailEntity> getList() {
        return list;
    }

    public void setList(List<ProductdetailEntity> list) {
        this.list = list;
    }
}
