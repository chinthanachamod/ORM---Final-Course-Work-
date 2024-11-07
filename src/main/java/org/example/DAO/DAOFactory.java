package org.example.DAO;

import org.example.DAO.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DaoType {
        User, Student, Payment, Course, Student_Course
    }

    public SuperDAO getDAO(DaoType daoType) {
        switch (daoType) {
            case User:
                return new UserDAOImpl();
            case Student:
                return new StudentDAOImpl();
            case Payment:
                return new PaymentDAOImpl();
            case Course:
                return new CourseDAOImpl();
            case Student_Course:
                return new Student_CourseDAOImpl();
            default:
                return null;
        }
    }

}