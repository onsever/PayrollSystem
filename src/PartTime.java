abstract public class PartTime extends Employee implements IPrintable {
    private double rate;
    private double hoursWorked;

    public PartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked) {
        super(name, age, vehicle);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
