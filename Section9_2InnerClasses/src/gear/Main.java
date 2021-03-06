package gear;

public class Main {
    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);
        /*gear.Gearbox.Gear second = new gear.Gearbox.Gear(2, 15.4);
        gear.Gearbox.Gear third = new mcLaren.Gear(3, 17.8);*/
        /*System.out.println(first.driveSpeed(1000));*/
        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));
    }
}
