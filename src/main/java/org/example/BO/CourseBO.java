package org.example.BO;

import org.example.DTO.CourseDTO;
import org.example.Entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseBO {

    public boolean save(CourseDTO dto) throws Exception;

    public boolean update(CourseDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;

    public String generateNextId() throws SQLException, ClassNotFoundException;

    public List<CourseDTO> getAll() throws SQLException, ClassNotFoundException;

    List<String> getIds();

    public Course searchById(String id) throws SQLException, ClassNotFoundException;

    Course searchByName(String courseName) throws SQLException, ClassNotFoundException;
}
