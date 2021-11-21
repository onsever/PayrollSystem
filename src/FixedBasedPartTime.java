public class FixedBasedPartTime extends PartTime {
    private double fixedAmount;

    public FixedBasedPartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked, double fixedAmount) {
        super(name, age, vehicle, rate, hoursWorked);
        this.fixedAmount = fixedAmount;
    }

    public double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }


    @Override
    public int calcBirthYear() {
        return 2021 - super.getAge();
    }

    @Override
    public double calcEarnings() {
        double rate = super.getRate();
        double hoursWorked = super.getHoursWorked();
        return (rate * hoursWorked) + getFixedAmount();
    }

    @Override
    public void printMyData() {
        System.out.println("Name: " + getName());
        System.out.println("Year of Birth: " + calcBirthYear());

        if (getVehicle() == null) {
            System.out.println("Employee has no Vehicle registered");
        }
        else {
            System.out.println("Employee has a " + getVehicle().getClass().getName());
            System.out.println("\t - " + getVehicle().getMake());
            System.out.println("\t - " + getVehicle().getPlate());
            getVehicle().printMyData();

        }

        System.out.println("Employee is Part Time / Fixed Amount");
        System.out.println("\t - Rate: " + getRate());
        System.out.println("\t - Hours Worked: " + getHoursWorked());
        System.out.println("\t - Fixed Amount: " + getFixedAmount());
        System.out.println("\t - Earnings: " + calcEarnings());
        System.out.println("-----------------------------------------------------------------------------");
    }
}
