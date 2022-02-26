package com.example.lab04fx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FXController {
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField fullNameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private DatePicker dobTF;
    @FXML
    private Button registerButton;

    @FXML
    protected void onRegisterButtonClick() {
        System.out.println(usernameTF.getText());
        System.out.println(passwordField.getText());
        System.out.println(fullNameTF.getText());
        System.out.println(emailTF.getText());
        System.out.println(phoneTF.getText());
        System.out.println(dobTF.getValue().toString());
    }
}