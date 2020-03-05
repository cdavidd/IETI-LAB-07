package edu.escuelaing.ieti.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import edu.escuelaing.ieti.app.model.Task;
import edu.escuelaing.ieti.app.model.User;
import edu.escuelaing.ieti.app.services.TaskService;

public class TaskServiceImpl implements TaskService {

    private ConcurrentHashMap<String, Task> taskMap = new ConcurrentHashMap<>();

    @Override
    public List<Task> geAll() {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskMap.values());
        return tasks;
    }

    @Override
    public Task getById(String id) {
        return taskMap.get(id);
    }

    @Override
    public List<Task> getByUserId(String userId) {
        List<Task> tasks = new ArrayList<>();
        for (Task t : taskMap.values()) {
            if (t.getResponsible().getId().equals(userId)) {
                tasks.add(t);
            }
        }
        return tasks;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        Task t = null;
        if (taskMap.containsKey(taskId)) {
            t = taskMap.get(taskId);
            t.setResponsible(user);
        }
        return t;
    }

    @Override
    public void remove(String taskId) {
        taskMap.remove(taskId);

    }

    @Override
    public Task update(Task task) {
        return taskMap.replace(task.getId(), task);
    }

}