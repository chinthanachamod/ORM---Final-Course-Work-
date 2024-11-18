package org.example.BO;

import org.example.DTO.Student_CourseDTO;

import java.sql.SQLException;
import java.util.List;

public interface Student_CourseBO {
    public boolean save(Student_CourseDTO dto) throws Exception;

    public boolean update(Student_CourseDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;

    List<Student_CourseDTO> getAll() throws SQLException, ClassNotFoundException;

    public String generateNextId() throws SQLException, ClassNotFoundException;
}
