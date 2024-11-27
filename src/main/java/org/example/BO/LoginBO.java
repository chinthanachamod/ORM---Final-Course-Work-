package org.example.BO;

import org.example.DTO.LoginDTO;
import org.example.DTO.StudentDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO{
    public boolean save(LoginDTO dto) throws Exception;

    String generateNextId() throws SQLException, ClassNotFoundException;
}