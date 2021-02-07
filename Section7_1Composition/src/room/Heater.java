package room;

public class Heater {
    private boolean isHeating;

    public Heater(boolean isHeating) {
        this.isHeating = isHeating;
    }

    public boolean isHeating() {
        return isHeating;
    }

    public void setHeating(boolean heating) {
        isHeating = heating;
    }

    public void heating() {
        if (isHeating) {
            System.out.println("It is getting warmer");
        } else {
            System.out.println("Heater is off");
        }
    }
}
