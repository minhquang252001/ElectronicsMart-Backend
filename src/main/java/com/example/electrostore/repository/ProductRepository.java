package com.example.electrostore.repository;

import com.example.electrostore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity deleteById(int id);

    @Query(value = "SELECT * FROM product p ORDER BY p.id DESC LIMIT 9", nativeQuery = true)
    List<ProductEntity> findTop3ByCategoryId();
}
