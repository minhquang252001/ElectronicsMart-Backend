package com.example.electrostore.controller;

import com.example.electrostore.payload.reponse.BaseResponse;
import com.example.electrostore.services.imp.OderDetailServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/orderdetail")
public class OderDetailController {

    @Autowired
    private OderDetailServiceIMP oderDetailServiceIMP;

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestParam int idProductDetail, @RequestParam int quantity, @RequestParam  int price){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(oderDetailServiceIMP.inser(idProductDetail,quantity,price));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(oderDetailServiceIMP.findAll());
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
