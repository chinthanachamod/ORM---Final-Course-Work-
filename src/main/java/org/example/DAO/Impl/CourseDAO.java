package org.example.DAO.Impl;

import org.example.DAO.CrudDAO;
import org.example.Entity.Course;

import java.sql.SQLException;

public interface CourseDAO extends CrudDAO<Course> {
    Course searchByName(String id) throws SQLException, ClassNotFoundException;
}
