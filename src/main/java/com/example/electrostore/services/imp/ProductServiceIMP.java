package com.example.electrostore.services.imp;

import com.example.electrostore.dto.ProductDTO;
import com.example.electrostore.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductServiceIMP {

    List<ProductDTO> findAll();
    ProductDTO findById(int id);
    List<ProductDTO> findAll3new();

    ProductEntity save(MultipartFile file, String title, double price, int idCategory);
    ProductEntity update(MultipartFile file,int id, String title, double price, int idCategory);
    Boolean deleteProduct(int id);
}
