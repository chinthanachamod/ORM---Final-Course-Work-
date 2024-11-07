package org.example.DAO;

import org.example.Entity.User;

public interface UserDAO extends CrudDAO<User> {
    public User searchByUsername(String username);
}
