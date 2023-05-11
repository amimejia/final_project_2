package edu.guilford;

public class Data_OtherRenewables {
    private double year;
    private double otherRenewables;

    public Data_OtherRenewables(double year, double otherRenewables) {
        this.year = year;
        this.otherRenewables = otherRenewables;
    }

    public double getYear() {
        return year;
    }
    public double getOtherRenewables() {
        return otherRenewables;
    }

    public void setYear(double year) {
        this.year = year;
    }
    public void setOtherRenewables(double otherRenewables) {
        this.otherRenewables = otherRenewables;
    }

    @Override
    public String toString() {
        return "Data_OtherRenewables{" +
                "year=" + year +
                ", otherRenewables=" + otherRenewables +
                '}';
    }
}
