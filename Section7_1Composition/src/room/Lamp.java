package room;

public class Lamp {
    private boolean isOn;

    public Lamp(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void light() {
        if (isOn) {
            System.out.println("The room is bright");
        } else {
            System.out.println("The room is dark");
        }
    }
}
