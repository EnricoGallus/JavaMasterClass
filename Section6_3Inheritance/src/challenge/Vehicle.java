package challenge;

public class Vehicle {
    private String name;
    private String size;

    private int speed;
    private int direction;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;
        this.speed = 0;
        this.direction = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void steer(int direction) {
        this.direction += direction;
        System.out.println("Vehicle.steer(): Steering at " + direction + " degrees.");
    }

    public void move(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
        System.out.println("Vehicle.move(): Moving at " + speed + " in direction " + direction);
    }

    public void stop() {
        this.speed = 0;
    }
}
