package edu.escuelaing.ieti.app.persistence;

import java.util.List;

import edu.escuelaing.ieti.app.model.User;

public interface UserPersistence {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);
}