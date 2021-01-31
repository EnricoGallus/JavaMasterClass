public class SecondsAndMinutesChallenge {
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        getDurationString(65, 45);
        getDurationString(3945);
        getDurationString(61);
        getDurationString(-41);
        getDurationString(65, 9);

    }

    public static void getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 60) {
            System.out.println(INVALID_VALUE_MESSAGE);
            return;
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        String value = (hours < 10 ? "0" : "") + hours + "h "
                + (remainingMinutes < 10 ? "0" : "") + remainingMinutes + "m "
                + (seconds < 10 ? "0" : " ") + seconds + "s";
        System.out.println(value);
    }

    public static void getDurationString(int seconds) {
        if (seconds < 0) {
            System.out.println(INVALID_VALUE_MESSAGE);
            return;
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        getDurationString(minutes, remainingSeconds);
    }
}
