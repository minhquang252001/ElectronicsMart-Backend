package com.example.electrostore.dto;

public class ProductdetailDTO {
    private Integer idProductDetail;
    private Integer idProduct;
    private Integer idBrand;
    private Integer idColor;
    private Integer quantity;
    private String description;

    public Integer getIdProductDetail() {
        return this.idProductDetail;
    }

    public void setIdProductDetail(Integer idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    public Integer getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdBrand() {
        return this.idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public Integer getIdColor() {
        return this.idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
