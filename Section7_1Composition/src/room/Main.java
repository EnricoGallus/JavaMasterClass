package room;

public class Main {
    public static void main(String[] args) {
        AirConditioner conditioner = new AirConditioner(false);
        Heater heater = new Heater(false);
        Lamp lamp = new Lamp(false);
        Window window = new Window(false);

        Room room = new Room(conditioner, heater, lamp, window);

        room.getAirConditioner().cooling();
        room.getWindow().airCirculate();

        room.remoteAccess(true);
    }
}
