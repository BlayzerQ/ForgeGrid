package com.forgegrid.dal.repository;

import com.forgegrid.dal.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> getProductsByDeveloper(String developer);
}
