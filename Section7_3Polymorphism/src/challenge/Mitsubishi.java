package challenge;

public class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String brake() {
        return "Mitsubishi  -> brake()";
    }
}
