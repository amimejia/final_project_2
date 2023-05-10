package edu.guilford;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.net.URISyntaxException;

import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.stage.Stage;

public class EmissionPane extends BorderPane {

    private Path dataLocation;
    private StackedAreaChart<Double, Double> areaChart;
    private List<EmissionData_Coal> emission_use_coal_list;

    // Constructor
    public EmissionPane() {

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Primary Energy Consumption in TWh");
        CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Year");
        
        // Read the file and grab/read the data
        try {
            dataLocation = Paths.get(Emission_Final_Project.class
                    .getResource("/edu/guilford/cleaned_emissions_past_future.csv").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        readCSV(dataLocation);

        // Instantiate a List object in order to use the emissionDataList
        List<EmissionData_Coal> emission_use_coal_list = readCSV(dataLocation);
        // System.out.println(emission_use_coal_list);

        // Make coalData contain the data from the csv file
        ArrayList<XYChart.Data<Double, Double>> coalData = new ArrayList<>();
        for (EmissionData_Coal data : emission_use_coal_list) {
            coalData.add(new XYChart.Data<>((data.getYear()), data.getCoal()));
        }
        // System.out.println(coalData);
        for (EmissionData_Coal data : emission_use_coal_list) {
            coalData.add(new XYChart.Data<>(data.getYear(), data.getCoal()));
        }
        XYChart.Series<Double, Double> coalseries = new XYChart.Series<>();
        coalseries.getData().addAll(coalData);
        StackedAreaChart<Double, Double> areaChart = new StackedAreaChart<>(xAxis, yAxis);
        areaChart.getData().addAll(coalseries);

        this.setCenter(areaChart);
        

    }

    // Method for reading csv file
    private List<EmissionData_Coal> readCSV(Path dataLocation) {
        List<EmissionData_Coal> EmissionData_Coal = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        // String csvDelimiter = ",";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double coal = Double.parseDouble(column[1]);
                EmissionData_Coal.add(new EmissionData_Coal(year, coal));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return EmissionData_Coal;
    }
}
