package edu.escuelaing.ieti.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.ieti.app.model.User;
import edu.escuelaing.ieti.app.persistence.impl.UserPersistenceImpl;
import edu.escuelaing.ieti.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserPersistenceImpl userPersistenceImpl;

    @Override
    public List<User> getAll() {
        return userPersistenceImpl.getAll();
    }

    @Override
    public User getById(String userId) {
        return userPersistenceImpl.getById(userId);
    }

    @Override
    public User create(User user) {
        return userPersistenceImpl.create(user);
    }

    @Override
    public User update(User user) {
        return userPersistenceImpl.update(user);
    }

    @Override
    public void remove(String userId) {
        userPersistenceImpl.remove(userId);
    }

}