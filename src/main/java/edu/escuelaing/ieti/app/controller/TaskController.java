package edu.escuelaing.ieti.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.ieti.app.model.Task;
import edu.escuelaing.ieti.app.model.User;
import edu.escuelaing.ieti.app.services.TaskService;

@RestController
@RequestMapping(value = "/Tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> geAll() {
        List<Task> tasks = new ArrayList<>();
        try {
            tasks = taskService.geAll();
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR 500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") String id) {
        Task task = null;
        try {
            task = taskService.getById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR 500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "userId/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable(name = "userId") String userId) {
        List<Task> tasks = new ArrayList<>();
        try {
            tasks = taskService.getByUserId(userId);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR 500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "assignTask/{taskId}")
    public ResponseEntity<?> assignTaskToUser(@RequestBody User user, @PathVariable(name = "taskId") String taskId) {

        try {
            taskService.assignTaskToUser(taskId, user);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR 500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{taskId}")
    public ResponseEntity<?> remove(@PathVariable(name = "taskId") String taskId) {

        try {
            taskService.remove(taskId);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR 500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Task task) {

        try {
            taskService.update(task);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR 500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}