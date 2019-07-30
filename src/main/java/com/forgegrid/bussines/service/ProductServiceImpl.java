package com.forgegrid.bussines.service;

import com.forgegrid.dal.entity.ProductEntity;
import com.forgegrid.dal.repository.ProductRepository;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductEntity> getByID(Long id) {
        return Optional.of(productRepository.findById(id).get());
    }

    @Override
    public void addItem(ProductForm form) {
        ProductEntity productEntity = new ProductEntity(form.getType(), form.getTitle(), form.getDescription(), form.getProductVersion(), form.getMcVersion(), form.getDeveloper(), form.getPrice());
        productRepository.saveAndFlush(productEntity);
    }

    @Override
    public void editItem(ProductEntity user) {
        productRepository.saveAndFlush(user);
    }

    @Override
    public void deleteItem(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> getProductsByDeveloper(UserEntity user) {
        return productRepository.getProductsByDeveloper(user.getLogin());
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

}
