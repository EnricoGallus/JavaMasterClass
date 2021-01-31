public class DayOfTheWeek {
    public static void main(String[] args) {
        printDayOfTheWeek(0);
        printDayOfTheWeek(10);
    }

    public static void printDayOfTheWeek(int day) {
        System.out.println(day + " = " + getDayName(day));
    }

    private static String getDayName(int day) {
        switch (day) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Invalid day";
        }
    }
}
