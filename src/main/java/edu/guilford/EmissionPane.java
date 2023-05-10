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
import java.util.List;

import javafx.stage.Stage;

public class EmissionPane extends BorderPane {

    
   
    private Path dataLocation;

    //This seems like a basic question but now I'm wondering if the data provided by the reading through the method becomes an attribute of emissionPane
    private List<emissionData> emissionDataList;
    
    //Constructor
    public EmissionPane() {

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Primary Energy Consumption in TWh");
        CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Year");


        //What's the difference between raw type and generic type of writing this?
        //StackedAreaChart<String, Number> stack = new StackedAreaChart<>(xAxis, yAxis);
        StackedAreaChart<String, String> areaChart = new StackedAreaChart<>(xAxis, yAxis);

        //Read the file and grab/read the data
        // try {
        //     dataLocation = Paths.get(Emission_Final_Project.class.getResource("/edu/guilford/cleaned_emissions_past_future.csv").toURI());
        // } catch (URISyntaxException e) {
        //     e.printStackTrace();
        // }
        // readCSV(dataLocation);

        List<XYChart.Series<String, String>> seriesList = new ArrayList<>();
        for (String fuelType : emissionDataList.get(0).getFuelType()) {
            XYChart.Series<String, String> series = new XYChart.Series<>();
            series.setName(fuelType);
            for (emissionData emissionData : emissionDataList) {
                if (data.)
            }
            seriesList.add(series);
        }



    }

    // //Method for reading csv file
    // private List<emissionData> readCSV(Path dataLocation) {
    //     List<emissionData> emissionDataList = new ArrayList<>();
    //     BufferedReader br = null;
    //     String line = "";
    //     //String csvDelimiter = ",";
    //     try {
    //         br = new BufferedReader(new FileReader(dataLocation.toFile()));
    //         //.readLine() reads the first line of the csv file
    //         br.readLine();
    //         while ((line = br.readLine())!= null) {
    //             String[] column = line.split(",");
    //             String year = column[0];
    //             double coal  = Double.parseDouble(column[1]);
    //             double solar = Double.parseDouble(column[2]);
    //             double crudeOil = Double.parseDouble(column[3]);
    //             double naturalGas = Double.parseDouble(column[4]);
    //             double traditionalBiofuels = Double.parseDouble(column[5]);
    //             double otherRenewables = Double.parseDouble(column[6]);
    //             double hydropower = Double.parseDouble(column[7]);
    //             double nuclear = Double.parseDouble(column[8]);
    //             emissionDataList.add(new emissionData(year, coal, solar, crudeOil, naturalGas, traditionalBiofuels, otherRenewables, hydropower, nuclear));
    //             line = br.readLine();
    //         }
    //         if (br != null) {
    //             br.close();
    //         }
    //     } catch (IOException e) {
    //         throw new IOError(e);
    //     }
    //     return emissionDataList;
    // }

}
