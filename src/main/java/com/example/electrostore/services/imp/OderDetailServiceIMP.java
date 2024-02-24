package com.example.electrostore.services.imp;

import com.example.electrostore.dto.OrderdetailDTO;
import com.example.electrostore.entity.OrderdetailEntity;

import java.util.List;

public interface OderDetailServiceIMP {

    OrderdetailEntity inser(int idProductDetail, int quantity, int price);
    List<OrderdetailDTO> findAll();
}
