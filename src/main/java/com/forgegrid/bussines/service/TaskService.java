package com.forgegrid.bussines.service;

import com.forgegrid.dal.entity.TaskEntity;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.TaskForm;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Optional<TaskEntity> getByID(Long id);
    void addTask(TaskForm taskForm);
    void editTask(TaskEntity taskForm);
    void deleteTask(Long id);
    List<TaskEntity> getTasksByCreator(UserEntity creator);
    List<TaskEntity> getAll();
}
