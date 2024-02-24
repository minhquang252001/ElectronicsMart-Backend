package com.example.electrostore.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "orderdetail")
public class OrderdetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderDetail;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UsersEntity idUser;

    @ManyToOne
    @JoinColumn(name = "id_product_detail")
    private  ProductdetailEntity productdetailEntity;

    @Column(name = "quantity")
    private int quantity;

    @Column(name= "price")
    private int price;

    @Column(name = "create_date")
    private Date createDate;

    public int getIdOrderDetail() {
        return this.idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public UsersEntity getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersEntity idUser) {
        this.idUser = idUser;
    }

    public ProductdetailEntity getProductdetailEntity() {
        return productdetailEntity;
    }

    public void setProductdetailEntity(ProductdetailEntity productdetailEntity) {
        this.productdetailEntity = productdetailEntity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
