package com.example.electrostore.controller;

import com.example.electrostore.payload.reponse.BaseResponse;
import com.example.electrostore.services.imp.FileServiceIMP;
import com.example.electrostore.services.imp.ProductServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceIMP productServiceIMP;

    @Autowired
    private FileServiceIMP fileServiceIMP;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Hiển thị tất cả Product");
        baseResponse.setData(productServiceIMP.findAll());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @GetMapping("/new")
    public ResponseEntity<?> findAll3new(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Hiển thị tất cả Product");
        baseResponse.setData(productServiceIMP.findAll3new());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<?> findById(@RequestParam int id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Hiển thị Product By Id ");
        baseResponse.setData(productServiceIMP.findById(id));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> save(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam double price,
            @RequestParam int idCategory){

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Insert Product");
        baseResponse.setData(productServiceIMP.save(file,title,price,idCategory));
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int id,
                                    @RequestParam MultipartFile file,
                                    @RequestParam String title,
                                    @RequestParam double price,
                                    @RequestParam int idCategory){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData("Update Product");
        baseResponse.setData(productServiceIMP.update(file,id,title,price,idCategory));
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Delete Product");
        baseResponse.setData(productServiceIMP.deleteProduct(id));
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }



    @GetMapping("/files/{filename}")
    public ResponseEntity<?>file (@PathVariable String filename){
        Resource resource = fileServiceIMP.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").body(resource);
    }
    @GetMapping("/new/files/{filename}")
    public ResponseEntity<?>filenew (@PathVariable String filename){
        Resource resource = fileServiceIMP.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").body(resource);
    }
    @GetMapping("/id/files/{filename}")
    public ResponseEntity<?>findByIdfile (@PathVariable String filename){
        Resource resource = fileServiceIMP.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").body(resource);
    }

}
