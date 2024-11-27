package org.example.DAO.Impl;

import org.example.DAO.CrudDAO;
import org.example.Entity.Login;

public interface LoginDAO extends CrudDAO<Login> {
    Login getLastLogin();
}
