package edu.guilford;

public class Data_NaturalGas {
    private double year;
    private double naturalgas;

    //Constructor
    public Data_NaturalGas(double year, double naturalgas) {
        this.year = year;
        this.naturalgas = naturalgas;
    }

    //Getters and Setters
    public double getYear() {
        return year;
    }
    public double getNaturalgas() {
        return naturalgas;
    }
    public void setYear(double year) {
        this.year = year;
    }
    public void setNaturalgas(double naturalgas) {
        this.naturalgas = naturalgas;
    }

    //toString
    @Override
    public String toString() {
        return "Data_NaturalGas{" +
                "year=" + year +
                ", naturalgas=" + naturalgas +
                '}';
    }
}
