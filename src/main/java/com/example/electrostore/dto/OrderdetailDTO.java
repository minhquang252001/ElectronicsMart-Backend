package com.example.electrostore.dto;

import java.util.Date;

public class OrderdetailDTO {
    private Integer idOrderDetail;
    private Integer idUser;
    private Integer idProductDetail;
    private Integer quantity;
    private Date createDate;
    private Integer price;

    public Integer getIdOrderDetail() {
        return this.idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProductDetail() {
        return this.idProductDetail;
    }

    public void setIdProductDetail(Integer idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
