package com.example.electrostore.services;


import com.example.electrostore.dto.CategoryDTO;
import com.example.electrostore.dto.ProductDTO;
import com.example.electrostore.entity.CategoryEntity;
import com.example.electrostore.entity.ProductEntity;
import com.example.electrostore.exception.ProductNotfoundException;
import com.example.electrostore.repository.ProductRepository;
import com.example.electrostore.services.imp.FileServiceIMP;
import com.example.electrostore.services.imp.ProductServiceIMP;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceIMP {

    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FileServiceIMP fileServiceIMP;

    @Autowired
    private HttpServletRequest request;

    @Override
    public List<ProductDTO> findAll() {
        String domain = request.getRequestURL().toString();
        String conTextPath= request.getContextPath();
        String dynamicDomain = domain.replace(conTextPath,"");
        List<ProductDTO> listdto = new ArrayList<>();
        List<ProductEntity> productEntity = productRepository.findAll();
        for (ProductEntity items: productEntity) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(items.getId());
            productDTO.setImages(dynamicDomain + "/files/" +items.getImages());
            productDTO.setTitle(items.getTitle());
            productDTO.setPrice(items.getPrice());
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(items.getCategoryEntity().getId());
            productDTO.setIdCategory(categoryDTO.getId());
            listdto.add(productDTO);
        }
        if(listdto !=null){
            return listdto;
        }else {
            logger.info("Lỗi findAll Product ");
            throw new ProductNotfoundException("Lỗi findAll Product ");
        }

    }

    @Override
    public ProductDTO findById(int id) {
        String domain = request.getRequestURL().toString();
        String conTextPath = request.getContextPath();
        String dynamicDomain = domain.replace(conTextPath, "");
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        ProductDTO productDTO = new ProductDTO();
        if (productEntity.isPresent()) {

            productDTO.setId(productEntity.get().getId());
            productDTO.setImages(dynamicDomain + "/files/" + productEntity.get().getImages());
            productDTO.setTitle(productEntity.get().getTitle());
            productDTO.setPrice(productEntity.get().getPrice());
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(productEntity.get().getCategoryEntity().getId());
            productDTO.setIdCategory(categoryDTO.getId());
        }
        if (productDTO != null) {
            return productDTO;
        } else {
            logger.info("Lỗi findAll Product ");
            throw new ProductNotfoundException("Lỗi findAll Product ");
        }
    }

    @Override
    public List<ProductDTO> findAll3new() {
        String domain = request.getRequestURL().toString();
        String conTextPath= request.getContextPath();
        String dynamicDomain = domain.replace(conTextPath,"");

            List<ProductDTO> listdto = new ArrayList<>();
            List<ProductEntity> productEntity = productRepository.findTop3ByCategoryId();
            for (ProductEntity items : productEntity) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(items.getId());
                productDTO.setImages(dynamicDomain + "/files/" + items.getImages());
                productDTO.setTitle(items.getTitle());
                productDTO.setPrice(items.getPrice());
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(items.getCategoryEntity().getId());
                productDTO.setIdCategory(categoryDTO.getId());
                listdto.add(productDTO);
            }
            if (listdto != null) {
                return listdto;
            } else {
                logger.info("Lỗi findAll Product ");
                throw new ProductNotfoundException("Lỗi findAll Product ");
            }
    }


    @Override
    public ProductEntity save(MultipartFile file, String title, double price, int idCategory) {
        fileServiceIMP.save(file);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setImages(file.getOriginalFilename());
        productEntity.setTitle(title);
        productEntity.setPrice(price);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(idCategory);
        productEntity.setCategoryEntity(categoryEntity);
        logger.info("Inset Product ");
        return productRepository.save(productEntity);
    }


    @Override
    public ProductEntity update(MultipartFile file,int id, String title, double price, int idCategory) {
        Optional<ProductEntity> productEntity1 = productRepository.findById(id);
            if (productEntity1.isPresent()) {
                fileServiceIMP.save(file);
                ProductEntity productEntity = new ProductEntity();
                productEntity.setId(id);
                productEntity.setImages(file.getOriginalFilename());
                productEntity.setTitle(title);
                productEntity.setPrice(price);

                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setId(idCategory);
                productEntity.setCategoryEntity(categoryEntity);


                logger.info("Update Product " + id);
                productRepository.save(productEntity);
                return productEntity;
            }else {
                throw new ProductNotfoundException("Id Product không tồn tại");
            }
    }

    @Override
    public Boolean deleteProduct(int id) {
        Optional<ProductEntity> productEntity1 = productRepository.findById(id);
        if(productEntity1.isPresent()){
            ProductEntity productEntity = productRepository.deleteById(id);
            logger.info("Delete Product Success " + id);
            return true;
        }else {
            logger.info("Delete false");
            throw new ProductNotfoundException(" Id Product Không tồn tại ");
        }

    }
}
