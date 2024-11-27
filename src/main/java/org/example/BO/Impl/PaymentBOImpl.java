package org.example.BO.Impl;

import org.example.BO.PaymentBO;
import org.example.DAO.DAOFactory;
import org.example.DAO.Impl.PaymentDAO;
import org.example.DTO.CourseDTO;
import org.example.DTO.PaymentDTO;
import org.example.DTO.StudentDTO;
import org.example.DTO.Student_CourseDTO;
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
        return paymentDAO.update(new Payment(
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
        List<Payment> payment = paymentDAO.getAll();
        List<PaymentDTO> dto = new ArrayList<>();
        for (Payment payment1 : payment) {
            dto.add(new PaymentDTO(payment1.getPay_id(),payment1.getPay_date(),payment1.getPay_amount(),new Student_CourseDTO(payment1.getStudent_course().getStudent_course_id(),new StudentDTO(),new CourseDTO(),payment1.getStudent_course().getRegistration_date())));
        }
        return dto;
    }
}
