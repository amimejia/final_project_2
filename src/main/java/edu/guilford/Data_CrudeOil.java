package edu.guilford;

public class Data_CrudeOil {
    private double year;
    private double crudeoil;

    //Constructor
    public Data_CrudeOil(double year, double crudeoil) {
        this.year = year;
        this.crudeoil = crudeoil;
    }

    //Getters and Setters
    public double getYear() {
        return year;
    }
    public double getCrudeoil() {
        return crudeoil;
    }
    public void setYear(double year) {
        this.year = year;
    }
    public void setCrudeoil(double crudeoil) {
        this.crudeoil = crudeoil;
    }

    //toString
    @Override
    public String toString() {
        return "Data_CrudeOil{" +
                "year=" + year +
                ", crudeoil=" + crudeoil +
                '}';
    }
}
