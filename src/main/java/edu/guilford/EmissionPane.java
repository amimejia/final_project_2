package edu.guilford;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.net.URISyntaxException;

import javafx.scene.Node;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.xml.transform.SourceLocator;

import javafx.stage.Stage;

public class EmissionPane extends BorderPane {

    private Path dataLocation;
    private StackedAreaChart<Double, Double> areaChart;
    // private List<EmissionData_Coal> emission_use_coal_list;
    // private List<Data_Solar> Data_use_solar_list;
    // private List<Data_CrudeOil> Data_use_crudeoil_list;

    
    // private ArrayList<XYChart.Data<Double, Double>> coalData = new ArrayList<>();
    // private ArrayList<XYChart.Data<Double, Double>> solarData = new ArrayList<>();
    // private ArrayList<XYChart.Data<Double, Double>> crudeOilData = new ArrayList<>();
    // private ArrayList<XYChart.Data<Double, Double>> naturalGasData = new ArrayList<>();
    // private ArrayList<XYChart.Data<Double, Double>> traditionalBiofuels = new ArrayList<>();
    // private ArrayList<XYChart.Data<Double, Double>> hydropowerData = new ArrayList<>();
    // private ArrayList<XYChart.Data<Double, Double>> nuclearData = new ArrayList<>();

    // Constructor
    public EmissionPane() {

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Year");
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1800);
        xAxis.setUpperBound(2020);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Primary Energy Consumption in TWh");

        //Read the file and grab/read the data
        try {
            dataLocation = Paths.get(Emission_Final_Project.class
                    .getResource("/edu/guilford/cleaned_emissions_past_future.csv").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        readCSV(dataLocation);

        // Instantiate a List object in order to use the emissionDataList
        List<EmissionData_Coal> emission_use_coal_list = readCSV(dataLocation);
        List<Data_Solar> Data_use_solar_list = readCSV_solar(dataLocation);
        List<Data_CrudeOil> Data_use_crudeoil_list = readCSV_crudeoil(dataLocation);
        List<Data_NaturalGas> Data_use_naturalgas_list = readCSV_naturalgas(dataLocation);
        List<Data_TraditionalBiofuel> Data_use_traditionalbiofuels_list = readCSV_traditionalbiofuel(dataLocation);

        //System.out.println(emission_use_coal_list);

        //Make an ArrayList of XYChart.Data objects
        ArrayList<XYChart.Data<Double, Double>> coalData = new ArrayList<>();
        for (EmissionData_Coal data : emission_use_coal_list) {
            coalData.add(new XYChart.Data<>((data.getYear()), data.getCoal()));
        }
        ArrayList<XYChart.Data<Double, Double>> solarData = new ArrayList<>();
        for (Data_Solar data : Data_use_solar_list) {
            solarData.add(new XYChart.Data<>((data.getYear()), data.getSolar()));
        }
        ArrayList<XYChart.Data<Double, Double>> crudeOilData = new ArrayList<>();
        for (Data_CrudeOil data : Data_use_crudeoil_list) {
            crudeOilData.add(new XYChart.Data<>((data.getYear()), data.getCrudeoil()));
        }
        ArrayList<XYChart.Data<Double, Double>> naturalGasData = new ArrayList<>();
        for (Data_NaturalGas data : Data_use_naturalgas_list) {
            naturalGasData.add(new XYChart.Data<>((data.getYear()), data.getNaturalgas()));
        }
        ArrayList<XYChart.Data<Double, Double>> traditionalBiofuels = new ArrayList<>();
        for (Data_TraditionalBiofuel data : Data_use_traditionalbiofuels_list) {
            traditionalBiofuels.add(new XYChart.Data<>((data.getYear()), data.getTraditionalbiofuel()));
        }


        // Make XYChart.Series objects
        XYChart.Series<Double, Double> coalseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> solarseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> crudeoilseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> naturalgasseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> traditionalbiofuelseries = new XYChart.Series<>();

        // Add the data to the series
        coalseries.getData().addAll(coalData);
        solarseries.getData().addAll(solarData);
        crudeoilseries.getData().addAll(crudeOilData);
        naturalgasseries.getData().addAll(naturalGasData);
        traditionalbiofuelseries.getData().addAll(traditionalBiofuels);

        

        // Instantiate a StackedAreaChart object
        StackedAreaChart<Double, Double> areaChart = new StackedAreaChart(xAxis, yAxis);

        // Add the series to the areaChart
        areaChart.getData().addAll(coalseries);
        areaChart.getData().addAll(solarseries);
        areaChart.getData().addAll(crudeoilseries);
        areaChart.getData().addAll(naturalgasseries);
        areaChart.getData().addAll(traditionalbiofuelseries);
        
        this.setCenter(areaChart);

    }

    // Method for reading csv file
    private List<EmissionData_Coal> readCSV(Path dataLocation) {
        List<EmissionData_Coal> EmissionData_Coal = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
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

    private List<Data_Solar> readCSV_solar(Path dataLocation) {
        List<Data_Solar> Data_Solar = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double solar = Double.parseDouble(column[2]);
                Data_Solar.add(new Data_Solar(year, solar));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_Solar;
    }

    private List<Data_CrudeOil> readCSV_crudeoil(Path dataLocation) {
        List<Data_CrudeOil> Data_CrudeOil = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double crudeoil = Double.parseDouble(column[3]);
                Data_CrudeOil.add(new Data_CrudeOil(year, crudeoil));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_CrudeOil;
    }

    private List<Data_NaturalGas> readCSV_naturalgas(Path dataLocation) {
        List<Data_NaturalGas> Data_NaturalGas = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double naturalgas = Double.parseDouble(column[4]);
                Data_NaturalGas.add(new Data_NaturalGas(year, naturalgas));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_NaturalGas;
    }

    private List<Data_TraditionalBiofuel> readCSV_traditionalbiofuel(Path dataLocation) {
        List<Data_TraditionalBiofuel> Data_TraditionalBiofuels = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double traditionalbiofuel = Double.parseDouble(column[5]);
                Data_TraditionalBiofuels.add(new Data_TraditionalBiofuel(year, traditionalbiofuel));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_TraditionalBiofuels;
    }

    
}
