package edu.guilford;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.net.URISyntaxException;

import javafx.geometry.Insets;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.xml.transform.SourceLocator;

import javafx.stage.Stage;

public class EmissionPane extends SplitPane {

    private Path dataLocation;
    private StackedAreaChart<Double, Double> areaChart;
    
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
        List<Data_OtherRenewables> Data_use_otherrenewables_list = readCSV_OtherRenewables(dataLocation);
        List<Data_Hydropower> Data_use_hydropower_list = readCSV_Hydropower(dataLocation);
        List<Data_Nuclear> Data_use_nuclear_list = readCSV_Nuclear(dataLocation);

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
        ArrayList<XYChart.Data<Double, Double>> otherRenewables = new ArrayList<>();
        for (Data_OtherRenewables data : Data_use_otherrenewables_list) {
            otherRenewables.add(new XYChart.Data<>((data.getYear()), data.getOtherRenewables()));
        }
        ArrayList<XYChart.Data<Double, Double>> hydropower = new ArrayList<>();
        for (Data_Hydropower data : Data_use_hydropower_list) {
            hydropower.add(new XYChart.Data<>((data.getYear()), data.getHydropower()));
        }
        ArrayList<XYChart.Data<Double, Double>> nuclear = new ArrayList<>();
        for (Data_Nuclear data : Data_use_nuclear_list) {
            nuclear.add(new XYChart.Data<>((data.getYear()), data.getNuclear()));
        }


        // Make XYChart.Series objects
        XYChart.Series<Double, Double> coalseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> solarseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> crudeoilseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> naturalgasseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> traditionalbiofuelseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> otherrenewableseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> hydropowerseries = new XYChart.Series<>();
        XYChart.Series<Double, Double> nuclearseries = new XYChart.Series<>();

        // Add the data to the series
        coalseries.getData().addAll(coalData);
        solarseries.getData().addAll(solarData);
        crudeoilseries.getData().addAll(crudeOilData);
        naturalgasseries.getData().addAll(naturalGasData);
        traditionalbiofuelseries.getData().addAll(traditionalBiofuels);
        otherrenewableseries.getData().addAll(otherRenewables);
        hydropowerseries.getData().addAll(hydropower);
        nuclearseries.getData().addAll(nuclear);

        

        // Instantiate a StackedAreaChart object
        StackedAreaChart<Double, Double> areaChart = new StackedAreaChart(xAxis, yAxis);
        areaChart.setTitle("Primary Energy Consumption by Fuel Type");
        
        //this.setCenter(areaChart);

        HBox CheckBox = new HBox();
        CheckBox coalCheckBox = new CheckBox("Coal");
        CheckBox solarCheckBox = new CheckBox("Solar");
        CheckBox crudeOilCheckBox = new CheckBox("Crude Oil");
        CheckBox naturalGasCheckBox = new CheckBox("Natural Gas");
        CheckBox traditionalBiofuelCheckBox = new CheckBox("Traditional Biofuel");
        CheckBox otherRenewablesCheckBox = new CheckBox("Other Renewables");
        CheckBox hydropowerCheckBox = new CheckBox("Hydropower");
        CheckBox nuclearCheckBox = new CheckBox("Nuclear");
        coalCheckBox.setStyle("-fx-text-fill: red;-fx-font-weight: bold;");
        solarCheckBox.setStyle("-fx-text-fill: orange;-fx-font-weight: bold;");
        crudeOilCheckBox.setStyle("-fx-text-fill: green;-fx-font-weight: bold;");
        naturalGasCheckBox.setStyle("-fx-text-fill: lightblue;-fx-font-weight: bold;");
        traditionalBiofuelCheckBox.setStyle("-fx-text-fill: blue;-fx-font-weight: bold;");
        otherRenewablesCheckBox.setStyle("-fx-text-fill: purple;-fx-font-weight: bold;");
        hydropowerCheckBox.setStyle("-fx-text-fill: brown;-fx-font-weight: bold;");
        nuclearCheckBox.setStyle("-fx-text-fill: black;-fx-font-weight: bold;");

        coalCheckBox.setOnAction(e -> {
            if (coalCheckBox.isSelected()) {
                areaChart.getData().add(coalseries);
            } else {
                areaChart.getData().remove(coalseries);
            }
        });
        solarCheckBox.setOnAction(e -> {
            if (solarCheckBox.isSelected()) {
                areaChart.getData().add(solarseries);
            } else {
                areaChart.getData().remove(solarseries);
            }
        });
        crudeOilCheckBox.setOnAction(e -> {
            if (crudeOilCheckBox.isSelected()) {
                areaChart.getData().add(crudeoilseries);
            } else {
                areaChart.getData().remove(crudeoilseries);
            }
        });
        naturalGasCheckBox.setOnAction(e -> {
            if (naturalGasCheckBox.isSelected()) {
                areaChart.getData().add(naturalgasseries);
            } else {
                areaChart.getData().remove(naturalgasseries);
            }
        });
        traditionalBiofuelCheckBox.setOnAction(e -> {
            if (traditionalBiofuelCheckBox.isSelected()) {
                areaChart.getData().add(traditionalbiofuelseries);
            } else {
                areaChart.getData().remove(traditionalbiofuelseries);
            }
        });
        otherRenewablesCheckBox.setOnAction(e -> {
            if (otherRenewablesCheckBox.isSelected()) {
                areaChart.getData().add(otherrenewableseries);
            } else {
                areaChart.getData().remove(otherrenewableseries);
            }
        });
        hydropowerCheckBox.setOnAction(e -> {
            if (hydropowerCheckBox.isSelected()) {
                areaChart.getData().add(hydropowerseries);
            } else {
                areaChart.getData().remove(hydropowerseries);
            }
        });
        nuclearCheckBox.setOnAction(e -> {
            if (nuclearCheckBox.isSelected()) {
                areaChart.getData().add(nuclearseries);
            } else {
                areaChart.getData().remove(nuclearseries);
            }
        });

        CheckBox.getChildren().addAll(coalCheckBox, solarCheckBox, crudeOilCheckBox, naturalGasCheckBox, traditionalBiofuelCheckBox, otherRenewablesCheckBox, hydropowerCheckBox, nuclearCheckBox);
        StackPane leftPane = new StackPane();
        leftPane.getChildren().add(areaChart);
        leftPane.getChildren().add(CheckBox);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(leftPane);
        //borderPane.setPadding(new Insets(10));


        // BorderPane leftPane = new BorderPane(areaChart);
        // leftPane.setCenter(CheckBox);
        // SplitPane splitPane = new SplitPane(leftPane, null);
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
    private List<Data_OtherRenewables> readCSV_OtherRenewables(Path dataLocation){
        List<Data_OtherRenewables> Data_OtherRenewables = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double otherRenewables = Double.parseDouble(column[6]);
                Data_OtherRenewables.add(new Data_OtherRenewables(year, otherRenewables));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_OtherRenewables;
    }

    private List<Data_Hydropower> readCSV_Hydropower(Path dataLocation){
        List<Data_Hydropower> Data_Hydropower = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double hydropower = Double.parseDouble(column[7]);
                Data_Hydropower.add(new Data_Hydropower(year, hydropower));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_Hydropower;
    }
    private List<Data_Nuclear> readCSV_Nuclear(Path dataLocation){
        List<Data_Nuclear> Data_Nuclear = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                double year = Double.parseDouble(column[0]);
                double nuclear = Double.parseDouble(column[8]);
                Data_Nuclear.add(new Data_Nuclear(year, nuclear));
                line = br.readLine();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }
        return Data_Nuclear;
    }
    
}
