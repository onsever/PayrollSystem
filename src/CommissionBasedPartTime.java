public class CommissionBasedPartTime extends PartTime {
    private double commission;

    public CommissionBasedPartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked, double commission) {
        super(name, age, vehicle, rate, hoursWorked);
        this.commission = commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }


    @Override
    public int calcBirthYear() {
        return 2021 - super.getAge();
    }

    @Override
    public double calcEarnings() {
        double rate = super.getRate();
        double hoursWorked = super.getHoursWorked();
        double total = rate * hoursWorked;
        double commission = total + (total * getCommission());
        return commission;
    }

    @Override
    public void printMyData() {
        System.out.println("Name: " + getName());
        System.out.println("Year of Birth: " + calcBirthYear());

        if (getVehicle() == null) {
            System.out.println("Employee has no Vehicle registered");
        }
        else {
            System.out.println("Employee has a " + getVehicle().getClass());
            System.out.println("\t - " + getVehicle().getMake());
            System.out.println("\t - " + getVehicle().getPlate());
            getVehicle().printMyData();

        }

        System.out.println("Employee is Part Time / Commissioned");
        System.out.println("\t - Rate: " + getRate());
        System.out.println("\t - Hours Worked: " + getHoursWorked());
        System.out.println("\t - Commission: " + getCommission() * 100 + "%");
        System.out.println("\t - Earnings: " + calcEarnings());
        System.out.println("-----------------------------------------------------------------------------");
    }
}
