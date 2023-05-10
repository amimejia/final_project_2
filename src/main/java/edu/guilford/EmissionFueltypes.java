package edu.guilford;

public class EmissionFueltypes extends EmissionYear{
    private double coal;

    //Constructor
    public EmissionFueltypes(double year, double coal) {
        super(year);
        this.coal = coal;
    }

    //Getter
    public double getCoal() {
        return coal;
    }
    public double setCoal(double coal) {
        return this.coal = coal;
    }

    //toString
    @Override
    public String toString() {
        return "EmissionFueltypes{" +
                "coal=" + coal +
                '}';
    }

}
