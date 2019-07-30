package com.forgegrid.bussines.service;

import com.forgegrid.dal.entity.TaskEntity;
import com.forgegrid.dal.repository.TaskRepository;
import com.forgegrid.dal.entity.UserEntity;
import com.forgegrid.presentation.dto.TaskForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Optional<TaskEntity> getByID(Long id) {
        return Optional.of(taskRepository.findById(id).get());
    }

    @Override
    public void addTask(TaskForm user) {
        TaskEntity taskEntity = new TaskEntity(user.getTitle(), user.getDescription(), user.getLink(), user.getCreator(), user.getPrice());
        taskRepository.saveAndFlush(taskEntity);
    }

    @Override
    public void editTask(TaskEntity user) {
        taskRepository.saveAndFlush(user);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskEntity> getTasksByCreator(UserEntity user) {
        return taskRepository.getTasksByCreator(user.getLogin());
    }

    @Override
    public List<TaskEntity> getAll() {
        return taskRepository.findAll();
    }

}
