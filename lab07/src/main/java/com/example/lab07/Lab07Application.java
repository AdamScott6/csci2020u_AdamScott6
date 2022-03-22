package com.example.lab07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Lab07Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<PieChart.Data> pieData = getPieChartData();

        PieChart pieChart = new PieChart(pieData);
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setClockwise(true);
        pieChart.setLabelsVisible(false);
        pieChart.setStartAngle(70);

        Scene scene = new Scene(new Group(pieChart), 600, 400);
        stage.setTitle("Lab07");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private ObservableList<PieChart.Data> getPieChartData() throws IOException {
        HashMap<String, Double> weatherCountMap = getDataCount();

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

        for(Map.Entry entry : weatherCountMap.entrySet()) {
            pieData.add(new PieChart.Data((String) entry.getKey(), (Double) entry.getValue()));
        }

        return pieData;
    }

    private HashMap<String, Double> getDataCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/example/lab07/weatherwarnings-2015.csv"));
        String line = "";
        String splitBy = ",";

        HashMap<String, Double> weatherCountMap = new HashMap<String, Double>();

        while ((line = bufferedReader.readLine()) != null) {
            String weatherWarning = line.split(splitBy)[5];
            if (weatherCountMap.containsKey(weatherWarning)) {
                weatherCountMap.put(weatherWarning, weatherCountMap.get(weatherWarning) + 1);
            } else {
                weatherCountMap.put(weatherWarning, 1.0);
            }
        }

        return weatherCountMap;
    }
}