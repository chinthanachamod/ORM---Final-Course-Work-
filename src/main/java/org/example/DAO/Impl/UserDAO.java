package org.example.DAO.Impl;

import org.example.DAO.CrudDAO;
import org.example.Entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    public User searchByUsername(String username);

    List<String> getUserIds();
}
