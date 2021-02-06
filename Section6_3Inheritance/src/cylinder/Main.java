package cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1.6);
        System.out.println("Circle Area: " + circle.getArea());

        Cylinder cylinder = new Cylinder(1.6, 8.2);
        System.out.println("Cylinder Area: " + cylinder.getArea());
        System.out.println("Cylinder Volume: " + cylinder.getVolume());
    }
}
