package org.example.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.BO.BOFactory;
import org.example.BO.Impl.UserBOImpl;
import org.example.BO.StudentBO;
import org.example.BO.UserBO;
import org.example.DAO.DAOFactory;
import org.example.DAO.Impl.StudentDAO;
import org.example.DAO.Impl.UserDAO;
import org.example.DTO.StudentDTO;
import org.example.DTO.UserDTO;
import org.example.Entity.User;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    @FXML
    private ComboBox cmbUser;
    @FXML
    private TableColumn colUserID;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;


    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colStudentID;

    @FXML
    private Label lblStudentID;

    @FXML
    private TableView<StudentDTO> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Student);
    UserBO userBO = (UserBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoType.User);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.User);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Student);

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadAll();
        generateNextId();
        getIds();
       /* lblUserID(id);*/


        tblStudents.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                lblStudentID.setText(newSelection.getStu_id());
                txtName.setText(newSelection.getStu_name());
                txtAddress.setText(newSelection.getStu_address());
                txtPhoneNumber.setText(newSelection.getStu_phone());
                txtEmail.setText(newSelection.getStu_email());
                cmbUser.setValue(newSelection.getUser().getUser_id());
            }
        });
    }


    private void generateNextId() throws SQLException, ClassNotFoundException {
        String code = studentBO.generateNextId();
        lblStudentID.setText(code);
    }

    private void loadAll() {
        ObservableList<StudentDTO> obList = FXCollections.observableArrayList();
        try {
            List<StudentDTO> StudentDTOList = studentBO.getAll();
            for (StudentDTO studentDTO : StudentDTOList) {
                StudentDTO tm = new StudentDTO(
                        studentDTO.getStu_id(),
                        studentDTO.getStu_name(),
                        studentDTO.getStu_phone(),
                        studentDTO.getStu_email(),
                        studentDTO.getStu_address(),
                         new UserDTO( studentDTO.getUser().getUser_id(),
                                 studentDTO.getUser().getUsername(),
                                 studentDTO.getUser().getAddress(),
                                 studentDTO.getUser().getUser_phone(),
                                 studentDTO.getUser().getUser_email(),
                                 studentDTO.getUser().getPosition(),
                                 studentDTO.getUser().getPassword())
                );

                obList.add(tm);
            }

            tblStudents.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
colAddress.setCellValueFactory(new PropertyValueFactory<>("stu_address"));
colEmail.setCellValueFactory(new PropertyValueFactory<>("stu_email"));
colName.setCellValueFactory(new PropertyValueFactory<>("stu_name"));
colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("stu_phone"));
colStudentID.setCellValueFactory(new PropertyValueFactory<>("stu_id"));
colUserID.setCellValueFactory(new PropertyValueFactory<>("user"));
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
    try {
        String UserID = String.valueOf(cmbUser.getValue());
        String S_id = lblStudentID.getText();
        String S_Name = txtName.getText();
        String Email = txtEmail.getText();
        String phone = txtPhoneNumber.getText();
        String Address = txtAddress.getText();

        User user = userBO.searchByIdUser(UserID);
        UserDTO userDTO = new UserDTO(user.getUser_id(),user.getUsername(),user.getAddress(),user.getUser_phone(),user.getUser_email(),user.getPosition(),user.getPassword());


        StudentDTO studentDTO = new StudentDTO(S_id,S_Name,phone,Email,Address,userDTO);
        boolean isSave = studentBO.save(studentDTO);

        if (isSave){
            new Alert(Alert.AlertType.CONFIRMATION, "User saved successfully!").show();
            clear();
            loadAll();
            generateNextId();

        } else {
            new Alert(Alert.AlertType.ERROR, "User not saved successfully!").show();
        }
    
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    private void clear() throws SQLException, ClassNotFoundException {
        txtName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();
        cmbUser.getSelectionModel().clearSelection();
        generateNextId();
    }


    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashBoard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
  String S_id = lblStudentID.getText();
        try {
            boolean isDeleted = studentBO.delete(S_id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student deleted successfully!").show();
                clear();
                loadAll();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to delete Student!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            String UserID = String.valueOf(cmbUser.getValue());
            String S_id = lblStudentID.getText();
            String S_Name = txtName.getText();
            String Email = txtEmail.getText();
            String phone = txtPhoneNumber.getText();
            String Address = txtAddress.getText();

            User user = userBO.searchByIdUser(UserID);
            UserDTO userDTO = new UserDTO(user.getUser_id(),user.getUsername(),user.getAddress(),user.getUser_phone(),user.getUser_email(),user.getPosition(),user.getPassword());


            StudentDTO studentDTO = new StudentDTO(S_id,S_Name,phone,Email,Address,userDTO);
            boolean isSave = studentBO.update(studentDTO);

            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION, "User update successfully!").show();
                clear();
                loadAll();
                generateNextId();

            } else {
                new Alert(Alert.AlertType.ERROR, "Student not update successfully!").show();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbUserOnAction(ActionEvent actionEvent) {

    }

    private void getIds() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> UID = userBO.getUserIds();

            for (String s : UID) {
                obList.add(s);
            }
            cmbUser.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
