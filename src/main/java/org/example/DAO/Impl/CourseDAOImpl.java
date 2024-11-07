package org.example.DAO.Impl;

import org.example.DAO.CourseDAO;
import org.example.Entity.Course;

import java.sql.SQLException;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }

    @Override
    public List<Course> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public Course searchByIdCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
