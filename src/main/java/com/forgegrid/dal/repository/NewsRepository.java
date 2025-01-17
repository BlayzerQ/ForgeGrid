package com.forgegrid.dal.repository;

import com.forgegrid.dal.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

}
