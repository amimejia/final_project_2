package edu.guilford;

public class Data_Solar {
    private double year;
    private double solar;

    public Data_Solar(double year, double solar) {
        this.year = year;
        this.solar = solar;
    }

    //Getters and Setters
    public double getYear() {
        return year;
    }
    public double getSolar() {
        return solar;
    }

    @Override
    public String toString() {
        return "Data_Solar{" +
                "year=" + year +
                ", solar=" + solar +
                '}';
    }
}
