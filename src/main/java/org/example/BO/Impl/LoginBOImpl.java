package org.example.BO.Impl;

import org.example.BO.LoginBO;
import org.example.DAO.DAOFactory;
import org.example.DAO.Impl.LoginDAO;
import org.example.DTO.LoginDTO;
import org.example.Entity.Login;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Login);

    @Override
    public boolean save(LoginDTO dto) throws Exception {
        return loginDAO.save(new Login(dto.getLogin(),dto.getUserID(),dto.getDate()));
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return loginDAO.generateNextId();
    }
}
