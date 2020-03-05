package edu.escuelaing.ieti.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.ieti.app.model.Task;
import edu.escuelaing.ieti.app.model.User;
import edu.escuelaing.ieti.app.persistence.impl.TaskPersistenceImpl;
import edu.escuelaing.ieti.app.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskPersistenceImpl taskPersistenceImpl;

    @Override
    public List<Task> geAll() {
        return taskPersistenceImpl.geAll();
    }

    @Override
    public Task getById(String id) {
        return taskPersistenceImpl.getById(id);
    }

    @Override
    public List<Task> getByUserId(String userId) {
        return taskPersistenceImpl.getByUserId(userId);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return taskPersistenceImpl.assignTaskToUser(taskId, user);
    }

    @Override
    public void remove(String taskId) {
        taskPersistenceImpl.remove(taskId);

    }

    @Override
    public Task update(Task task) {
        return taskPersistenceImpl.update(task);
    }

}