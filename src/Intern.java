public class Intern extends Employee {
    private String schoolName;

    public Intern(String name, int age, Vehicle vehicle, String schoolName) {
        super(name, age, vehicle);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public int calcBirthYear() {
        return 2021 - getAge();
    }

    @Override
    public double calcEarnings() {
        return 1000.0;
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

        System.out.println("Employee is Intern");
        System.out.println("\t - School Name: " + getSchoolName());
        System.out.println("\t - Earnings: " + calcEarnings());
        System.out.println("-----------------------------------------------------------------------------");
    }
}
