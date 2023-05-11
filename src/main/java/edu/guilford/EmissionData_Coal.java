package edu.guilford;


public class EmissionData_Coal {
    private double year;
    private double coal;

    public EmissionData_Coal(double year, double coal) {
        this.year = year;
        this.coal = coal;
    }

    //Getters and Setters
    public double getYear() {
        return year;
    }
    public double getCoal() {
        return coal;
    }

    public void setYear(double year) {
        this.year = year;
    }
    public void setCoal(double coal) {
        this.coal = coal;
    }

    @Override
    public String toString() {
        return "EmissionData_Coal{" +
                "year=" + year +
                ", coal=" + coal +
                '}';
    }
}
