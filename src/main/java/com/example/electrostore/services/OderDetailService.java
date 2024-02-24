package com.example.electrostore.services;


import com.example.electrostore.dto.OrderdetailDTO;
import com.example.electrostore.entity.OrderdetailEntity;
import com.example.electrostore.entity.ProductdetailEntity;
import com.example.electrostore.entity.UsersEntity;
import com.example.electrostore.repository.OderDetailRepository;
import com.example.electrostore.services.imp.OderDetailServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OderDetailService implements OderDetailServiceIMP {

    @Autowired
    private OderDetailRepository oderDetailRepository;


    @Override
    public OrderdetailEntity inser(int idProductDetail, int quantity, int price ) {
        OrderdetailEntity orderdetailEntity = new OrderdetailEntity();
        ProductdetailEntity productdetailEntity = new ProductdetailEntity();
        productdetailEntity.setIdProductDetail(idProductDetail);
        orderdetailEntity.setProductdetailEntity(productdetailEntity);
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(2);
        orderdetailEntity.setIdUser(usersEntity);
        orderdetailEntity.setQuantity(quantity);
        orderdetailEntity.setPrice(price);
        Date date = new Date();
        orderdetailEntity.setCreateDate(date);

        return oderDetailRepository.save(orderdetailEntity);
    }

    @Override
    public List<OrderdetailDTO> findAll(){
        List<OrderdetailEntity> list = oderDetailRepository.findAll();
        List<OrderdetailDTO> dtoList = new ArrayList<>();

        for (OrderdetailEntity items: list) {
            OrderdetailDTO orderdetailDTO=new OrderdetailDTO();
            orderdetailDTO.setIdOrderDetail(items.getIdOrderDetail());
            orderdetailDTO.setIdProductDetail(items.getProductdetailEntity().getIdProductDetail());
            orderdetailDTO.setQuantity(items.getQuantity());
            orderdetailDTO.setCreateDate(items.getCreateDate());
            dtoList.add(orderdetailDTO);
        }


        return dtoList;
    }
}
