package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productdetail")
public class ProductdetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductDetail;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private ColorEntity colorEntity;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productdetailEntity")
    private List<OrderdetailEntity> orderdetailEntities;

    public Integer getIdProductDetail() {
        return idProductDetail;
    }

    public void setIdProductDetail(Integer idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderdetailEntity> getOrderdetailEntities() {
        return orderdetailEntities;
    }

    public void setOrderdetailEntities(List<OrderdetailEntity> orderdetailEntities) {
        this.orderdetailEntities = orderdetailEntities;
    }
}
