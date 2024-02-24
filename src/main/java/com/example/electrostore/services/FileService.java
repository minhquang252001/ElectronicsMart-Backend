package com.example.electrostore.services;

import com.example.electrostore.exception.ProductNotfoundException;
import com.example.electrostore.services.imp.FileServiceIMP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceIMP {

    @Value("${file.path}")
    private Path root;

    @Override
    public void save(MultipartFile file) {
        try {
            if(!Files.exists(root)){
                Files.createDirectories(root);
            }
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            throw new ProductNotfoundException("Lỗi  save File " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try{
            Path file= root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new ProductNotfoundException("Không thể đọc file");
            }
        }catch (Exception e){
            throw new ProductNotfoundException("Không thể đọc file Load " + e.getMessage());
        }
    }

}
