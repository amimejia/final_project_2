package edu.guilford;

public class Data_Hydropower {
    private double year;
    private double hydropower;

    public Data_Hydropower(double year, double hydropower) {
        this.year = year;
        this.hydropower = hydropower;
    }

    public double getYear() {
        return year;
    }
    public double getHydropower() {
        return hydropower;
    }
    public void setYear(double year) {
        this.year = year;
    }
    public void setHydropower(double hydropower) {
        this.hydropower = hydropower;
    }

    @Override
    public String toString() {
        return "Data_Hydropower{" +
                "year=" + year +
                ", hydropower=" + hydropower +
                '}';
    }
    
}
