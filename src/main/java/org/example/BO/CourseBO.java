package org.example.BO;

import org.example.DTO.CourseDTO;

public interface CourseBO extends SuperBO{

    public boolean save(CourseDTO dto) throws Exception;

    public boolean update(CourseDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;
}
