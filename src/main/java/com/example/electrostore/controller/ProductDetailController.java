package com.example.electrostore.controller;

import com.example.electrostore.payload.reponse.BaseResponse;
import com.example.electrostore.services.imp.ProductDetailServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/productdetail")
public class ProductDetailController {

    @Autowired
    private ProductDetailServiceIMP productDetailServiceIMP;

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestParam int idProduct, @RequestParam int quantity){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productDetailServiceIMP.insertProductDetail(idProduct,quantity));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
