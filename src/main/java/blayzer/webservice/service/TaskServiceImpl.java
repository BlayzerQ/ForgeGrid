package blayzer.webservice.service;

import blayzer.webservice.entities.News;
import blayzer.webservice.entities.Task;
import blayzer.webservice.repository.NewsRepository;
import blayzer.webservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task getByID(Long id) {
        return taskRepository.findOne(id);
    }

    @Override
    public Task addTask(Task user) {
        return taskRepository.saveAndFlush(user);
    }

    @Override
    public Task editTask(Task user) {
        return taskRepository.saveAndFlush(user);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

}
