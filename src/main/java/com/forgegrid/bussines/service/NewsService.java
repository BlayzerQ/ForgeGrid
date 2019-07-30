package com.forgegrid.bussines.service;

import com.forgegrid.dal.entity.NewsEntity;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.NewsForm;

import java.util.List;

public interface NewsService {

    NewsEntity getByID(Long id);
    void addItem(NewsForm news);
    void editItem(NewsEntity news);
    void deleteItem(Long id);
    List<NewsEntity> getAll();
}
