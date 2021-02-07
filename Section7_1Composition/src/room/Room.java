package room;

public class Room {
    private AirConditioner airConditioner;
    private Heater heater;
    private Lamp lamp;
    private Window window;

    public Room(AirConditioner airConditioner, Heater heater, Lamp lamp, Window window) {
        this.airConditioner = airConditioner;
        this.heater = heater;
        this.lamp = lamp;
        this.window = window;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    public Heater getHeater() {
        return heater;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public Window getWindow() {
        return window;
    }

    public void niceAtmosphere() {
        lamp.setOn(true);
        window.setOpen(true);
    }

    public void darkAtmosphere() {
        lamp.setOn(false);
        window.setOpen(false);
    }

    public void heatUp() {
        airConditioner.setCooling(false);
        heater.setHeating(true);
    }

    public void coolDown() {
        airConditioner.setCooling(true);
        heater.setHeating(false);
    }
}
