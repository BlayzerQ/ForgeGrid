package com.forgegrid.bussines.service;

import com.forgegrid.dal.entity.ProductEntity;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.ProductForm;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductEntity> getByID(Long id);
    void addItem(ProductForm product);
    void editItem(ProductEntity news);
    void deleteItem(Long id);
    List<ProductEntity> getProductsByDeveloper(UserEntity developer);
    List<ProductEntity> getAll();
}
