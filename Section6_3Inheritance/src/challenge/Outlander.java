package challenge;

/**
 * This was a really bad challenge. The definition on what to do was unclear.
 * Creating an Outlander as class instead of instance of the Car-Class seems to be wrong in my opinion.
 * Accelerate seems to belong to car rather to Outlander, all Car's can accelerate, can't they?
 */
public class Outlander extends Car {
    private int roadServiceMonths;

    public Outlander(int roadServiceMonths) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate) {
        int newSpeed = getSpeed() + rate;
        if (newSpeed <= 0) {
            stop();
            changeGear(1);
        } else if (newSpeed <= 10) {
            changeGear(1);
        } else if (newSpeed > 50) {
            changeGear(6);
        } else {
            changeGear(newSpeed / 10);
        }

        if (newSpeed > 0) {
            changeSpeed(newSpeed, getDirection());
        }
    }
}
