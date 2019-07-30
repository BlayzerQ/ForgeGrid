package com.forgegrid.bussines.service;

import com.forgegrid.dal.entity.NewsEntity;
import com.forgegrid.dal.repository.NewsRepository;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.NewsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public NewsEntity getByID(Long id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public void addItem(NewsForm form) {
        NewsEntity entity = new NewsEntity(form.getTitle(), form.getDescription());
        newsRepository.saveAndFlush(entity);
    }

    @Override
    public void editItem(NewsEntity user) {
        newsRepository.saveAndFlush(user);
    }

    @Override
    public void deleteItem(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public List<NewsEntity> getAll() {
        return newsRepository.findAll();
    }

}
