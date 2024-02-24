package com.example.electrostore.services;

import com.example.electrostore.entity.BrandEntity;
import com.example.electrostore.entity.ColorEntity;
import com.example.electrostore.entity.ProductEntity;
import com.example.electrostore.entity.ProductdetailEntity;
import com.example.electrostore.repository.ProductDetailRepository;
import com.example.electrostore.services.imp.ProductDetailServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetaiiService implements ProductDetailServiceIMP {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ProductdetailEntity insertProductDetail(int idProduct, int quantity) {
        ProductdetailEntity productdetailEntity = new ProductdetailEntity();
        ProductEntity productEntity =new ProductEntity();
        productEntity.setId(idProduct);
        productdetailEntity.setProductEntity(productEntity);
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(1);
        productdetailEntity.setBrandEntity(brandEntity);
        ColorEntity colorEntity = new ColorEntity();
        colorEntity.setId(1);
        productdetailEntity.setColorEntity(colorEntity);
        productdetailEntity.setQuantity(quantity);
        productdetailEntity.setDescription("Thành Công");
        return productDetailRepository.save(productdetailEntity);
    }
}
