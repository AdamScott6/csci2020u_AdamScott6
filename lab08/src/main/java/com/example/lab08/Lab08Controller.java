package com.example.lab08;

import com.opencsv.CSVWriter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Lab08Controller implements Initializable {
    private String currentFileName;

    @FXML private TableView<StudentRecord> tableView;
    @FXML private TableColumn<StudentRecord, String> studentID;
    @FXML private TableColumn<StudentRecord, Float> midterm;
    @FXML private TableColumn<StudentRecord, Float> assignments;
    @FXML private TableColumn<StudentRecord, Float> finalExam;
    @FXML private TableColumn<StudentRecord, Double> finalMark;
    @FXML private TableColumn<StudentRecord, String> letterGrade;

    @FXML private TextField SIDTextfield;
    @FXML private TextField midtermTextfield;
    @FXML private TextField assignmentsTextfield;
    @FXML private TextField examTextfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("studentID"));
        midterm.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
        assignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignments"));
        finalExam.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("finalExam"));
        finalMark.setCellValueFactory(new PropertyValueFactory<StudentRecord, Double>("finalMark"));
        letterGrade.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letterGrade"));

        tableView.getItems().setAll(DataSource.getAllMarks());

        currentFileName = "Lab08File.csv";
    }

    @FXML
    private void New(ActionEvent event) {
        tableView.getItems().clear();
    }

    @FXML
    private void Open(ActionEvent event) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);

        currentFileName = selectedFile.getAbsolutePath();
        load();
    }
    @FXML
    private void Save(ActionEvent event) throws IOException {
       saveCSV(currentFileName);
    }

    @FXML
    private void SaveAs(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File As");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(null);
        
        currentFileName = selectedFile.getAbsolutePath();
        saveCSV(currentFileName);
    }

    @FXML
    private void Exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void Add(ActionEvent event) {
        tableView.getItems().add(new StudentRecord(SIDTextfield.getText(), Float.parseFloat(midtermTextfield.getText()),
                Float.parseFloat(assignmentsTextfield.getText()), Float.parseFloat(examTextfield.getText())));
    }

    private void load() throws Exception {
        tableView.getItems().setAll(DataSource.getDataFromCSV(currentFileName));
    }

    private void saveCSV(String fileName) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{studentID.getText(), midterm.getText(), assignments.getText(), finalExam.getText()});
        for (StudentRecord record : tableView.getItems()) {
            String[] list = {record.getStudentID(), record.getMidterm().toString(), record.getAssignments().toString(), record.getFinalExam().toString()};
            csvData.add(list);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(csvData);
        }
    }

}