public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        boolean shouldWakeUp = false;
        if (hourOfDay < 0 || hourOfDay > 23) {
            shouldWakeUp = false;
        } else if (hourOfDay < 8 || hourOfDay > 22) {
            shouldWakeUp = barking;
        }

        return shouldWakeUp;
    }
}
