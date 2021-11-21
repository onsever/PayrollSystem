public class Motorcycle extends Vehicle {
    private int engine;
    private int power;

    public Motorcycle(String make, String plate, int engine, int power) {
        super(make, plate);
        this.engine = engine;
        this.power = power;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void printMyData() {
        System.out.println("\t - " + getEngine() + "cc");
        System.out.println("\t - " + getPower() + "hp");
    }
}
