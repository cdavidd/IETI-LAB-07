package edu.escuelaing.ieti.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import edu.escuelaing.ieti.app.model.User;
import edu.escuelaing.ieti.app.services.UserService;

public class UserServiceImpl implements UserService {

    private ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.addAll(userMap.values());
        return users;
    }

    @Override
    public User getById(String userId) {
        User user = null;
        if (userMap.containsKey(userId)) {
            user = userMap.get(userId);
        }
        return user;
    }

    @Override
    public User create(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        return userMap.replace(user.getId(), user);
    }

    @Override
    public void remove(String userId) {
        if (userMap.containsKey(userId)) {
            userMap.remove(userId);
        }
    }

}