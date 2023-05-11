package edu.guilford;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.XYChart;

public class Fueltype_List {

    private Path dataLocation;
    private double[] year;
    private double[] fueltype;
    private ArrayList<XYChart.Data<Double, Double>> coalData;
    private ArrayList<XYChart.Data<Double, Double>> solarData;
    private ArrayList<XYChart.Data<Double, Double>> crudeOilData;
    private ArrayList<XYChart.Data<Double, Double>> naturalGasData;
    private ArrayList<XYChart.Data<Double, Double>> traditionalBiofuels;
    private ArrayList<XYChart.Data<Double, Double>> hydropowerData;
    private ArrayList<XYChart.Data<Double, Double>> nuclearData;


    public Fueltype_List(double[] year, double[] fueltype) {
        this.year = year;
        this.fueltype = fueltype;
    }
    public Fueltype_List(){
        List<Fueltype_List> Fueltype_List = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(dataLocation.toFile()));
            // .readLine() reads the first line of the csv file
            br.readLine();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                //String[] column = line.split(",");
                //Create a loop that will parseDouble and create arraylists for each column keeping year as index and fueltype as value
                while (line != null) {
                    String[] column = line.split(",");
                    for (int i = 0; i < column.length; i++) {
                        year[i] = Double.parseDouble(column[0]);
                        fueltype[i] = Double.parseDouble(column[1]);
                    }
                    //make a new arraylist for each fueltype
                    //add the year and fueltype to the arraylist
                    for (int i = 0; i < column.length; i++) {
                        if (fueltype[i] == 1) {
                            ArrayList<XYChart.Data<Double, Double>> coalData = new ArrayList<>();
                            coalData.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                        if (fueltype[i] == 2) {
                            ArrayList<XYChart.Data<Double, Double>> solarData = new ArrayList<>();
                            solarData.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                        if (fueltype[i] == 3) {
                            ArrayList<XYChart.Data<Double, Double>> crudeOilData = new ArrayList<>();
                            crudeOilData.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                        if (fueltype[i] == 4) {
                            ArrayList<XYChart.Data<Double, Double>> naturalGasData = new ArrayList<>();
                            naturalGasData.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                        if (fueltype[i] == 5) {
                            ArrayList<XYChart.Data<Double, Double>> traditionalBiofuels = new ArrayList<>();
                            traditionalBiofuels.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                        if (fueltype[i] == 6) {
                            ArrayList<XYChart.Data<Double, Double>> hydropowerData = new ArrayList<>();
                            hydropowerData.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                        if (fueltype[i] == 7) {
                            ArrayList<XYChart.Data<Double, Double>> nuclearData = new ArrayList<>();
                            nuclearData.add(new XYChart.Data<>((year[i]), fueltype[i]));
                        }
                    }
                }
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new IOError(e);
        }

    }

    //Getters and Setters
    public double[] getYear() {
        return year;
    }
    public double[] getFueltype() {
        return fueltype;
    }

    public void setYear(double[] year) {
        this.year = year;
    }
    public void setFueltype(double[] fueltype) {
        this.fueltype = fueltype;
    }
    //Make a getter and setter for each fueltype arraylist
    public ArrayList<XYChart.Data<Double, Double>> getCoalData() {
        return coalData;
    }
    public void setCoalData(ArrayList<XYChart.Data<Double, Double>> coalData) {
        this.coalData = coalData;
    }

    @Override
    public String toString() {
        return "Fueltype_List{" +
                "year=" + year +
                ", fueltype=" + fueltype +
                '}';
    }


    //private List<Fueltype_List> readCSV_fueltype(Path dataLocation) {
        // List<Fueltype_List> Fueltype_List = new ArrayList<>();
        // BufferedReader br = null;
        // String line = "";
        // try {
        //     br = new BufferedReader(new FileReader(dataLocation.toFile()));
        //     // .readLine() reads the first line of the csv file
        //     br.readLine();
        //     line = br.readLine();
        //     while ((line = br.readLine()) != null) {
        //         //String[] column = line.split(",");
        //         //Create a loop that will parseDouble and create arraylists for each column keeping year as index and fueltype as value
        //         while (line != null) {
        //             String[] column = line.split(",");
        //             for (int i = 0; i < column.length; i++) {
        //                 year[i] = Double.parseDouble(column[0]);
        //                 fueltype[i] = Double.parseDouble(column[1]);
        //             }
        //             //make a new arraylist for each fueltype
        //             //add the year and fueltype to the arraylist
        //             for (int i = 0; i < column.length; i++) {
        //                 if (fueltype[i] == 1) {
        //                     ArrayList<XYChart.Data<Double, Double>> coalData = new ArrayList<>();
        //                     coalData.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //                 if (fueltype[i] == 2) {
        //                     ArrayList<XYChart.Data<Double, Double>> solarData = new ArrayList<>();
        //                     solarData.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //                 if (fueltype[i] == 3) {
        //                     ArrayList<XYChart.Data<Double, Double>> crudeOilData = new ArrayList<>();
        //                     crudeOilData.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //                 if (fueltype[i] == 4) {
        //                     ArrayList<XYChart.Data<Double, Double>> naturalGasData = new ArrayList<>();
        //                     naturalGasData.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //                 if (fueltype[i] == 5) {
        //                     ArrayList<XYChart.Data<Double, Double>> traditionalBiofuels = new ArrayList<>();
        //                     traditionalBiofuels.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //                 if (fueltype[i] == 6) {
        //                     ArrayList<XYChart.Data<Double, Double>> hydropowerData = new ArrayList<>();
        //                     hydropowerData.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //                 if (fueltype[i] == 7) {
        //                     ArrayList<XYChart.Data<Double, Double>> nuclearData = new ArrayList<>();
        //                     nuclearData.add(new XYChart.Data<>((year[i]), fueltype[i]));
        //                 }
        //             }
        //         }
        //     }
        //     if (br != null) {
        //         br.close();
        //     }
        // } catch (IOException e) {
        //     throw new IOError(e);
        // }
        
}
