package org.example.BO;

import org.example.DTO.StudentDTO;

public interface StudentBO extends SuperBO {
    public boolean save(StudentDTO dto) throws Exception;

    public boolean update(StudentDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;
}
