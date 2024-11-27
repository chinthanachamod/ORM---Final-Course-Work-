package org.example.DAO.Impl;

import org.example.DAO.CrudDAO;
import org.example.Entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student> {
    public Student searchByContact(String id) throws SQLException, ClassNotFoundException;
}
