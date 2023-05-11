package edu.guilford;
/**
 * Class to hold the data for the traditional biofuel consumption
 * @param year
 * @param traditionalbiofuel
 * @return toString
 */
public class Data_TraditionalBiofuel {
    private double year;
    private double traditionalbiofuel;

    public Data_TraditionalBiofuel(double year, double traditionalbiofuel) {
        this.year = year;
        this.traditionalbiofuel = traditionalbiofuel;
    }

    //Getters and Setters
    public double getYear() {
        return year;
    }
    public double getTraditionalbiofuel() {
        return traditionalbiofuel;
    }
    public void setYear(double year) {
        this.year = year;
    }
    public void setTraditionalbiofuel(double traditionalbiofuel) {
        this.traditionalbiofuel = traditionalbiofuel;
    }

    //toString
    @Override
    public String toString() {
        return "TraditionalBiofuel{" +
                "year=" + year +
                ", traditionalbiofuel=" + traditionalbiofuel +
                '}';
    }
}
