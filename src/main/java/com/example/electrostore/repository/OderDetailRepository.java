package com.example.electrostore.repository;

import com.example.electrostore.entity.OrderdetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailRepository extends JpaRepository<OrderdetailEntity,Integer> {
}
