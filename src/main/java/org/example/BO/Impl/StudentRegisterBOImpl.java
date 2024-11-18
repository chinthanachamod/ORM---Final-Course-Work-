package org.example.BO.Impl;

import org.example.BO.BOFactory;
import org.example.BO.PaymentBO;
import org.example.BO.Student_CourseBO;
import org.example.DTO.StudentRegisterPlaceDTO;
import org.example.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRegisterBOImpl {

    public static boolean StudentRegisterPlace(StudentRegisterPlaceDTO SR) {
        PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Payment);
        Student_CourseBO studentCourseBO = (Student_CourseBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Student_Course);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            boolean isStudentRegister_SC = studentCourseBO.save(SR.getStudent_course());
            if (isStudentRegister_SC) {
                boolean isPay = paymentBO.save(SR.getStudent_payment());
                if (isPay) {
                    transaction.commit();
                    return true;
                }
            }
            if (transaction != null) transaction.rollback();
            return false;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
