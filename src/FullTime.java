public class FullTime extends Employee {
    private double salary;
    private double bonus;

    public FullTime(String name, int age, Vehicle vehicle, double salary, double bonus) {
        super(name, age, vehicle);
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public int calcBirthYear() {
        return 2021 - super.getAge();
    }

    @Override
    public double calcEarnings() {
        return getSalary() + getBonus();
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

        System.out.println("Employee is Full Time");
        System.out.println("\t - Salary: " + getSalary());
        System.out.println("\t - Bonus: " + getBonus());
        System.out.println("\t - Earnings: " + calcEarnings());
        System.out.println("-----------------------------------------------------------------------------");
    }
}
