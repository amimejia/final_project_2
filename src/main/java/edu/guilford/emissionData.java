package edu.guilford;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

//import javax.swing.DefaultBoundedRangeModel;

public class emissionData {
    private String year;
    private double coal;
    private double solar;
    private double crudeOil;
    private double naturalGas;
    private double traditionalBiofuels;
    private double otherRenewables;
    private double hydropower;
    private double nuclear;
    //private double fuelType;
    //private Path dataLocation;


    //Constructor
    public emissionData(String year, double coal, double solar, double crudeOil, double naturalGas,
            double traditionalBiofuels, double otherRenewables, double hydropower, double nuclear) {
    }
    //Constructor
    public emissionData(){

        // try {
        //     dataLocation = Paths.get(Emission_Final_Project.class.getResource("/edu/guilford/cleaned_emissions_past_future.csv").toURI());
        // } catch (URISyntaxException e) {
        //     e.printStackTrace();
        //}
        // try {
        //         dataLocation = Paths.get(Emission_Final_Project.class.getResource("/edu/guilford/cleaned_emissions_past_future.csv").toURI());
        //     } catch (URISyntaxException e) {
        //         e.printStackTrace();
        //     }
        //     readCSV(dataLocation);
    }

    //Getters and setters
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public double getCoal() {
        return coal;
    }
    public void setCoal(double coal) {
        this.coal = coal;
    }
    public double getSolar() {
        return solar;
    }
    public void setSolar(double solar) {
        this.solar = solar;
    }
    public double getCrudeOil() {
        return crudeOil;
    }
    public void setCrudeOil(double crudeOil) {
        this.crudeOil = crudeOil;
    }
    public double getNaturalGas() {
        return naturalGas;
    }
    public void setNaturalGas(double naturalGas) {
        this.naturalGas = naturalGas;
    }
    public double getTraditionalBiofuels() {
        return traditionalBiofuels;
    }
    public void setTraditionalBiofuels(double traditionalBiofuels) {
        this.traditionalBiofuels = traditionalBiofuels;
    }
    public double getOtherRenewables() {
        return otherRenewables;
    }
    public void setOtherRenewables(double otherRenewables) {
        this.otherRenewables = otherRenewables;
    }
    public double getHydropower() {
        return hydropower;
    }
    public void setHydropower(double hydropower) {
        this.hydropower = hydropower;
    }
    public double getNuclear() {
        return nuclear;
    }
    public void setNuclear(double nuclear) {
        this.nuclear = nuclear;
    }

    // @Override
    // public List<emissionData> readCSV(Path dataLocation) {
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
