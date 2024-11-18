package org.example.BO.Impl;

import org.example.BO.PaymentBO;
import org.example.DAO.DAOFactory;
import org.example.DAO.Impl.PaymentDAO;
import org.example.DTO.PaymentDTO;
import org.example.Entity.Course;
import org.example.Entity.Payment;
import org.example.Entity.Student;
import org.example.Entity.Student_Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Payment);
    @Override
    public boolean save(PaymentDTO dto) throws Exception {
        return paymentDAO.save(new Payment(
                dto.getPay_id(),
                dto.getPay_date(),
                dto.getPay_amount(),
                new Student_Course(
                        dto.getStudentCourse().getStudent_course_id(),
                        new Student(),
                        new Course(),
                        dto.getStudentCourse().getRegistration_date(),
                        new ArrayList<>()
                )));
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }
    @Override
    public Payment searchById(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.searchByID(id);
    }

    public String generateNextId() throws SQLException, ClassNotFoundException {
        return paymentDAO.generateNextId();
    }

    @Override
    public List<PaymentDTO> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
