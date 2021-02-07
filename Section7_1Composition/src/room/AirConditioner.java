package room;

public class AirConditioner {
    private boolean isCooling;

    public AirConditioner(boolean isCooling) {
        this.isCooling = isCooling;
    }

    public boolean isCooling() {
        return isCooling;
    }

    public void setCooling(boolean cooling) {
        isCooling = cooling;
    }

    public void cooling() {
        if (isCooling) {
            System.out.println("It is getting cooler.");
        } else {
            System.out.println("Cooler is off.");
        }
    }
}
