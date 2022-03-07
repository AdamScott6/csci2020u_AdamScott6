package com.example.lab05;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Lab05Controller implements Initializable {

    @FXML private TableView<StudentRecord> tableView;
    @FXML private TableColumn<StudentRecord, String> studentID;
    @FXML private TableColumn<StudentRecord, Float> midterm;
    @FXML private TableColumn<StudentRecord, Float> assignments;
    @FXML private TableColumn<StudentRecord, Float> finalExam;
    @FXML private TableColumn<StudentRecord, Double> finalMark;
    @FXML private TableColumn<StudentRecord, String> letterGrade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("studentID"));
        midterm.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
        assignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignments"));
        finalExam.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finalExam"));
        finalMark.setCellValueFactory(new PropertyValueFactory<StudentRecord, Double>("finalMark"));
        letterGrade.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letterGrade"));

        tableView.getItems().setAll(DataSource.getAllMarks());
    }
}