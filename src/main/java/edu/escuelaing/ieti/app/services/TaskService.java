package edu.escuelaing.ieti.app.services;

import java.util.List;

import edu.escuelaing.ieti.app.model.Task;
import edu.escuelaing.ieti.app.model.User;

public interface TaskService {
    List<Task> geAll();

    Task getById(String id);

    List<Task> getByUserId(String userId);

    Task assignTaskToUser(String taskId, User user);

    void remove(String taskId);

    Task update(Task task);
}