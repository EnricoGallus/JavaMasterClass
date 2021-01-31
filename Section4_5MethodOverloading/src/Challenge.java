public class Challenge {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeter(6, 0));
        System.out.println(calcFeetAndInchesToCentimeter(7, 5));
        System.out.println(calcFeetAndInchesToCentimeter(-10, 0));
    }

    public static double calcFeetAndInchesToCentimeter(int feet, int inches) {
        if (feet < 0 || inches < 0 || inches > 12) {
            System.out.println("Invalid feet ot inches parameter");
            return -1d;
        }

        return calcFeetAndInchesToCentimeter(feet * 12 + inches);
    }

    public static double calcFeetAndInchesToCentimeter(int inches) {
        if (inches < 0) {
            System.out.println("Invalid inches parameter");
            return -1d;
        }

        return inches * 2.54d;
    }
}
