package edu.guilford;

public class Data_Nuclear {
    private double year;
    private double nuclear;

    public Data_Nuclear(double year, double nuclear) {
        this.year = year;
        this.nuclear = nuclear;
    }

    public double getYear() {
        return year;
    }
    public double getNuclear() {
        return nuclear;
    }
    public void setYear(double year) {
        this.year = year;
    }
    public void setNuclear(double nuclear) {
        this.nuclear = nuclear;
    }

    @Override
    public String toString() {
        return "Data_Nuclear{" +
                "year=" + year +
                ", nuclear=" + nuclear +
                '}';
    }

}
