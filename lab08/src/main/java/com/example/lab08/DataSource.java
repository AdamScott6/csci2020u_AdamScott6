package com.example.lab08;

import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.util.List;

public class DataSource {
    public static ObservableList<StudentRecord> getAllMarks() {
        ObservableList<StudentRecord> marks =
                FXCollections.observableArrayList();

// Student ID, Assignments, Midterm, Final exam
        marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));

        return marks;
    }

    public static ObservableList<StudentRecord> getDataFromCSV(String fileName) throws Exception {
        ObservableList<StudentRecord> data = FXCollections.observableArrayList();
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<String[]> list = csvReader.readAll();
        for (int i=1; i < list.size(); i++) {
            String[] record  = list.get(i);
            StudentRecord studentRecord = new StudentRecord(record[0], Float.parseFloat(record[1]), Float.parseFloat(record[2]), Float.parseFloat(record[3]));
            data.add(studentRecord);
        }
        csvReader.close();
        return data;
    }
}
