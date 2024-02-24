package com.example.electrostore.repository;

import com.example.electrostore.entity.ProductdetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductdetailEntity,Integer> {
}
