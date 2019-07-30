package com.forgegrid.dal.repository;

import com.forgegrid.dal.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> getTasksByCreator(String creator);
}
