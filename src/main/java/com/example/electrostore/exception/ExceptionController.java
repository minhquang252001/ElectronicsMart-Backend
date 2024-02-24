package com.example.electrostore.exception;

import com.example.electrostore.payload.reponse.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ProductNotfoundException.class})
    public ResponseEntity<?> hanlderException(ProductNotfoundException e){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        baseResponse.setMessage(e.getTitlerError());
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
