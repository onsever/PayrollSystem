public class Car extends Vehicle {
    private String color;
    private String type;

    public Car(String make, String plate, String color, String type) {
        super(make, plate);
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void printMyData() {
        System.out.println("\t - " + getColor());
        System.out.println("\t - " + getType());
    }
}
