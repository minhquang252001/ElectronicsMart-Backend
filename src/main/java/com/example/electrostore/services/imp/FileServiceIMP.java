package com.example.electrostore.services.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceIMP {
    void save(MultipartFile file);

    Resource load(String filename);
}
